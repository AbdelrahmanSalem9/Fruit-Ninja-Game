
package fruitninjagame;

import java.awt.Point;


public interface IGameActions{

public IGameObject createGameObject();
/*
*@return created game object
*/
//public void updateObjectsLocations();
/*
* update moving objects locations
*/
public void updateLives(IGameObject g);
public void sliceObjects(IGameObject g);
/*
* it is used to slice fruits located in your swiping region
This method can take your swiping region as parameters (they
depend on how you calculate it).
*/
public void saveGame();
/*
*saves the current state of the game
*/
public void loadGame();
/*
*loads the last saved state of the game
*/
public void ResetGame();/*
*resets the game to its initial state
*/
}
