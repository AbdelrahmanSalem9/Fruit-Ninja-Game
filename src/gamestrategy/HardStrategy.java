/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamestrategy;

import gamestrategy.IGameStrategy;

/**
 *
 * @author MIX
 */
public class HardStrategy implements IGameStrategy {

    @Override
    public int getTimeInterval() {
        
        return 500;
    }

    @Override
    public int getObjectsVelocity() {
       
        return 4;
    }
    
}
