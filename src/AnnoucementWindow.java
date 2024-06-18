import javax.swing.*;
import java.awt.*;

public class AnnoucementWindow extends JDialog {
    String message, mapname;
    public static String username;
    int score;
    public AnnoucementWindow(Frame owner, String message, String mapname, int score){
        super(owner, "Game annoucement", true);
        this.message = message;
        this.mapname = mapname;
        this.score = score;
        JLabel msgLabel = new JLabel(message, SwingConstants.CENTER);
        msgLabel.setFont(msgLabel.getFont().deriveFont(20f));

        JPanel userPanel = new JPanel();

        JTextField userField = new JTextField(10);

        JButton restart = new JButton("Restart game");

        restart.addActionListener(e ->{
            owner.dispose();
            Highscore hs = new Highscore(mapname);
            hs.writeToFile(score, userField.getText());
            restartGame();
        });

        userPanel.add(msgLabel);
        userPanel.add(restart);
        userPanel.add(userField);


        add(userPanel);

        setSize(new Dimension(600, 150));
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
    public void restartGame(){
        SwingUtilities.invokeLater( () -> new Game(this.mapname));
    }
}
