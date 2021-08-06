/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fruits;

import animationgui.Animation;
import animationgui.Panel;
import fruitninjagame.GameController;
import fruitninjagame.IGameObject;
import java.awt.Image;
import java.util.Random;
import javax.swing.ImageIcon;

/**
 *
 * @author MIX
 */
public class SpecialFruitTwo extends Fruit{
    
    private ImageIcon image;
    private ImageIcon slicedImage;
     public SpecialFruitTwo() {
        x = rand.nextInt(300) + 100;
        y = 600;
        max = rand.nextInt(300) + 50;
        initialV =GameController.getInstance().getStrategy().getObjectsVelocity();
        fallV = GameController.getInstance().getStrategy().getObjectsVelocity();
        slice = false;
        moved = false;
        top = false;
        a = new Animation(this, Panel.getPanel());
        
        image= resize(new ImageIcon("Peach.png"),150,150);
        
        
        slicedImage = resize(new ImageIcon("SlicedPeach.png"),150,150);
    }
       @Override
    public void slice() {
        this.slice = true;
        image=slicedImage;
        top=true;

    }
     @Override
    public ImageIcon getImage() {

        return image;

    }

    @Override
    public int getObjectType() {
        return 4;
    }

   
 

   

 

   


   
}
