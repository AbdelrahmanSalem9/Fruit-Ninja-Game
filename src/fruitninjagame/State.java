/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fruitninjagame;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

/**
 *
 * @author MIX
 */
@XmlRootElement (name = "State")
@XmlAccessorType (XmlAccessType.FIELD)
public class State {
    @XmlElement(name = "Score")
    private int score;
    @XmlElement(name = "Lives")
    private int lives;
    @XmlElement(name = "Time")
    private long time;

    public State() {
        this.score = 0;
        this.lives = 3;
        this.time = 0;
    }
    

    public void setScore(int score) {
        this.score = score;
    }

    public void setLives(int lives) {
        this.lives = lives;
    }

    public int getScore() {
        return score;
    }

    public int getLives() {
        return lives;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return String.format("<html>Score: %d <br> Lives: %d</html>",score,lives);
    }
    
    
}
