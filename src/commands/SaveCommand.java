/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package commands;

import fruitninjagame.GameController;

/**
 *
 * @author MIX
 */
public class SaveCommand implements ICommand{
     
   

    @Override
    public void execute() {
        GameController.getInstance().saveGame();
          }
}
