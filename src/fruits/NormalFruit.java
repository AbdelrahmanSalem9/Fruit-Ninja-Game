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
public class NormalFruit extends Fruit {

   
    private ImageIcon[] images;
    private ImageIcon[] slicedImages;
    private int type;


    public NormalFruit() {
        type = rand.nextInt(5);
        x = rand.nextInt(300) + 100;
        y = 600;
        max = rand.nextInt(300) + 50;
        initialV = GameController.getInstance().getStrategy().getObjectsVelocity();
        fallV = GameController.getInstance().getStrategy().getObjectsVelocity();
        slice = false;
        moved = false;
        top = false;
        a = new Animation(this, Panel.getPanel());
        images = new ImageIcon[5];
        images[0] = resize(new ImageIcon("Apple.png"),100,100);
        images[1] = resize(new ImageIcon("Pineapple.png"),120,120);
        images[2] = resize(new ImageIcon("Orange.png"),100,100);
        images[3] = resize(new ImageIcon("Watermelon.png"),120,120);
        images[4] = resize(new ImageIcon("Banana.png"),120,120);
        slicedImages = new ImageIcon[5];
        slicedImages[0] = resize(new ImageIcon("SlicedApple.png"),100,100);
        slicedImages[1] = resize(new ImageIcon("SlicedPineapple.png"),120,140);
        slicedImages[2] = resize(new ImageIcon("SlicedOrange.png"),100,100);
        slicedImages[3] = resize(new ImageIcon("SlicedWatermelon.png"),110,150);
        slicedImages[4] = resize(new ImageIcon("SlicedBanana.png"),120,120);
    }
  
    public void slice() {
        this.slice = true;
        images[type]=slicedImages[type];
        top=true;

    }
    @Override
    public ImageIcon getImage() {

        return images[type];

    }
}
