/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fruitninjagame;

import animationgui.Frame;
import animationgui.GameOverPanel;
import animationgui.Panel;
import commands.SaveCommand;
import gamestrategy.MediumStrategy;
import gamestrategy.HardStrategy;
import gamestrategy.IGameStrategy;
import gamestrategy.EasyStrategy;
import java.awt.Point;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import jdk.nashorn.internal.runtime.regexp.JoniRegExp;

/**
 *
 * @author MIX
 */
public class GameController implements IGameActions {

    private static GameController instance;
    private Game game;
    private IGameStrategy strategy;
    private Memento memento;

    private GameController() {
        game = Game.getInstance();
        setStrategy();
        // initially read the last high Score
        readHighScore();
    }

    public static GameController getInstance() {
        if (instance == null) {
            instance = new GameController();
        }
        return instance;
    }

    public Game getGame() {
        return game;
    }

    public void updateLives(IGameObject g) {
        if (!g.isSliced() && g.hasMovedOffScreen()) {
            if (g.getObjectType() == 0 || g.getObjectType() == 3 || g.getObjectType() == 4) {
                game.getPlayer().getState().setLives(game.getPlayer().getState().getLives() - 1);
                g = null;
            } else {
                g = null;
            }
        }
        saveGame();
       

    }

    @Override
    public IGameObject createGameObject() {
        Random rand = new Random();

        IGameObject g = FactoryOfGameObjects.getInstance().getObject(rand.nextInt(44));

        return g;

    }

    @Override
    public void sliceObjects(IGameObject g) {

        if (!g.isSliced()) {
            g.slice();
            if (g.getObjectType() == 1) {
                game.getPlayer().getState().setLives(game.getPlayer().getState().getLives() - 1);
            } else if (g.getObjectType() == 0) {
                game.getPlayer().getState().setScore(game.getPlayer().getState().getScore() + 1);
            } else if (g.getObjectType() == 2) {
                game.getPlayer().getState().setLives(0);
            } else if (g.getObjectType() == 3) {
                game.getPlayer().getState().setScore(game.getPlayer().getState().getScore() + 25);
            } else if (g.getObjectType() == 4) {
                game.getPlayer().getState().setLives(game.getPlayer().getState().getLives() + 1);
            }
            setStrategy();
            saveGame();
            

        }
// Player has Reached the high score
        if (game.getPlayer().getState().getScore() > game.getHighScore().getHighScore())
        {   if(game.getPlayer().isReachHighScore() == false) {
            game.getPlayer().setReachHighScore(true);
        }  
          game.getHighScore().setHighScore(game.getPlayer().getState().getScore());
          Panel.updateHighscore();
          updateHighScore(game.getPlayer().getState().getScore());
        }
        // Player has Reached the high score and Game Over
        if (game.getPlayer().getState().getLives() == 0 && game.getPlayer().isReachHighScore()) {
            updateHighScore(game.getPlayer().getState().getScore());
            //System.exit(0);
        }
    }

    public void setStrategy() {
        if (game.getPlayer().getState().getScore() >= 0 && game.getPlayer().getState().getScore() < 20) {
            strategy = new EasyStrategy();
        } else if (game.getPlayer().getState().getScore() >= 20 && game.getPlayer().getState().getScore() < 50) {
            strategy = new MediumStrategy();
        } else if (game.getPlayer().getState().getScore() >= 50) {
            strategy = new HardStrategy();
        }
    }

    public IGameStrategy getStrategy() {
        return this.strategy;
    }

   
	@Override
	public void saveGame() {
		try {   memento=Player.getInstance().save();
			JAXBContext jaxbContext = JAXBContext.newInstance(State.class);
			Marshaller marshaller = jaxbContext.createMarshaller();
			OutputStream os = new FileOutputStream("Save.xml");
			marshaller.marshal(memento.getState(), os);
		} catch (JAXBException e) {
			JOptionPane.showMessageDialog(null, "An error occurred!!");
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(null, "An error occurred!!");
			e.printStackTrace();
		}
	}

	@Override
	public void loadGame() {
		try {   
			File inputFile = new File("save.xml");
			JAXBContext jaxbContext = JAXBContext.newInstance(State.class);
			Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
			memento=new Memento((State)unmarshaller.unmarshal(inputFile));
                        Player.getInstance().load(memento);
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "File not found");
			System.out.println(e.getMessage());
			
		}
	}

    @Override
    public void ResetGame() {
        File file = new File("save.xml"); 
        game.getHighScore().setHighScore(0);
        updateHighScore(game.getHighScore().getHighScore());
         try{
        file.delete();}
    catch (Exception e) {
			JOptionPane.showMessageDialog(null, "File not found");
			System.out.println(e.getMessage());
			
		}}

    public void readHighScore() {
        JAXBContext jaxbcontext;
        Unmarshaller unmarshaller;
        try {
            jaxbcontext = JAXBContext.newInstance(HighScore.class);
            unmarshaller = jaxbcontext.createUnmarshaller();
            HighScore highScore = (HighScore) unmarshaller.unmarshal(new File("HighScore.xml"));
            game.setHighScore(highScore);

        } catch (JAXBException e) {
            e.printStackTrace();
        }

    }

    public void updateHighScore(int newHighScore) {
        JAXBContext jaxbcontext;
        try {
            jaxbcontext = JAXBContext.newInstance(HighScore.class);
            Marshaller marshaller = jaxbcontext.createMarshaller();
            game.getHighScore().setHighScore(newHighScore);
            marshaller.marshal(game.getHighScore(), new File("HighScore.xml"));
        } catch (JAXBException e) {

            e.printStackTrace();
        }

    }
    public void resetAll() {
    	
    	game.resetGame();
    	
    }

}
