import javax.swing.*;
import java.awt.*;

public class StartingWindow extends JFrame {
    public StartingWindow(){
        super("Pacman GUI Project");
        JPanel menu = new JPanel(new GridLayout(3, 1));


        //creating new game button and storing it in panel
        JPanel game = new JPanel();
        JButton newGame = new JButton("New game");
        newGame.setBackground(Color.DARK_GRAY);
        newGame.addActionListener(e -> {
            dispose();
            SwingUtilities.invokeLater(() -> {
                new MapChoices();
            });
        });
        game.add(newGame);



        JPanel scorePanel = new JPanel();
        JButton highScores = new JButton("High scores");
        highScores.setBackground(Color.DARK_GRAY);
        highScores.addActionListener(e -> {
            dispose();
            //new Highscore();
        });
        scorePanel.add(highScores);

        JPanel ex = new JPanel();
        JButton Exit = new JButton("Exit");
        Exit.setBackground(Color.DARK_GRAY);
        Exit.addActionListener(e -> dispose());
        ex.add(Exit);


        //adding components to the main panel
        menu.add(game);
        menu.add(scorePanel);
        menu.add(ex);

        //adding main panel to the jframe object
        add(menu);


        setSize(400, 400);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}
