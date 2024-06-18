import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Objects;

public class Game extends JFrame {

    char[][] maps = {
            {
                    'w', 'w', 'w', 'w', 'w', 'w', 'w', 'w', 'w', 'w', 'w', 'w',
                    'w', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'w',
                    'w', 'b', 'w', 'w', 'w', 'b', 'b', 'w', 'w', 'w', 'b', 'w',
                    'w', 'b', 'w', 'b', 'b', 'b', 'b', 'b', 'b', 'w', 'b', 'w',
                    'w', 'b', 'w', 'b', 'b', 'w', 'w', 'b', 'b', 'w', 'b', 'w',
                    'w', 'b', 'w', 'b', 'w', 'b', 'b', 'w', 'b', 'w', 'g', 'w',
                    'w', 'g', 'b', 'b', 'g', 'b', 'b', 'b', 'p', 'b', 'b', 'w',
                    'w', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'w',
                    'w', 'b', 'w', 'b', 'w', 'b', 'b', 'w', 'b', 'w', 'b', 'w',
                    'w', 'b', 'w', 'b', 'b', 'w', 'w', 'b', 'b', 'w', 'b', 'w',
                    'w', 'b', 'w', 'b', 'b', 'b', 'b', 'b', 'b', 'w', 'b', 'w',
                    'w', 'b', 'w', 'w', 'w', 'b', 'b', 'w', 'w', 'w', 'b', 'w',
                    'w', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'w',
                    'w', 'w', 'w', 'w', 'w', 'w', 'w', 'w', 'w', 'w', 'w', 'w'
            },
            {
                    'w', 'w', 'w', 'w', 'w', 'w', 'w', 'w', 'w', 'w', 'w', 'w',
                    'w', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'w',
                    'w', 'b', 'w', 'w', 'w', 'b', 'b', 'w', 'w', 'w', 'b', 'w',
                    'w', 'b', 'w', 'b', 'b', 'b', 'b', 'b', 'b', 'w', 'b', 'w',
                    'w', 'b', 'w', 'b', 'b', 'w', 'w', 'b', 'b', 'w', 'b', 'w',
                    'w', 'b', 'w', 'b', 'w', 'b', 'b', 'w', 'b', 'w', 'g', 'w',
                    'w', 'g', 'b', 'b', 'g', 'b', 'b', 'b', 'p', 'b', 'b', 'w',
                    'w', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'w',
                    'w', 'b', 'w', 'b', 'w', 'b', 'b', 'w', 'b', 'w', 'b', 'w',
                    'w', 'b', 'w', 'b', 'b', 'w', 'w', 'b', 'b', 'w', 'b', 'w',
                    'w', 'b', 'w', 'b', 'b', 'b', 'b', 'b', 'b', 'w', 'b', 'w',
                    'w', 'b', 'w', 'w', 'w', 'b', 'b', 'w', 'w', 'w', 'b', 'w',
                    'w', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'w',
                    'w', 'w', 'w', 'w', 'w', 'w', 'w', 'w', 'w', 'w', 'w', 'w'
            },
            {
                    'w', 'w', 'w', 'w', 'w', 'w', 'w', 'w', 'w', 'w', 'w', 'w',
                    'w', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'w',
                    'w', 'b', 'w', 'w', 'w', 'b', 'b', 'w', 'w', 'w', 'b', 'w',
                    'w', 'b', 'w', 'b', 'b', 'b', 'b', 'b', 'b', 'w', 'b', 'w',
                    'w', 'b', 'w', 'b', 'b', 'w', 'w', 'b', 'b', 'w', 'b', 'w',
                    'w', 'b', 'w', 'b', 'w', 'b', 'b', 'w', 'b', 'w', 'g', 'w',
                    'w', 'g', 'b', 'b', 'g', 'b', 'b', 'b', 'p', 'b', 'b', 'w',
                    'w', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'w',
                    'w', 'b', 'w', 'b', 'w', 'b', 'b', 'w', 'b', 'w', 'b', 'w',
                    'w', 'b', 'w', 'b', 'b', 'w', 'w', 'b', 'b', 'w', 'b', 'w',
                    'w', 'b', 'w', 'b', 'b', 'b', 'b', 'b', 'b', 'w', 'b', 'w',
                    'w', 'b', 'w', 'w', 'w', 'b', 'b', 'w', 'w', 'w', 'b', 'w',
                    'w', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'w',
                    'w', 'w', 'w', 'w', 'w', 'w', 'w', 'w', 'w', 'w', 'w', 'w'
            },
            {
                    'w', 'w', 'w', 'w', 'w', 'w', 'w', 'w', 'w', 'w', 'w', 'w',
                    'w', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'w',
                    'w', 'b', 'w', 'w', 'w', 'b', 'b', 'w', 'w', 'w', 'b', 'w',
                    'w', 'b', 'w', 'b', 'b', 'b', 'b', 'b', 'b', 'w', 'b', 'w',
                    'w', 'b', 'w', 'b', 'b', 'w', 'w', 'b', 'b', 'w', 'b', 'w',
                    'w', 'b', 'w', 'b', 'w', 'b', 'b', 'w', 'b', 'w', 'g', 'w',
                    'w', 'g', 'b', 'b', 'g', 'b', 'b', 'b', 'p', 'b', 'b', 'w',
                    'w', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'w',
                    'w', 'b', 'w', 'b', 'w', 'b', 'b', 'w', 'b', 'w', 'b', 'w',
                    'w', 'b', 'w', 'b', 'b', 'w', 'w', 'b', 'b', 'w', 'b', 'w',
                    'w', 'b', 'w', 'b', 'b', 'b', 'b', 'b', 'b', 'w', 'b', 'w',
                    'w', 'b', 'w', 'w', 'w', 'b', 'b', 'w', 'w', 'w', 'b', 'w',
                    'w', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'w',
                    'w', 'w', 'w', 'w', 'w', 'w', 'w', 'w', 'w', 'w', 'w', 'w'
            },
            {
                    'w', 'w', 'w', 'w', 'w', 'w', 'w', 'w', 'w', 'w', 'w', 'w',
                    'w', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'w',
                    'w', 'b', 'w', 'w', 'w', 'b', 'b', 'w', 'w', 'w', 'b', 'w',
                    'w', 'b', 'w', 'b', 'b', 'b', 'b', 'b', 'b', 'w', 'b', 'w',
                    'w', 'b', 'w', 'b', 'b', 'w', 'w', 'b', 'b', 'w', 'b', 'w',
                    'w', 'b', 'w', 'b', 'w', 'b', 'b', 'w', 'b', 'w', 'g', 'w',
                    'w', 'g', 'b', 'b', 'g', 'b', 'b', 'b', 'p', 'b', 'b', 'w',
                    'w', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'w',
                    'w', 'b', 'w', 'b', 'w', 'b', 'b', 'w', 'b', 'w', 'b', 'w',
                    'w', 'b', 'w', 'b', 'b', 'w', 'w', 'b', 'b', 'w', 'b', 'w',
                    'w', 'b', 'w', 'b', 'b', 'b', 'b', 'b', 'b', 'w', 'b', 'w',
                    'w', 'b', 'w', 'w', 'w', 'b', 'b', 'w', 'w', 'w', 'b', 'w',
                    'w', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'w',
                    'w', 'w', 'w', 'w', 'w', 'w', 'w', 'w', 'w', 'w', 'w', 'w'
            }
    };
    int score = 0;
    int health = 3;
    int mapCols = 12;
    int mapRows = maps[0].length / 12;
    int Pac_entry_index = 80;
    String mapname;
    JLabel pac;
    JLabel ScoreLabel;
    ArrayList<Integer> collectedDots = new ArrayList<>();
    Timer myTimer;
    Highscore myHighscore;
    int pacSpeed = 100;
    int ghostSpeed = 500;
    int direction = 0;   // 0 -> stoi 1 - > w lewo 2 -> gora 3 -> prawo 4 -> dol
    int Ghost0_position = 70;
    int Ghost1_position = 73;
    int Ghost2_position = 76;
    int[] ghost_positions = {Ghost0_position, Ghost1_position, Ghost2_position};
    Game(String mapname) {
        super(mapname);
        //////////////////////////////////////////////////////////////////////////////////////////

        //creating main panel container
        JPanel mainContainer = new JPanel(new BorderLayout());

        //creating panel which contains JLabel score, JLabel health,
        JPanel dataPanel = new JPanel(new GridLayout(1, 2));
        dataPanel.setPreferredSize(new Dimension(mapCols * 2, mapRows * 2));

        JLabel timerLabel = new JLabel();
        timerLabel.setFont(new Font("Lato", Font.PLAIN, 20));
        timerLabel.setHorizontalAlignment(SwingConstants.CENTER);

        ScoreLabel = new JLabel("Score: " + score);
        ScoreLabel.setFont(new Font("Lato", Font.PLAIN, 20));
        ScoreLabel.setHorizontalAlignment(SwingConstants.CENTER);

        JLabel HealthLabel = new JLabel("Health: " + health);
        HealthLabel.setFont(new Font("Lato", Font.PLAIN, 20));
        HealthLabel.setHorizontalAlignment(SwingConstants.CENTER);

        dataPanel.add(timerLabel);
        dataPanel.add(ScoreLabel);
        dataPanel.add(HealthLabel);

        //////////////////////////////////////////////////////////////////////////////////////////

        //creating panel with maps array length and width
        JPanel mapPanel = new JPanel(new GridLayout(mapRows, mapCols));
        char[] currentMap = mapChooser(mapname);

        for (char c : currentMap) {
            JLabel mapBoard = new JLabel(String.valueOf(c), SwingConstants.CENTER);
            mapBoard.setOpaque(true);
            switch (c) {
                case 'w':
                    mapBoard.setBackground(Color.BLUE);
                    break;
                case 'b':
                    mapBoard.setBackground(Color.BLACK);
                    mapBoard.setIcon(
                            new ImageIcon(
                                    new ImageIcon(
                                            "C:\\Users\\adams\\IdeaProjects\\PACMAN\\src\\img\\dot.png"
                                    )
                                            .getImage()
                                            .getScaledInstance(20, 20, Image.SCALE_SMOOTH)
                            ));
                    break;
                default:
                    mapBoard.setBackground(Color.BLACK);
                    break;
            }
            mapBoard.setText(null);
            mapPanel.add(mapBoard);
        }
        //////////////////////////////////////////////////////////////////////////////////////////

        pac = (JLabel) mapPanel.getComponent(Pac_entry_index);
        pac.setIcon(
                new ImageIcon(
                        new ImageIcon("C:\\Users\\adams\\IdeaProjects\\pac\\src\\img\\pac_down.png").getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH))
        );
        pac.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                int key = e.getKeyCode();
                int[] dotsIndex = getDotIndex(currentMap);
                keyHandler(key, mapPanel, dotsIndex, currentMap);

                mapPanel.revalidate();
                ScoreLabel.setText("Score: " + score);
            }
        });
        pac.setFocusable(true);


        JLabel ghost1 = (JLabel) mapPanel.getComponent(Ghost1_position);
        ghost1.setIcon(
                new ImageIcon(
                        new ImageIcon("C:\\Users\\adams\\IdeaProjects\\pac\\src\\img\\ghost0.png").getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH))
        );

        JLabel ghost2 = (JLabel) mapPanel.getComponent(Ghost0_position);
        ghost2.setIcon(
                new ImageIcon(
                        new ImageIcon("C:\\Users\\adams\\IdeaProjects\\pac\\src\\img\\ghost1.png").getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH))
        );
        JLabel ghost3 = (JLabel) mapPanel.getComponent(Ghost2_position);
        ghost3.setIcon(
                new ImageIcon(
                        new ImageIcon("C:\\Users\\adams\\IdeaProjects\\pac\\src\\img\\ghost2.png").getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH))
        );

        go(currentMap, mapPanel);

        for (int i = 0; i < 3; i++) {
            final int index = i;
            Thread moveG = new Thread(() -> {
                moveGhosts(currentMap, mapPanel, ghost_positions[index], index, Pac_entry_index);
            });
            moveG.start();
        }

        Thread move = new Thread(() -> {
           loseHealth(Pac_entry_index, ghost_positions);
        });
        move.start();

        //////////////////////////////////////////////////////////////////////////////////////////


        mainContainer.add(dataPanel, BorderLayout.NORTH);
        mainContainer.add(mapPanel, BorderLayout.CENTER);
        add(mainContainer);


        myTimer = new Timer(timerLabel);
        myHighscore = new Highscore("C:\\Users\\adams\\IdeaProjects\\pac\\src\\highscore.txt");


        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(new Dimension(500, 500));
        setLocationRelativeTo(null);
        setVisible(true);
    }
    //////////////////////////////////////////////////////////////////////////////////////////

    char[] mapChooser(String mapname) {
        if (Objects.equals("Map 1", mapname)) return maps[0];
        else if (Objects.equals("Map 2", mapname)) return maps[1];
        else if (Objects.equals("Map 3", mapname)) return maps[2];
        else if (Objects.equals("Map 4", mapname)) return maps[3];
        else if (Objects.equals("Map 5", mapname)) return maps[4];
        else return maps[0];
    }

    public int[] getDotIndex(char[] map) {
        int indexCount = 0;
        for (char c : map) {
            if (c == 'b') {
                ++indexCount;
            }
        }
        int[] matches = new int[indexCount];
        int index = 0;

        for (int i = 0; i < map.length; i++) {
            if (map[i] == 'b') {
                matches[index++] = i;
            }
        }
        return matches;
    }

    public int[] getWallIndex(char[] map) {
        int indexCount = 0;
        for (char c : map) {
            if (c == 'w' ) {
                indexCount++;
            }
        }
        int[] matches = new int[indexCount];
        int index = 0;
        for (int i = 0; i < map.length; i++) {
            if (map[i] == 'w') {
                matches[index++] = i;
            }
        }
        return matches;
    }



    public boolean willPacColideWithWall(int[] wallIndexes, int pac_index) {
            for(int wallIndex : wallIndexes) {
                if (pac_index == wallIndex) {
                    return true;
                }
        }
        return false;
    }

    public void dotColission(int[] dotIndexes, int pac_index){
        for(int index : dotIndexes) {
            if (pac_index == index) {
                boolean found = false;
                for (int i : collectedDots) {
                    if (i == index) {
                        found = true;
                    }
                }
                if (!found) {
                    score += 10;
                    collectedDots.add(index);
                    if(collectedDots.size() == dotIndexes.length){

                        SwingUtilities.invokeLater(() -> {
                            new AnnoucementWindow(this, "You win ", mapname, score);
                            myTimer.x.interrupt();
                        });

                }
               }}
        }
    }

    public int movePac(int key, int index, char[] map) {
        int[] wallIdx = getWallIndex(map);
        if (key == 1) key = KeyEvent.VK_LEFT;
        else if (key == 2) key = KeyEvent.VK_UP;
        else if (key == 3) key = KeyEvent.VK_RIGHT;
        else if (key == 4) key = KeyEvent.VK_DOWN;

        switch (key) {
            case KeyEvent.VK_DOWN:
                if(!willPacColideWithWall(wallIdx, index+mapCols)){
                    direction = 4;
                }else{
                    direction = 0;
                }
                break;

            case KeyEvent.VK_UP:
                if(!willPacColideWithWall(wallIdx, index-mapCols)){
                    direction = 2;
                }else{
                    direction = 0;
                }
                break;

            case KeyEvent.VK_LEFT:
                if(!willPacColideWithWall(wallIdx, index-1)){
                    direction = 1;
                }else{
                    direction = 0;
                }
                break;

            case KeyEvent.VK_RIGHT:
                if(!willPacColideWithWall(wallIdx, index+1)){
                    direction = 3;
                }else{
                    direction = 0;
                }
                break;
        }
        return index;
    }

    public void setPacIcon(JLabel updatedPac, int key, JPanel panel) {
        if (key == 1) key = KeyEvent.VK_LEFT;
        else if (key == 2) key = KeyEvent.VK_UP;
        else if (key == 3) key = KeyEvent.VK_RIGHT;
        else if (key == 4) key = KeyEvent.VK_DOWN;
        switch (key) {
            case KeyEvent.VK_DOWN:
                updatedPac.setIcon(
                new ImageIcon(
                new ImageIcon("C:\\Users\\adams\\IdeaProjects\\PACMAN\\src\\img\\pac_down.png").getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH))
                );
                JLabel oldPacDown = (JLabel) panel.getComponent(Pac_entry_index-12);
                oldPacDown.setIcon(null);
                break;

            case KeyEvent.VK_UP:
                updatedPac.setIcon(
                        new ImageIcon(
                                new ImageIcon("C:\\Users\\adams\\IdeaProjects\\PACMAN\\src\\img\\pac_up.png").getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH))
                );
                JLabel oldPacUp = (JLabel) panel.getComponent(Pac_entry_index + 12);
                oldPacUp.setIcon(null);
                break;

            case KeyEvent.VK_LEFT:
                updatedPac.setIcon(
                        new ImageIcon(
                                new ImageIcon("C:\\Users\\adams\\IdeaProjects\\PACMAN\\src\\img\\pac_left.png").getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH))
                );
                JLabel oldPacLeft = (JLabel) panel.getComponent(Pac_entry_index + 1);
                oldPacLeft.setIcon(null);
                break;

            case KeyEvent.VK_RIGHT:
                updatedPac.setIcon(
                        new ImageIcon(
                                new ImageIcon("C:\\Users\\adams\\IdeaProjects\\PACMAN\\src\\img\\pac_right.png").getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH))
                );
                JLabel oldPacRight = (JLabel) panel.getComponent(Pac_entry_index - 1);
                oldPacRight.setIcon(null);
                break;
        }
    }

    public void keyHandler(int key, JPanel panel, int[] dotIndexes, char[] map) {
        int index = movePac(key, Pac_entry_index, map);
        JLabel newPac = (JLabel) panel.getComponent(index);
        setPacIcon(newPac, key, panel);
        dotColission(dotIndexes, index);
    }

    public void go(char[] map, JPanel panel){
        Thread x = new Thread(() -> {
            while (true) {
                try{
                    Thread.sleep(pacSpeed);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                switch (direction) {
                    case 0:
                        break;
                    case 1:
                        Pac_entry_index--;
                        break;
                    case 2:
                        Pac_entry_index = Pac_entry_index - mapCols;
                        break;
                    case 3:
                        Pac_entry_index++;
                        break;
                    case 4:
                        Pac_entry_index = Pac_entry_index + mapCols;
                        break;
                }
                int key = direction;
                int[] dotsIndex = getDotIndex(map);
                //int[] ghosts = getGhostIndex(currentMap);
                //PacGhostCollision(ghosts, Pac_entry_index);
                keyHandler(key, panel, dotsIndex, map);
                ScoreLabel.setText("Score: " + score);
            }
        });
        x.start();
    }

    public void moveGhosts(char[] map, JPanel panel, int index, int imgIndex, int pac_index){
            while (true) {
                try{
                    Thread.sleep(ghostSpeed);
                }
                catch (InterruptedException e){
                    e.printStackTrace();
                }
                char[] test = willGhostColideWithWall(map, index);
                int[] dot = new int[test.length];
                for(int i =0; i<test.length; i++){
                    if(test[i] == 'w'){
                        dot[i] = 5;
                    }else{
                        dot[i] = i;
                    }
                }

                ArrayList<Integer> xd = new ArrayList<>();

                for(int x : dot){
                    if(x<5) xd.add(x);
                }
                int random = (int)(Math.random()* (xd.size()));
                int randomElement = xd.get(random);


                if (randomElement == 0){
                    JLabel nextPos = (JLabel) panel.getComponent(index+1);
                    if(nextPos.getIcon() == null){
                        JLabel x = (JLabel) panel.getComponent(index);
                        x.setIcon(null);

                        index = index+1;
                        JLabel newGhost = (JLabel) panel.getComponent(index);
                        newGhost.setIcon(
                                new ImageIcon(
                                        new ImageIcon("C:\\Users\\adams\\IdeaProjects\\pac\\src\\img\\ghost"+imgIndex+".png").getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH))
                        );
                    }else if (nextPos.getIcon() != null){
                        JLabel x = (JLabel) panel.getComponent(index);
                        x.setIcon(
                        new ImageIcon(
                        new ImageIcon("C:\\Users\\adams\\IdeaProjects\\pac\\src\\img\\dot.png").getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH)));

                        index = index+1;
                        JLabel newGhost = (JLabel) panel.getComponent(index);
                        newGhost.setIcon(
                        new ImageIcon(
                        new ImageIcon("C:\\Users\\adams\\IdeaProjects\\pac\\src\\img\\ghost"+imgIndex+".png").getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH))
                        );
                    }
                }
                else if(randomElement == 1){
                    JLabel nextPos = (JLabel) panel.getComponent(index-1);

                    if(nextPos.getIcon() == null){
                        JLabel x = (JLabel) panel.getComponent(index);
                        x.setIcon(null);
                        index = index-1;
                        JLabel newGhost = (JLabel) panel.getComponent(index);
                        newGhost.setIcon(
                        new ImageIcon(
                        new ImageIcon("C:\\Users\\adams\\IdeaProjects\\pac\\src\\img\\ghost"+imgIndex+".png").getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH))
                        );
                    }

                    else if (nextPos.getIcon() != null){
                        JLabel x = (JLabel) panel.getComponent(index);
                        x.setIcon(
                        new ImageIcon(
                        new ImageIcon("C:\\Users\\adams\\IdeaProjects\\PACMAN\\src\\img\\dot.png").getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH)));

                        index = index-1;
                        JLabel newGhost = (JLabel) panel.getComponent(index);
                        newGhost.setIcon(
                        new ImageIcon(
                        new ImageIcon("C:\\Users\\adams\\IdeaProjects\\pac\\src\\img\\ghost"+imgIndex+".png").getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH))
                        );
                    }
                }
                else if(randomElement == 2){
                    JLabel nextPos = (JLabel) panel.getComponent(index+mapCols);
                    if(nextPos.getIcon() == null){
                        JLabel x = (JLabel) panel.getComponent(index);
                        x.setIcon(null);

                        index = index+mapCols;
                        JLabel newGhost = (JLabel) panel.getComponent(index);
                        newGhost.setIcon(
                        new ImageIcon(
                        new ImageIcon("C:\\Users\\adams\\IdeaProjects\\pac\\src\\img\\ghost"+imgIndex+".png").getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH))
                        );
                    }else if (nextPos.getIcon() != null){
                        JLabel x = (JLabel) panel.getComponent(index);
                        x.setIcon(new ImageIcon(
                                new ImageIcon("C:\\Users\\adams\\IdeaProjects\\PACMAN\\src\\img\\dot.png").getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH)));

                        index = index+mapCols;
                        JLabel newGhost = (JLabel) panel.getComponent(index);
                        newGhost.setIcon(
                        new ImageIcon(
                        new ImageIcon("C:\\Users\\adams\\IdeaProjects\\pac\\src\\img\\ghost"+imgIndex+".png").getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH))
                        );
                    }
                }

                else if(randomElement == 3){
                    JLabel nextPos = (JLabel) panel.getComponent(index-mapCols);
                    if(nextPos.getIcon() == null){
                        JLabel x = (JLabel) panel.getComponent(index);
                        x.setIcon(null);

                        index = index-mapCols;
                        JLabel newGhost = (JLabel) panel.getComponent(index);
                        newGhost.setIcon(
                        new ImageIcon(
                        new ImageIcon("C:\\Users\\adams\\IdeaProjects\\pac\\src\\img\\ghost"+imgIndex+".png").getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH))
                        );
                    }else if (nextPos.getIcon() != null) {
                        JLabel x = (JLabel) panel.getComponent(index);
                        x.setIcon(new ImageIcon(
                                new ImageIcon("C:\\Users\\adams\\IdeaProjects\\PACMAN\\src\\img\\dot.png").getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH)));

                        index = index - mapCols;
                        JLabel newGhost = (JLabel) panel.getComponent(index);
                        newGhost.setIcon(
                                new ImageIcon(
                                        new ImageIcon("C:\\Users\\adams\\IdeaProjects\\pac\\src\\img\\ghost" + imgIndex + ".png").getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH))
                        );
                    }
                }

            }
    }
    public char[] willGhostColideWithWall(char[] map, int index) {
        int a = index+1;
        int b = index-1;
        int c = index+mapCols;
        int d = index-mapCols;
        char[] ch = {map[a], map[b], map[c], map[d]};

        return ch;
    }

    public void loseHealth(int pacman_pos, int[] ghost_pos){
        while(health >  0){
            for(int i : ghost_pos){
                if(pacman_pos == i){
                    health=health-1;
                }
            }
        }
    }

    }
