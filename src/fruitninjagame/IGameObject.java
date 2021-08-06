
package fruitninjagame;

import animationgui.Animation;
import java.awt.Image;
import javax.swing.ImageIcon;


//import javax.lang.model.element.ElementKind.ENUM;



public interface IGameObject{

//public ENUM getObjectType();
/**
*@return the type of game object
*/
public int getXlocation();
/*
*@return X location of game object
*/
public int getYlocation();
/*
*@return Y location of game object
*/
public int getMaxHeight();
/*
*@return max Y location that the object can reach on the screen
*/
public int getInitialVelocity();
/*
*@return velocity at which game object is thrown
*/
public int getFallingVelocity();
/*
*@return failing velocity of game object
*/
public Boolean isSliced();
/*
*@return whether the object is sliced or not
*/
public Boolean hasMovedOffScreen();
/*
*@return whether the object is dropped off the screen or not
*/
public void slice();
/*
*it is used to slice the object
*/
public void move();/*
*it is used to move the object on the screen
@param deltaTime: time elapsed since the object is thrown
it is used calculate the new position of
fruit object.
*/

public ImageIcon  getImage();
/*
*@return at least two images of the object, one when it is
sliced and one when it is not.
*/
public int getObjectType();

public Animation  getAnimation();
}