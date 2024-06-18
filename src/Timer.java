import javax.swing.*;

public class Timer{
    Thread x;
    int TimeCount = 0;
    JLabel timerLabel;

    Timer(JLabel timerLabel){
        this.timerLabel = timerLabel;
        timerStart();
    }
    public void timerStart(){
        x = new Thread( () -> {
            try{
                while(!Thread.interrupted()){
                    TimeCount++;
                    timerLabel.setText(TimeCount + "secs");
                    Thread.sleep(1000);
                }
            }catch(InterruptedException e){
                System.out.println(e.getMessage());
            }
    });
        x.start();
    }
}
