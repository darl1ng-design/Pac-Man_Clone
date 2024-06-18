import javax.swing.*;
import java.io.*;


public class Highscore extends JFrame implements Serializable {
    String filePath;
    Highscore(String filePath){
        this.filePath = filePath;
        DefaultListModel<String> listModel = new DefaultListModel<>();
        JList<String> list = new JList<>();

        list.setModel(listModel);
        add(new JScrollPane(list));
    }
    public void writeToFile(int score, String username){
        try{
            FileWriter fileWriter = new FileWriter(filePath);
            PrintWriter printWriter = new PrintWriter(fileWriter);
            printWriter.println("Score: " + score + " Player: " + username);
            printWriter.close();
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void readFromFile(DefaultListModel<String> listModel){
        try{
            FileReader fileReader = new FileReader(filePath);
            BufferedReader br = new BufferedReader(fileReader);
            String[] scores = br.readLine().split(",");
            for(String score : scores){
                listModel.addElement(score);
            }
            br.close();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
}

    }



