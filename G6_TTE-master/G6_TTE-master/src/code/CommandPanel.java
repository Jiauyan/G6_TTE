package code;

import java.util.Scanner;

public class CommandPanel {
    
    private int command;
    Scanner sc = new Scanner(System.in);
    Year_And_Season obj = new Year_And_Season();
    Tax Tax = new Tax();
    Tower Tower = new Tower();
    Dragon dg = new Dragon();
    Wall Wall = new Wall();
    Citizen Citizen = new Citizen();
    Events e = new Events();
    SaveAndLoadSystem SaveAndLoadSystem = new SaveAndLoadSystem();
    
    public static final String TEXT_RESET = "\u001B[0m";
    public static final String TEXT_RED = "\u001B[31m";
    public static final String TEXT_BLUE = "\u001B[34m";
    public static final String TEXT_YELLOW = "\u001B[33m";
    
/* 
    
    Select mode
    
    Main menu
    - Tower
    - Wall
    - Season
    - Save and Load
    - I am all ready!

    Tower
    - Upgrade Attack 
    - Upgrade Critical Chance 
    - Upgrade Accuracy
    - Back to menu
    
    Wall
    - Upgrade Health
    - Upgrade Block Chance
    - Back to menu
    
    Citizen
    - 6 emotional change
    - Back to menu
    
    Save and Load
    
*/ 
        
    // Only read int method- for command input
    public static int readInt()
    { 
        boolean error=false;
        int x=0;
        do {
            try
            {
                Scanner sc=new Scanner(System.in);
                x=sc.nextInt();
                error=false;
            }
            catch(Exception e)
            {
                System.out.println(TEXT_RED + "The command is not available." + TEXT_RESET);
                System.out.println("Please enter again your command : ");
                error=true;
            }
        } while(error);
        return(x);
    }
    
    public void selectMode() {
        
        System.out.println("Welcome to Till The End !");
        System.out.println("Select your game mode ");
        System.out.println("1. Normal Mode");
        System.out.println("2. Hard Mode");
        System.out.println("");
        System.out.println("Please enter your command : ");
        command = readInt();  
        while (command<1 || command >2 ) {
            System.out.println(TEXT_RED + "The command is not available." + TEXT_RESET);
            System.out.println("Please enter again your command : ");
            command = readInt();
        }
        if (command == 1) {
            Main.hardMode = false; //normal mode
            System.out.println(TEXT_BLUE + "You selected NORMAL MODE" + TEXT_RESET);
        }
        else {
            Main.hardMode = true;//hard mode
            System.out.println(TEXT_BLUE + "You selected HARD MODE " + TEXT_RESET
                    + "\n(lower tower AP,critical chance and accuracy)"
                    + "\n(higher dragon AP and critical chance)");
        }
    }
        
    //Main menu
    public void Main_menu(){

        System.out.println("");
        System.out.println("Year : " + obj.getYear());
        System.out.println("Season : " + obj.getStringSeason(obj.getSeason()));
        dg.Status();
        switch (obj.getSeason()) {
            case 0 -> System.out.println("Events : "+e.Spring());
            case 1 -> System.out.println("Events : "+e.Summer());
            case 2 -> System.out.println("Events : "+e.Autumn());
            case 3 -> System.out.println("Events : "+e.Winter());
        }
        System.out.println("Gold : " + Tax.getGold());
        System.out.println("1. Tower");
        System.out.println("2. Wall");
        System.out.println("3. Citizens");
        System.out.println("4. Save and load game");
        System.out.println("5. I am all ready!");
        System.out.println("");
        System.out.println("Please enter your command : ");
        command = readInt();  
        while (command<1 || command >5 ) {
            System.out.println(TEXT_RED + "The command is not available." + TEXT_RESET);
            System.out.println("Please enter again your command : ");
            command = readInt();
        }
        if (command == 1)
            Tower(); //direct to tower menu
        else if (command == 2)
            Wall(); //direct to wall menu
        else if (command == 3)
            Citizens(); //direct to citizen menu
        else if (command == 4)
            savegame(); //direct to citizen menu
        else {
            //do nothing and return to main method
        }
    }
    //Save and load system
    public void savegame(){
        System.out.println("1. Save game");
        System.out.println("2. Load game");
        System.out.println("3. Back to menu");
        System.out.println("");
        System.out.println("Please enter your command : ");
        command = readInt();  
        while (command<1 || command >3 ) {
            System.out.println(TEXT_RED + "The command is not available." + TEXT_RESET);
            System.out.println("Please enter again your command : ");
            command = readInt();
        }
        if (command == 1){
           SaveAndLoadSystem.savedata(); // save game
           savegame();
        }
        else if (command == 2){
           SaveAndLoadSystem.loaddata(); //load data 
           Main_menu();
        }
        else if (command == 3)
            Main_menu(); //direct to main menu
        else {
            //do nothing and return to main method
        }
    }
    
    //Tower menu
    public void Tower(){
        System.out.println("");
        System.out.println("\tGold : " + Tax.getGold());
        System.out.printf("\tTower's AttackPoint : %d \n",Tower.getAP());
        System.out.printf("\tTower's Critical Chance : %.2f %%\n",Tower.getCrit()*100);
        System.out.printf("\tTower's Accurancy :  %.2f %%\n",Tower.getAccu()*100);
        System.out.println();
        System.out.println("\t1. Upgrade Attack (100 Gold -> 1 AttackPoint)");
        System.out.println("\t2. Upgrade Critical Chance (100 Gold -> 5 Critical Chance %)");
        System.out.println("\t3. Upgrade Accuracy (100 Gold -> 4% Accuracy)");
        System.out.println("\t4. Back to menu");
        System.out.println("");
        System.out.println("Please enter your command : ");
        command = readInt();    
        while (command<1 || command >4 ) {
            System.out.println(TEXT_RED + "The command is not available." + TEXT_RESET);
            System.out.println("Please enter again your command : ");
            command = readInt();
        }
        if (command == 1){
            if(Tax.getGold()>=100) {
                Tower.upgAP();
            }
            else
                System.out.println(TEXT_YELLOW + "\nYou have insufficient fund" + TEXT_RESET);
            Tower();
        }
        else if (command == 2){
            if(Tax.getGold()>=100) {
            Tower.upgCrit();
            }
            else
                System.out.println(TEXT_YELLOW + "\nYou have insufficient fund" + TEXT_RESET);
            Tower();
        }
        else if (command == 3){
            if(Tax.getGold()>=100) {
            Tower.upgAccu();
            }
            else
            System.out.println(TEXT_YELLOW + "\nYou have insufficient fund" + TEXT_RESET);
            Tower();
        }
        else 
            Main_menu(); 
    }
    
    //Wall menu
    public void Wall(){
        System.out.println("");
        System.out.println("\tGold : " + Tax.getGold());
        System.out.printf("\tWall's HealthPoint : %d \n",Wall.getHP());
        System.out.printf("\tWall's Block Chance : %.2f %%\n",Wall.getBlockPercentage()*100);
        System.out.println();
        System.out.println("\t1. Upgrade Health (100 Gold -> 75 HealthPoint)");
        System.out.println("\t2. Upgrade Block Chance (100 Gold -> 5 Block Chance %)");
        System.out.println("\t3. Back to menu");
        System.out.println("");
        System.out.println("Please enter your command : ");
        command = readInt();   
        while (command<1 || command >3 ) {
            System.out.println(TEXT_RED + "The command is not available." + TEXT_RESET);
            System.out.println("Please enter again your command : ");
            command = readInt();
        }
        if (command == 1){
            if(Tax.getGold()>=100) {
            Wall.upgWallHP();
            }
            else
            System.out.println(TEXT_YELLOW + "\nYou have insufficient fund" + TEXT_RESET);
            Wall();
        }
        else if (command == 2){
            if(Tax.getGold()>=100) {
            Wall.upgWallBlockPercentage();
            }
            else
            System.out.println(TEXT_YELLOW + "\nYou have insufficient fund" + TEXT_RESET);
            Wall();
        }
        else 
            Main_menu();
    }
    
    //Citizen menu
    public void Citizens(){
        System.out.println("");
        System.out.println("\tGold : " + Tax.getGold()); 
        System.out.println("\tCitizen's Emotional (Decrease Tower's AttackPoint by 1) : " + Citizen.getEmotional());
        System.out.println("\tCitizen's Nervous (Decrease Tower Accuracy Percentage by 5%) : " + Citizen.getNervous()); 
        System.out.println("\tCitizen's Lazy (Decrease Wall's HealthPoint by 100) : " + Citizen.getLazy());
        System.out.println("\tCitizen's Berserk (Increase Tower's AttackPoint by 1) : " + Citizen.getBerserk());
        System.out.println("\tCitizen's Diligent (Increase Wall's HealthPoint by 75) : " + Citizen.getDiligent());
        System.out.println("\tCitizen's Fearless (Increase Tower Critical Chance Percentage by 5%) : " + Citizen.getFearless());
        System.out.println();
        System.out.println("\t1. Decrease Emotional (50 Gold -> 50 Emotional Point)");
        System.out.println("\t2. Decrease Nervous (50 Gold -> 50 Nervous Point)"); 
        System.out.println("\t3. Decrease Lazy (50 Gold -> 50 Lazy Point)");
        System.out.println("\t4. Increase Berserk (50 Gold -> 50 Berserk Point)");
        System.out.println("\t5. Increase Diligent (50 Gold -> 50 Diligent Point)");
        System.out.println("\t6. Increase Fearless (50 Gold -> 50 Fearless Point)");
        System.out.println("\t7. Back to menu");
        System.out.println("");
        System.out.println("Please enter your command : ");
        command = readInt();   
        while (command<1 || command >7 ) {
            System.out.println(TEXT_RED + "The command is not available." + TEXT_RESET);
            System.out.println("Please enter again your command : ");
            command = readInt();
        }
        if (command == 1){
            if(Tax.getGold()>=50) {
            Citizen.chgEmotional(-50);
            }
            else
            System.out.println(TEXT_YELLOW + "\nYou have insufficient fund" + TEXT_RESET);
            Citizens();
        }
        else if (command == 2){
            if(Tax.getGold()>=50) {
            Citizen.chgNervous(-50);
            }
            else
            System.out.println(TEXT_YELLOW + "\nYou have insufficient fund" + TEXT_RESET);
            Citizens();
        }
        else if (command == 3){
            if(Tax.getGold()>=50) {
            Citizen.chgLazy(-50);
            }
            else
            System.out.println(TEXT_YELLOW + "\nYou have insufficient fund" + TEXT_RESET);
            Citizens();
        }
        else if (command == 4){
            if(Tax.getGold()>=50) {
            Citizen.chgBerserk(50);
            }
            else
            System.out.println(TEXT_YELLOW + "\nYou have insufficient fund" + TEXT_RESET);
            Citizens();
        }
        else if (command == 5){
            if(Tax.getGold()>=50) {
            Citizen.chgDiligent(50);
            }
            else
            System.out.println(TEXT_YELLOW + "\nYou have insufficient fund" + TEXT_RESET);
            Citizens();
        }
        else if (command == 6){
            if(Tax.getGold()>=50) {
            Citizen.chgFearless(50);
            }
            else
            System.out.println(TEXT_YELLOW + "\nYou have insufficient fund" + TEXT_RESET);
            Citizens();
        }
        else
            Main_menu();
    }
    
}
