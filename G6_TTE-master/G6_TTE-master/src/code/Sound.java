package code;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import javax.sound.sampled.*;

public class Sound {
    
    Clip clip;
    File file[] = new File[11];
    
    String[] sound;
    
    public Sound() {
         file[0] = new File("dragon roar.wav");
         file[1] = new File("rockburst.wav");
         file[2] = new File("crime.wav");
         file[3] = new File("festival.wav");
         file[4] = new File("visitor.wav");
         file[5] = new File("wishes.wav");
         file[6] = new File("travelling.wav");
         file[7] = new File("rainy.wav");
         file[8] = new File("flood.wav");
         file[9] = new File("tour group.wav");
         file[10] = new File("mutation.wav");
    }

 public void play(int i) throws UnsupportedAudioFileException, IOException, LineUnavailableException{
  
    Scanner sc = new Scanner(System.in);
    AudioInputStream ais = AudioSystem.getAudioInputStream(file[i]);
    clip = AudioSystem.getClip();
    clip.open(ais);

    clip.start();
    //need time to respond, you cant hear anything if the method end before the 
    //sound fully played
    
 }
 
}