/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fruitninjagame;

import commands.ICommand;
import commands.SliceCommand;


/**
 *
 * @author MIX
 */
public class Player  {

    private static Player instance;
    private boolean reachHighScore;
    private State state; 
    private ICommand command;
     public void setCommand(ICommand command)
     {
         this.command=command;
     }
    public void pressButton()
    {
        command.execute();
        
    }

    public boolean isReachHighScore() {
		return reachHighScore;
	}

	public void setReachHighScore(boolean reachHighScore) {
		this.reachHighScore = reachHighScore;
	}

	private Player() {
    	reachHighScore = false;
        state=new State();
    }

    public static Player getInstance() {
        if (instance == null) {
            instance = new Player();
        }
        return instance;
    }


    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }
    public Memento save(){
        return new Memento(state);
    }

    public void load(Memento memento){
        state = memento.getState();
    }

     public static String playerState()
    {
        return GameController.getInstance().getGame().getPlayer().getState().toString();
    }
     public void ReachedHighScore(boolean r) {
    	 this.reachHighScore=r;
     }
     public void restPlayer() {
    	 reachHighScore=false;
    	 state.setLives(3);
    	 state.setScore(0);
     }
}