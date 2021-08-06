/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package animationgui;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.*;

/**
 *
 * @author MIX
 */
public class IntermediatePanel extends JPanel implements MouseListener, MouseMotionListener  {

    ImageIcon background;
    JLabel clickAny;
    int counter=0;
    static IntermediatePanel panel;

    public static IntermediatePanel getPanel() {
        return panel;
    }

    public IntermediatePanel() {
        panel=this;
        setLayout(null);
        addMouseListener(this);
        addMouseMotionListener(this);
        background = new ImageIcon("background.jpg");
        JLabel specialFruit1 = new JLabel();
        JLabel specialFruit2 = new JLabel();
        JLabel bomb1 = new JLabel();
        JLabel bomb2 = new JLabel();
        
        JLabel specialFruit1text = new JLabel("Plus 25");
        JLabel specialFruit2text = new JLabel("An Extra Life");
        JLabel bomb1text = new JLabel("Minus One Life");
        JLabel bomb2text = new JLabel("Kills Immediately");
        clickAny = new JLabel("Click Anywhere To Start");
        
        
        
        specialFruit1.setIcon(resize(new ImageIcon("Pumpkin.png"), 250, 250));
        specialFruit2.setIcon(resize(new ImageIcon("Peach.png"), 250, 250));
        bomb1.setIcon(resize(new ImageIcon("Bomb.png"), 250, 250));
        bomb2.setIcon(resize(new ImageIcon("FatalBomb.png"), 250, 250));
        
        specialFruit1.setBounds(300, 5, 250, 250);
        specialFruit2.setBounds(300, 320, 250, 250);
        bomb1.setBounds(700, 5, 250, 250);
        bomb2.setBounds(700, 320, 250, 250);
        
        specialFruit1text.setFont(new Font("Verdana", Font.BOLD, 30));
        specialFruit2text.setFont(new Font("Verdana", Font.BOLD, 30));
        bomb1text.setFont(new Font("Verdana", Font.BOLD, 30));
        bomb2text.setFont(new Font("Verdana", Font.BOLD, 30));
        clickAny.setFont(new Font("Verdana", Font.BOLD, 40));
        
        specialFruit1text.setBounds(350, 255, 250,50);
        specialFruit2text.setBounds(300, 550, 250, 50);
        bomb1text.setBounds(700, 255, 250, 50);
        bomb2text.setBounds(700, 550, 300, 50);
        clickAny.setBounds(350, 600, 550, 50);
        
         Timer timer = new Timer(500, new ActionListener(){
            @Override
           public void actionPerformed(ActionEvent e) {
               if(counter%2==0)
               clickAny.setVisible(false);
               else
               clickAny.setVisible(true); 
               counter++;
            }
        });
         
        timer.start();
        
        add(specialFruit1);
        add(specialFruit2);
        add(bomb1);
        add(bomb2);
        add(specialFruit1text);
        add(specialFruit2text);
        add(bomb1text);
        add(bomb2text);
        add(clickAny);
        
        
        setVisible(true);
    
    }

    protected ImageIcon resize(ImageIcon imageicon, int d1, int d2) {
        Image image = imageicon.getImage();
        Image image2 = image.getScaledInstance(d1, d2, image.SCALE_SMOOTH);
        imageicon = new ImageIcon(image2);
        return imageicon;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(background.getImage(), 0, 0, null);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
            new Panel();
            Frame.getFrame().add(Panel.getPanel());
            Frame.getFrame().setContentPane(Panel.getPanel());
    }
    

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void mouseDragged(MouseEvent e) {
    }

    @Override
    public void mouseMoved(MouseEvent e) {
    }
}
