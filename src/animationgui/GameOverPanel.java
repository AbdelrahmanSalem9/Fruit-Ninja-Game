/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package animationgui;

import fruitninjagame.Game;
import fruitninjagame.Player;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author MIX
 */
public class GameOverPanel extends JPanel {
    JLabel highscore;
    ImageIcon background;
    static GameOverPanel panel;
    public GameOverPanel()
            
    {   panel=this;
        setLayout(null);
        background=new ImageIcon("background.jpg");
        JLabel gameOver=new JLabel("Game Over");
        gameOver.setFont(new Font("Verdana", Font.BOLD, 100));
        JButton backTo=new JButton("Back To Main Menu");
        JButton exit=new JButton("Exit");
        backTo.setFont(new Font("Verdana", Font.BOLD, 40));
        exit.setFont(new Font("Verdana", Font.BOLD,40));
        highscore=new JLabel("New Highscore: "+Game.getInstance().getHighScore().getHighScore());
        highscore.setFont(new Font("Verdana", Font.BOLD, 60));
        gameOver.setBounds(300, 200, 750, 100);
        highscore.setBounds(280,350,800,80);
        backTo.setBounds(50,550,600,50);
        exit.setBounds(1000,550,200,50);
        if(Player.getInstance().isReachHighScore())
         add(highscore);
  
        add(gameOver);
        add(backTo);
        add(exit);
        setVisible(true);
        
        exit.addActionListener(new ActionListener() {

                public void actionPerformed(ActionEvent I) {
                    System.exit(0);
                    
                    
                }
            });
         backTo.addActionListener(new ActionListener() {

                public void actionPerformed(ActionEvent I) {
                    
                      
            Frame.getFrame().add(MainMenuPanel.getPanel());
            Frame.getFrame().setContentPane(MainMenuPanel.getPanel());
                    
                }
            });
    }

    public static GameOverPanel getPanel() {
        return panel;
    }

   
     @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(background.getImage(), 0, 0, null);
    }
}
