/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package animationgui;

import animationgui.Panel;
import java.awt.*;
import javax.swing.*;

/**
 *
 * @author MIX
 */
public class Frame extends JFrame{
    static Frame frame;
  
    public Frame(JPanel panel)
    {   frame=this;
        setSize(1300,700);
        setLayout(null);
        setTitle("FruitNinja");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        ImageIcon i=new ImageIcon("icon.png");
        setIconImage(i.getImage());
        
        
         
        add(panel);
        setContentPane(panel);
        setVisible(true);
        
    }

  public static Frame getFrame()
  {
      return frame;
      
  }
    
}
