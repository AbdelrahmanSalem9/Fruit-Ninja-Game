/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fruits;

import fruitninjagame.IGameObject;
import animationgui.Animation;
import animationgui.Panel;
import fruitninjagame.GameController;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Random;
import java.util.Timer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;



/**
 *
 * @author MIX
 */
public class Fruit implements IGameObject {

    Random rand = new Random();
    protected int x;
    protected int y;
    protected int max;
    private ImageIcon[] images;
    private ImageIcon[] slicedImages;
    protected int initialV;
    protected int fallV;
    protected Boolean slice;
    protected Boolean moved;
    protected Boolean top;
    private int type;
    protected Animation a;


    @Override
    public int getObjectType() {
        return 0;
    }

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

    @Override
    public Boolean hasMovedOffScreen() {
        return moved;
    }

    @Override
    public void slice() {
       

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
        if (y == 600) {
            moved= true;
            GameController.getInstance().updateLives(this);
            Panel.updateStatus();
        }
       

    }

    @Override
    public ImageIcon getImage() {

        return images[type];

    }


    @Override
    public Animation getAnimation() {
        return this.a;
    }
 protected ImageIcon resize(ImageIcon imageicon,int d1, int d2) {
        Image image = imageicon.getImage();
        Image image2 = image.getScaledInstance(d1, d2, image.SCALE_SMOOTH);
        imageicon = new ImageIcon(image2);
        return imageicon;
    }
}
