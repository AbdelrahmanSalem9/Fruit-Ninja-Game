/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package commands;

import fruitninjagame.GameController;
import fruitninjagame.IGameObject;

/**
 *
 * @author MIX
 */
public class SliceCommand implements ICommand{
    private IGameObject gameObject;
    public SliceCommand(IGameObject gameObject)
    {
        this.gameObject=gameObject;
    }

    @Override
    public void execute() {
        GameController.getInstance().sliceObjects(this.gameObject);
          }
    
}
