package animationgui;

import commands.LoadCommand;
import commands.ResetCommand;
import fruitninjagame.Game;
import fruitninjagame.GameController;
import fruitninjagame.Player;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenuPanel extends JPanel {
    static MainMenuPanel panel;
    ImageIcon background;
    static JLabel welcomingLbl;
    static JButton newGameButton;
    static JButton loadGameButton;
    static JButton viewHighScoreButton;
    static JButton resetButton;
    static JButton exitButton;



        public MainMenuPanel(){
            panel = this;
            setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
            background = new ImageIcon("backgroundOne.jpg");


            welcomingLbl =  new JLabel("Welcome to Fruit Ninja, Slice 'em up!");
            welcomingLbl.setAlignmentX(CENTER_ALIGNMENT);
            newGameButton = new JButton("New Game");
            newGameButton.setAlignmentX(CENTER_ALIGNMENT);
            loadGameButton = new JButton("Load Game");
            loadGameButton.setAlignmentX(CENTER_ALIGNMENT);
            viewHighScoreButton = new JButton("View High score");
            viewHighScoreButton.setAlignmentX(CENTER_ALIGNMENT);
            resetButton = new JButton("Reset");
            resetButton.setAlignmentX(CENTER_ALIGNMENT);
            exitButton = new JButton("Exit");
            exitButton.setAlignmentX(CENTER_ALIGNMENT);


            welcomingLbl.setFont(new Font("Verdana", Font.BOLD, 45));
            newGameButton.setFont(new Font("Verdana", Font.BOLD, 30));
            loadGameButton.setFont(new Font("Verdana", Font.BOLD, 30));
            viewHighScoreButton.setFont(new Font("Verdana", Font.BOLD, 30));
            resetButton.setFont(new Font("Verdana", Font.BOLD, 30));
            exitButton.setFont(new Font("Verdana", Font.BOLD, 30));


            /*         newGameButton.setPreferredSize(new Dimension(80,60));
            loadGameButton.setPreferredSize(new Dimension(80,80));
            viewHighScoreButton.setPreferredSize(new Dimension(80,40));
            exitButton.setPreferredSize(new Dimension(80,40));
            resetButton.setBounds(new Rectangle(500, 100));*/
            welcomingLbl.setBounds(400,2,700,50);
            panel.add(Box.createRigidArea(new Dimension(0, 80)));
            panel.add(welcomingLbl);
            panel.add(Box.createRigidArea(new Dimension(0, 60)));
            panel.add(newGameButton);
            panel.add(Box.createRigidArea(new Dimension(0, 40)));
            panel.add(loadGameButton);
            panel.add(Box.createRigidArea(new Dimension(0, 40)));
            panel.add(viewHighScoreButton);
            panel.add(Box.createRigidArea(new Dimension(0, 40)));
            panel.add(resetButton);
            panel.add(Box.createRigidArea(new Dimension(0, 40)));
            panel.add(exitButton);
            
            newGameButton.addActionListener(new ActionListener() {

                public void actionPerformed(ActionEvent I) {
                	
                    GameController.getInstance().resetAll();
                    new IntermediatePanel();
                    Frame.getFrame().add(IntermediatePanel.getPanel());
                    Frame.getFrame().setContentPane(IntermediatePanel.getPanel());
                    
                }
            });
             loadGameButton.addActionListener(new ActionListener() {

                public void actionPerformed(ActionEvent I) {
                    Player.getInstance().setCommand(new LoadCommand());
                    Player.getInstance().pressButton();
                     new Panel();
                    Frame.getFrame().add(Panel.getPanel());
                    Frame.getFrame().setContentPane(Panel.getPanel());
                    
                }
            });
             resetButton.addActionListener(new ActionListener() {

                public void actionPerformed(ActionEvent I) {
                    Player.getInstance().setCommand(new ResetCommand());
                    Player.getInstance().pressButton();
                    
                }
            });
              exitButton.addActionListener(new ActionListener() {

                public void actionPerformed(ActionEvent I) {
                    System.exit(0);
                    
                    
                }
            });








            panel.setVisible(true);

        }

    public static MainMenuPanel getPanel() {
        return panel;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(background.getImage(), 0, 0, null);
    }
}
