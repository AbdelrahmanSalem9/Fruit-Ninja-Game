/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bombs;

import fruitninjagame.IGameObject;
import animationgui.Panel;
import animationgui.Animation;
import fruitninjagame.GameController;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 *
 * @author MIX
 */
public class Bomb implements IGameObject{

    Random rand = new Random();
    protected int x;
    protected int y;
    protected int max;
    protected ImageIcon image;
    protected ImageIcon slicedImage;
    protected int initialV;
    protected int fallV;
    protected Boolean slice;
    protected Boolean top;
    protected Animation a;

  

    @Override
    public int getXlocation() {
        return x;
    }

    @Override
    public int getYlocation() {
        return y;
    }

    @Override
    public int getMaxHeight() {
        return max;
    }

    @Override
    public int getInitialVelocity() {
        return initialV;
    }

    @Override
    public int getFallingVelocity() {
        return fallV;
    }

    @Override
    public Boolean isSliced() {
        return slice;
    }

    public int getObjectType() {
        return 1;
    }

    @Override
    public Boolean hasMovedOffScreen() {
        if (y > 600) {
            return true;
        }
        return false;

    }

    @Override
    public void slice() {
        this.slice = true;
        image = slicedImage;
        top = true;

    }

    @Override
    public void move() {
        if (y <= max || top) {
            y += fallV;
            x += 1;
            top = true;
        } else if (y > max && !top) {
            y -= initialV;
            x += 1;

        }
    }

    @Override
    public ImageIcon getImage() {

        return image;

    }

    @Override
    public Animation getAnimation() {
        return this.a;
    }


}
