/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fruitninjagame;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author MIX
 */
//@XmlRootElement(name = "HighScore")
//@XmlAccessorType(XmlAccessType.FIELD)
public class Game {

	// @XmlElement(name = "highScore")
	private HighScore highScore;
	private Player player;
	private static Game instance;
	private ArrayList<IGameObject> gameObjects;

	private Game() {
		player = Player.getInstance();
		gameObjects = new ArrayList();
	}

	public static Game getInstance() {
		if (instance == null)
			instance = new Game();
		return instance;
	}

	public Player getPlayer() {
		return player;
	}

	public ArrayList<IGameObject> getGameObjects() {
		return gameObjects;
	}

	public HighScore getHighScore() {
		return highScore;
	}

	public void setHighScore(HighScore highScore) {
		this.highScore = highScore;
	}

	public static void destroy() {
		instance = null;
	}
	public void setPlayer(Player player) {
		this.player=player;
	}

	public void setGameObjects(ArrayList<IGameObject> gameObjects) {
		this.gameObjects = gameObjects;
	}
	public void resetGame() {
		player.restPlayer();
		gameObjects=null;
		
	}

}
