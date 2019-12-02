package GUI.music;


import javazoom.jl.player.Player;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;

public class monsterfightmusic_thread extends Thread {
    static private Player player;
    static private boolean isLoop;
    static private File file;
    static private FileInputStream fis;
    static private BufferedInputStream bis;


    @Override
    public void run(){
        try{
            do{
                setName("Music_thread");
                File file = new File("src\\main\\java\\GUI\\music\\monster_fight.mp3");
                fis = new FileInputStream(file);
                bis = new BufferedInputStream(fis);
                player = new Player(bis);
                player.play();
            }while(true);
        }catch(Exception e){}
    }


}
