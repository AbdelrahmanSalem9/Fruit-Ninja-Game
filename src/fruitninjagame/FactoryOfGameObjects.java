/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fruitninjagame;

import bombs.FatalBomb;
import fruits.Fruit;
import bombs.DangerousBomb;
import fruits.NormalFruit;
import fruits.SpecialFruitOne;
import fruits.SpecialFruitTwo;


/**
 *
 * @author MIX
 */
public class FactoryOfGameObjects {

    private static FactoryOfGameObjects instance;

    private FactoryOfGameObjects() {

    }

    public static FactoryOfGameObjects getInstance() {
        if (instance == null) {
            instance = new FactoryOfGameObjects();
        }
        return instance;
    } 
    
    public IGameObject getObject(int type)
    {
        if(type>=0&&type<20)
            return new NormalFruit();
        if(type>=20&&type<30)
            return new DangerousBomb();
        if(type>=30&&type<35)
            return new SpecialFruitOne();
        if(type>=35&&type<38)
            return new SpecialFruitTwo();
        if(type>=38&&type<44)
            return new FatalBomb();
        return null;
           
        
    }
    
}
