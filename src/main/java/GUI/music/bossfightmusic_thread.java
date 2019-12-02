package GUI.music;


import javazoom.jl.player.Player;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;

public class bossfightmusic_thread extends Thread {
    static private Player player;
    static private boolean isLoop;
    static private File file;
    static private FileInputStream fis;
    static private BufferedInputStream bis;

    public bossfightmusic_thread(String filepath, boolean isLoop) {
        try {

             File file = new File(filepath);
            fis = new FileInputStream(file);
            bis = new BufferedInputStream(fis);
            player = new Player(bis);
            run();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    @Override
    public void run(){
        try{
            do{
                fis = new FileInputStream(file);
                bis = new BufferedInputStream(fis);
                player = new Player(bis);

            }while(true);
        }catch(Exception e){}
    }

}
