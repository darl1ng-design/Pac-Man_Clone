import javax.swing.*;
import java.awt.*;

public class MapChoices extends JFrame{ ;
    public MapChoices(){
        super("Map choices");
        JPanel btnPanel = new JPanel(new GridLayout(5, 1));

        JButton map1 = new JButton("Map 1");
        JButton map2 = new JButton("Map 2");
        JButton map3 = new JButton("Map 3");
        JButton map4 = new JButton("Map 4");
        JButton map5 = new JButton("Map 5");


        btnPanel.add(map1);
        btnPanel.add(map2);
        btnPanel.add(map3);
        btnPanel.add(map4);
        btnPanel.add(map5);

        //otwieranie okna po kliknieciu na dany przycisk, w ktorym znajdzie sie wygenerowana mapa
        map1.addActionListener( e -> {
            dispose();
            SwingUtilities.invokeLater(() -> {
                new Game(map1.getText());
            });
        });
        map2.addActionListener( e -> {
            dispose();
            SwingUtilities.invokeLater(() -> {
                new Game(map2.getText());
            });
        }); map3.addActionListener( e -> {
            dispose();
            SwingUtilities.invokeLater(() -> {
                new Game(map3.getText());
            });
        }); map4.addActionListener( e -> {
            dispose();
            SwingUtilities.invokeLater(() -> {
                new Game(map4.getText());
            });
        }); map5.addActionListener( e -> {
            dispose();
            SwingUtilities.invokeLater(() -> {
                new Game(map5.getText());
            });
        });

        add(btnPanel, BorderLayout.CENTER);


        setSize(400, 400);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

