
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package animationgui;

import animationgui.Animation;
import commands.*;
import fruitninjagame.Game;
import fruitninjagame.GameController;
import fruitninjagame.IGameObject;
import fruitninjagame.Player;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DragGestureEvent;
import java.awt.dnd.DragSource;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.*;

/**
 *
 * @author MIX
 */
public class Panel extends JPanel implements MouseListener, MouseMotionListener {

    ImageIcon background;
    static JLabel scoreLbl;
    static JLabel highscore;
     JLabel timerLbl;
     JLabel timePlayedLbl;
    Animation a;
    Point pressed;
    Point release;
    int timeInterval;
    boolean dragging = false;
    private static Timer timer;
    static Timer t;
    static Panel panel;

    public Panel() {
        
        panel = this;
        setLayout(null);
        scoreLbl = new JLabel(Player.playerState());

        highscore = new JLabel(Game.getInstance().getHighScore().toString());
        timerLbl = new JLabel();
        timePlayedLbl = new JLabel("Time Played: ");
        scoreLbl.setBounds(20, 5, 250, 80);
        highscore.setBounds(950, 5, 300, 40);
        timePlayedLbl.setBounds(400,5,250,40);
        timerLbl.setBounds(630,5,100,40);
        scoreLbl.setFont(new Font("Verdana", Font.BOLD, 30));
        highscore.setFont(new Font("Verdana", Font.BOLD, 30));
        timerLbl.setFont(new Font("Verdana", Font.BOLD, 30));
        scoreLbl.setFont(new Font("Verdana", Font.BOLD, 30));
        timePlayedLbl.setFont(new Font("Verdana", Font.BOLD, 30));
        Date start = new Date(System.currentTimeMillis() + 3600 * 2000);
        start.setTime(start.getTime()-Player.getInstance().getState().getTime());
        Timer timer = new Timer(1000, new ActionListener(){
            @Override
           public void actionPerformed(ActionEvent e) {
                SimpleDateFormat sdf= new SimpleDateFormat("mm:ss");;
                Date now = new Date();
                String time = sdf.format(now.getTime()-start.getTime());
                Player.getInstance().getState().setTime(now.getTime()-start.getTime());
                String playerTime = sdf.format(Player.getInstance().getState().getTime());
                timerLbl.setText( new String(sdf.format(Player.getInstance().getState().getTime())));
            }
        });
        
        add(scoreLbl);
        add(timerLbl);
        add(timePlayedLbl);
        add(highscore);
       
        background = new ImageIcon("background.jpg");
        addMouseListener(this);
        addMouseMotionListener(this);

        

        timeInterval = GameController.getInstance().getStrategy().getTimeInterval();
         t = new Timer(timeInterval, new ActionListener() {

            public void actionPerformed(ActionEvent event) {
               
                timeInterval = GameController.getInstance().getStrategy().getTimeInterval();
                IGameObject g = GameController.getInstance().createGameObject();
                Game.getInstance().getGameObjects().add(g);

            }
        });
        t.start();
        timer.start();

    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(background.getImage(), 0, 0, null);
        for (IGameObject game : GameController.getInstance().getGame().getGameObjects()) {
            if (game != null) {
                game.getAnimation().doDrawing(g);
            }
        }

    }

    public void AnimateOne() {
        for (IGameObject game : GameController.getInstance().getGame().getGameObjects()) {
            if (game != null) {
                game.getAnimation().update();
            }
        }

        repaint();
    }

    public static Panel getPanel() {
        return panel;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        Point point = e.getPoint();
        for (IGameObject g : Game.getInstance().getGameObjects()) {
            if (point != null && g != null) {
                if ((point.x < g.getXlocation() && point.x >= g.getXlocation() + g.getImage().getIconWidth()) || (point.x > g.getXlocation() && point.x <= g.getXlocation() + g.getImage().getIconWidth())) {
                    if (point.y > g.getYlocation() && point.y <= g.getYlocation() + g.getImage().getIconHeight()) {
                          Player.getInstance().setCommand(new SliceCommand(g));
                          Player.getInstance().pressButton();
                    }
                }
            }

            updateStatus();
            

        }}

        @Override
        public void mouseMoved
        (MouseEvent e
        
        ) {
    }

    

    public static void updateStatus() {
        scoreLbl.setText(Player.playerState());
         if(Player.getInstance().getState().getLives()==0)
        {   Panel.endGame();
            Panel.stopTimer();
        }
    }
    public static void updateHighscore() {
        highscore.setText(Game.getInstance().getHighScore().toString());
    }
    public static void stopTimer() {
        if(timer!=null&&t!=null)
        { timer.stop();
        t.stop();}
    }
    public static void endGame()
    {      
            new GameOverPanel();
            Frame.getFrame().add(GameOverPanel.getPanel());
            Frame.getFrame().setContentPane(GameOverPanel.getPanel());
    }
}
