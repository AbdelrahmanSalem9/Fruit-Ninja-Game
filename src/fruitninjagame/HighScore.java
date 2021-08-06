package fruitninjagame;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "HighScore")
@XmlAccessorType(XmlAccessType.FIELD)
public class HighScore {

	@XmlElement(name = "highScore")
	private int highScore;

	public int getHighScore() {
		return highScore;
	}

	public void setHighScore(int highScore) {
		this.highScore = highScore;
	}

	@Override
    public String toString() {
        return String.format("Highscore: %d",getHighScore());
    }
	

}
