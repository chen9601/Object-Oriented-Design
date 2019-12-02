package GUI.music;


import javazoom.jl.player.Player;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;

public class Mainmusic_thread extends Thread {
    static private Player player;
    static private boolean isLoop;
    static private File file;
    static private FileInputStream fis;
    static private BufferedInputStream bis;

    public Mainmusic_thread(String filepath, boolean isLoop){
        try {

            File file = new File(filepath);
            fis = new FileInputStream(file);
            bis = new BufferedInputStream(fis);
            player = new Player(bis);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void run(){
        try{
            do{
                player.play();
                fis = new FileInputStream(file);
                bis = new BufferedInputStream(fis);
                player = new Player(bis);
            }while(isLoop);
        }catch(Exception e){}
    }

    public void close(){
        isLoop = false;
        player.close();
        this.interrupt();
    }
}
