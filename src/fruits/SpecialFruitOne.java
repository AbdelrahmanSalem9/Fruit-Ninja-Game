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
public class SpecialFruitOne extends Fruit{

    private ImageIcon image;
    private ImageIcon slicedImage;
     public SpecialFruitOne() {
        x = rand.nextInt(300) + 100;
        y = 600;
        max = rand.nextInt(300) + 50;
        initialV = GameController.getInstance().getStrategy().getObjectsVelocity();
        fallV = GameController.getInstance().getStrategy().getObjectsVelocity();
        slice = false;
        moved = false;
        top = false;
        a = new Animation(this, Panel.getPanel());
        
        image= resize(new ImageIcon("Pumpkin.png"),150,150);
        
        
        slicedImage = resize(new ImageIcon("SlicedPumpkin.png"),150,150);
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
        return 3;
    }


   

    
}
