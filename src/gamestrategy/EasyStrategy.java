/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamestrategy;

/**
 *
 * @author MIX
 */
public class EasyStrategy implements IGameStrategy{

    @Override
    public int getTimeInterval() {
        
        return 1100;
    }

    @Override
    public int getObjectsVelocity() {
       
        return 2;
    }
    
}
