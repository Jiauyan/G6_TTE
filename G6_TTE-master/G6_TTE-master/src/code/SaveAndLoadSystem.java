package code;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class SaveAndLoadSystem {
    
    Dragon Dragon = new Dragon();
    Tower Tower = new Tower();
    Wall Wall = new Wall();
    Year_And_Season Year_And_Season = new Year_And_Season();
    Tax Tax = new Tax();
    Citizen Citizen = new Citizen();
    Main Main = new Main();
    Events e = new Events();
    
    
    //SAVE
    public void savedata() {
        try{
          PrintWriter a = new PrintWriter(new FileOutputStream("Till_The_End.txt"));
          //Dragon
          a.print("Dragon's Level,");
          a.println(Dragon.getLevel());
          a.print("Dragon's Health Point,");
          a.println(Dragon.getHP());
          a.print("Dragon's Attack Point,");
          a.println(Dragon.getAP());
          a.print("Dragon's Critical Chance Percentage,");
          a.println(Dragon.getCrit());
          a.print("Dragon's Accuracy Percentage,");
          a.println(Dragon.getAccu());
          
          //Tower
          a.print("Tower's Attack Point,");
          a.println(Tower.getAP());
          a.print("Tower's Critical Chance,");
          a.println(Tower.getCrit());
          a.print("Tower's Accuracy,");
          a.println(Tower.getAccu());
          
          //wall
          a.print("Wall's Health Point,");
          a.println(Wall.getHP());
          a.print("Wall's Block Percentage,");
          a.println(Wall.getBlockPercentage());
          
          //year and season
          a.print("Event,");
          a.println(e.getEvent());
          a.print("Year,");
          a.println(Year_And_Season.getYear());
          a.print("Season,");
          a.println(Year_And_Season.getStringSeason(Year_And_Season.getSeason()));
          a.print("Round,");
          a.println(Year_And_Season.getRound());
          
          //tax&gold
          a.print("Tax,");
          a.println(Tax.getRandomTax());
          a.print("Gold,");
          //gold
          a.println(Tax.getGold());
          
          
          //citizen
          a.print("Citizen's Emotional,");
          a.println(Citizen.getEmotional());
          a.print("Citizen's Nervous,");
          a.println(Citizen.getNervous());
          a.print("Citizen's Lazy,");
          a.println(Citizen.getLazy());
          a.print("Citizen's Diligent,");
          a.println(Citizen.getDiligent());
          a.print("Citizen's Berserk,");
          a.println(Citizen.getBerserk());
          a.print("Citizen's Fearless,");
          a.println(Citizen.getFearless());
          
          a.close();
          System.out.println("--------------------------------------------------------------------------------------------------------");
          System.out.println(" Game saved!");
            System.out.println("");
        }catch(IOException e ){
            System.out.println("Problem with file output");
        } 
    }
    
    //LOAD
    public void loaddata(){
        try {
            Scanner in = new Scanner(new FileInputStream("Till_The_End.txt"));
            while (in.hasNextLine()) {
                String[] str = in.nextLine().split(",");
                checkdata(str[0], str[1]);
            }
            in.close();
            System.out.println("--------------------------------------------------------------------------------------------------------");
            System.out.println(" Game loaded!");
        } catch (FileNotFoundException e) {
            System.out.println("File was not found");
        }
    }
    
    public void checkdata(String a, String b) {
        if ("Dragon's Level".equals(a))
            Dragon.setLevel(Integer.parseInt(b));
        else if ("Dragon's Health Point".equals(a))
            Dragon.setHP(Integer.parseInt(b));
        else if ("Dragon's Attack Point".equals(a))
            Dragon.setAP(Integer.parseInt(b));
        else if ("Dragon's Critical Chance Percentage".equals(a))
            Dragon.setCrit(Double.parseDouble(b));
        else if ("Dragon's Accuracy Percentage".equals(a))
            Dragon.setAccu(Double.parseDouble(b));
        else if ("Tower's Attack Point".equals(a))
            Tower.setAP(Integer.parseInt(b));
        else if ("Tower's Critical Chance".equals(a))
            Tower.setCrit(Double.parseDouble(b));
        else if ("Tower's Accuracy".equals(a))
            Tower.setAccu(Double.parseDouble(b));
        else if ("Wall's Health Point".equals(a))
            Wall.setHP(Integer.parseInt(b));
        else if ("Wall's Block Percentage".equals(a))
            Wall.setBlockPercentage(Double.parseDouble(b));
        else if ("Event".equals(a))
            e.setEvent(Integer.parseInt(b));
        else if ("Year".equals(a))
            Year_And_Season.setYear(Integer.parseInt(b));
        else if ("Season".equals(a)) {
            if ("Spring".equals(b))
                Year_And_Season.setSeason(0);
            else if ("Summer".equals(b))
                Year_And_Season.setSeason(1);
            else if ("Autumn".equals(b))
                Year_And_Season.setSeason(2);
            else if ("Winter".equals(b))
                Year_And_Season.setSeason(3);
        }
        else if ("Round".equals(a))
            Year_And_Season.setRound(Integer.parseInt(b));
        else if ("Tax".equals(a))
            Tax.setTax(Integer.parseInt(b));
        else if ("Gold".equals(a))
            Tax.setGold(Integer.parseInt(b));
        else if ("Citizen's Emotional".equals(a))
            Citizen.setEmotional(Integer.parseInt(b));
        else if ("Citizen's Nervous".equals(a))
            Citizen.setNervous(Integer.parseInt(b));
        else if ("Citizen's Lazy".equals(a))
            Citizen.setLazy(Integer.parseInt(b));
        else if ("Citizen's Diligent".equals(a))
            Citizen.setDiligent(Integer.parseInt(b));
        else if ("Citizen's Berserk".equals(a))
            Citizen.setBerserk(Integer.parseInt(b));
        else if (a == "Citizen's Fearless")
            Citizen.setFearless(Integer.parseInt(b));
    }
    
    // save and load menu add to command panel

}