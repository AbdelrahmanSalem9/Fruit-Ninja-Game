/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bombs;

import fruitninjagame.IGameObject;
import animationgui.Animation;
import animationgui.Panel;
import fruitninjagame.GameController;
import java.awt.Image;
import java.util.Random;
import javax.swing.ImageIcon;

/**
 *
 * @author MIX
 */
public class FatalBomb extends Bomb{
 

    public FatalBomb() {
        x = rand.nextInt(300) + 100;
        y = 600;
        max = rand.nextInt(300) + 50;
        initialV = GameController.getInstance().getStrategy().getObjectsVelocity();
        fallV = GameController.getInstance().getStrategy().getObjectsVelocity();
        slice = false;
        top = false;

        a = new Animation(this, Panel.getPanel());
        image = resize(new ImageIcon("FatalBomb.png"));
        slicedImage = resize(new ImageIcon("SlicedFatalBomb.png"));

    }


    public int getObjectType() {
        return 2;
    }
    
    private ImageIcon resize(ImageIcon imageicon) {
        Image image = imageicon.getImage();
        Image image2 = image.getScaledInstance(80, 80, image.SCALE_SMOOTH);
        imageicon = new ImageIcon(image2);
        return imageicon;
    }

}
