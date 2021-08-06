/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package animationgui;

import fruitninjagame.*;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

/**
 *
 * @author MIX
 */
public class Animation {

    IGameObject game;
    Panel panel;
    Timer timer;

    public Animation(IGameObject g, Panel panel) {
        this.game = g;
        this.panel = panel;

        timer = new Timer(8, new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                panel.AnimateOne();
                Toolkit.getDefaultToolkit().sync();
            }
        });
        timer.start();
    }

    public void drawObject(Graphics g) {
        g.drawImage(game.getImage().getImage(), (int) game.getXlocation(), game.getYlocation(), panel);
    }

    public void update() {
        if (game != null) {
            game.move();
        }

    }

    public void doDrawing(Graphics g) {
        if (game != null) {
            if (!game.hasMovedOffScreen()) {
                drawObject(g);
            } else {
                if (timer.isRunning()) {
                    timer.stop();
                }

            }
        }
        Toolkit.getDefaultToolkit().sync();
    }
}
