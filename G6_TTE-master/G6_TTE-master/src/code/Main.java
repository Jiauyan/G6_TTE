package code;

import java.io.IOException;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Main {
    
    public static boolean hardMode;
    public static final String TEXT_RESET = "\u001B[0m";
    public static final String TEXT_PURPLE = "\u001B[35m";
    public static final String TEXT_GREEN = "\u001B[32m";
    public static final String TEXT_RED = "\u001B[31m";
    
    public static void main(String[] args) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        System.out.println("--------------------------------------------- Game Start -----------------------------------------------\n"+
        "\nA Level 1 dragon performs a sudden attack on your city!\n" +
        "\nDragon will attack your wall first. And then your tower will respond by attacking the dragon.\n" +
        "\nAfter attacking 10 times, the dragon will flee.\n" +
        "\nThe game will begin from Year 1, Spring with your retaining wall’s health.\n" +
        "\nThe event will happen and tax will be collected.\n" + 
        "\nYou can perform actions such as upgrade your tower and wall using your gold.\n" +
        "\nWhen you have spent your gold and proceed, the dragon will return as a Level 2 dragon and perform another\n" +
        "\n10 attacks again before it flees.\n" +
        "\nThe game now enters Year 1, Summer with your retaining wall’s health… the loop goes on until they win\n" +
        "or loses condition is satisfied!\n");
        
        CommandPanel commandPanel = new CommandPanel();
        Year_And_Season obj = new Year_And_Season(); 
        Combat cond = new Combat();
        Dragon dg = new Dragon();
        Wall w = new Wall();
        Events e = new Events();
        Tower tw = new Tower();
        GameFrame gameFrame = new GameFrame();
        Sound s = new Sound();
        
        //select game mode
        commandPanel.selectMode();
        
        //initialize game value
        obj.setRound(1);
        obj.setSeason(0);
        obj.setYear(1);
        if (hardMode == true) { 
            tw.setAP(6);
            tw.setCrit(0.05);
            tw.setAccu(0.6);
            dg.setAP(8);
            dg.setCrit(0.35);
        }

        //the game will keep looping until win or lose
        while (cond.Win(dg.getHP())==false || cond.Lose(w.getHP())==false){
            
            //YEAR LOOP
            for (obj.getYear();; obj.changeYear()){
                
                //SEASON LOOP
                for (obj.getSeason(); obj.getSeason()<4; obj.changeSeason()){
                    //tax each season
                    Tax.getRandomTax();
                    Tax.calcGold();
                    //random event each season
                    switch (obj.getSeason()) {
                        case 0 -> e.spring();
                        case 1 -> e.summer();
                        case 2 -> e.autumn();
                        case 3 -> e.winter();
                    }

                    System.out.println("--------------------------------------------------------------------------------------------------------");
                    //call main menu each season
                    commandPanel.Main_menu(); 
                   
                    
                    //ROUND LOOP
                    for (obj.getRound(); obj.getRound()<11; obj.changeRound()){ //loop from round 1 to round 10
                    System.out.println(TEXT_PURPLE + "\n\t-= Round " + obj.getRound()+" =- " + TEXT_RESET);                        
                    cond.DragonAttack();
                        if (cond.EndGame()==true) 
                            break;
                        cond.TowerAttack();
                        if (cond.EndGame()==true) 
                            break;
                    } //Round-loop end
                   
                     //each season end sound effect
                    if (dg.getHP()<w.getHP()) {
                        s.play(0);
                    }
                    else
                        s.play(1);
                    
                    obj.setRound(1); //set round to 1 each season before next loop
                        if (cond.EndGame()==true) 
                        break;
                    e.resetEvent(); //reset temporary event
                    dg.upgDragonLevel(); 
                    dg.setHP(dg.getMaxHP());
                    System.out.println("");
                } //Season-loop end
                
                obj.setSeason(0); //set to season 0 = "spring" each year
                    if (cond.EndGame()==true) 
                    break;
            
            } //Year-loop end
                if (cond.EndGame()==true) 
                break;
                 

        }
        //The game will end when player win/lose
        if (cond.Win(dg.getHP()) == true) {
        System.out.println(TEXT_GREEN + "You killed the dragon: You protected your city!" + TEXT_RESET);        
        gameFrame.launch();
        }
        else
        System.out.println(TEXT_RED + "You failed to protect your city!" + TEXT_RESET);
        gameFrame.launch();
        //End-Game Screen
    }
    
}