package code;

import java.io.IOException;
import java.util.Random;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Events {
    
    static int event;
    static String Event;
    static boolean flooded = false, droughtiness = false, rainy = false, hunger = false, wishes = false;
    
    public static final String TEXT_RESET = "\u001B[0m";
    public static final String TEXT_GREEN = "\u001B[32m";
    public static final String TEXT_YELLOW = "\u001B[33m";
    public static final String TEXT_CYAN = "\u001B[36m";
    public static final String TEXT_RED = "\u001B[31m";
    public static final String TEXT_BLUE = "\u001B[34m";
    public static final String TEXT_PURPLE = "\u001B[35m";
    
    Random r = new Random();
    Year_And_Season obj = new Year_And_Season();
    Tax Tax = new Tax();
    Dragon Dragon = new Dragon();
    Tower Tower = new Tower();
    Wall Wall = new Wall();
    Citizen Citizen = new Citizen();
    Sound s = new Sound();
    
    public Events(){
        Event = " ";
    }

    public int getEvent() {
        return event;
    }

    public void setEvent(int event) {
        Events.event = event;
    }
    
    
    public String Spring(){
        if (event == 0){
            Event = TEXT_GREEN + "Reinforcement (Increase Tower’s AttackPoint by 1 PERMANENTLY)" + TEXT_RESET;
        }
        else if (event == 1){
            Event = TEXT_YELLOW + "Visitors (Get 100 gold)" + TEXT_RESET;
        }
        else if (event == 2){
            Event = TEXT_GREEN + "Festival (Increase Berserk, Diligent and Fearless Point by 50 PERMANENTLY)" + TEXT_RESET;
        }
        else if (event == 3){
            Event = TEXT_PURPLE + "Wishes (Decrease Dragon’s HealthPoint by 25% DURING THE SEASON)" + TEXT_RESET;
        }
        else {
            Event = TEXT_RED + "Crime (You are involved in using some illegal software and caught red-handed, so you are fined, your gold will become zero (0))" + TEXT_RESET;
        }
        return Event;
    }
    
    public String Summer(){
        if (event == 0){
            Event = TEXT_RED + "Drought (Decrease Wall’s HealthPoint by 50 PERMANENTLY)" + TEXT_RESET;
        }
        else if (event == 1){
             Event = TEXT_GREEN + "Outing (Increase Berserk, Diligent and Fearless Point by 50 PERMANENTLY)" + TEXT_RESET;
        }
        else if (event == 2){
            Event = TEXT_RED + "Heatstroke (Increase Emotional, Nervous, Lazy Point by 50 PERMANENTLY)" + TEXT_RESET;
        }
        else if (event == 3){
            Event = TEXT_YELLOW + "Travelling (Decrease gold by 50%)" + TEXT_RESET;   
        }
        else {
            Event = TEXT_CYAN + "Learning (You have learnt and finally identify the weakness of the Dragon, so you become more powerful. Increase Tower Critical Chance Percentage by 5% as well as Wall Block Percentage by 5% PERMANENTLY)"+ TEXT_RESET;
        }
        return Event;
    }
    
    public String Autumn(){
        if (event == 0){
            Event = TEXT_RED + "Rainy (Minus Tower Accuracy Percentage by 20% DURING THE SEASON)" + TEXT_RESET;
        }
        else if (event == 1){
            Event = TEXT_RED + "Flood (Decrease Wall’s HealthPoint by 50 PERMANENTLY)" + TEXT_RESET;
        }
        else if (event == 2){
            Event = TEXT_YELLOW + "Harvest (Get 100 gold)" + TEXT_RESET;
        }
        else if (event == 3){
            Event = TEXT_RED + "Pandemic (Increase Dragon’s AttackPoint by 3 PERMANENTLY)" + TEXT_RESET;
        }
        else {
            Event = TEXT_PURPLE + "Food Poisoning (The citizens accidentally eat some poisoned food, and they are having food poisoning. Increase Emotional, Nervous, Lazy Point by 50 as well as decrease Berserk, Diligent and Fearless Point by 50 PERMANENTLY)" + TEXT_RESET;
        }
        return Event;
    }
    
    public String Winter(){
        if (event == 0){
            Event = TEXT_RED + "Blizzard (Decrease Wall’s HealthPoint by 50 PERMANENTLY)" + TEXT_RESET;
        }
        else if (event == 1){
            Event = TEXT_RED + "Avalanche (Increase Emotional, Nervous, Lazy Point by 50 PERMANENTLY)" + TEXT_RESET;
        }
        else if (event == 2){
            Event = TEXT_RED + "Hunger (Minus Tower Accuracy Percentage by 20% DURING THE SEASON)" + TEXT_RESET;
        }
        else if (event == 3){
            Event = TEXT_YELLOW + "Tour group (Get 100 gold)" + TEXT_RESET;
        }
        else {
            Event = TEXT_PURPLE + "Mutation (The dragon suddenly becomes mutated due to some unknown reason. Decrease Dragon’s AttackPoint by 4 as well as Critical Chance Percentage by 8% PERMANENTLY)" + TEXT_RESET;
        }
        return Event;
    }
    
    public void spring() throws UnsupportedAudioFileException, IOException, LineUnavailableException{
      
        event = r.nextInt(5);
        
        if (event == 0){
            Tower.upgAP();
        }
        else if (event == 1){
            s.play(4);
            Tax.RandomEvent();
        }
        else if (event == 2){
            s.play(3);
            Citizen.randomChgBerserk(50);
            Citizen.randomChgDiligent(50);
            Citizen.randomChgFearless(50);
        }
        else if (event == 3){
            s.play(5);
            Dragon.Wishes();
            wishes = true;
        }
        else {
            s.play(2);
            Tax.Crime();
        }
        Spring();
    }
    
    public void summer() throws UnsupportedAudioFileException, IOException, LineUnavailableException{
        event = r.nextInt(5);
        if (event == 0){
            Wall.chgHP(-50);
            droughtiness = true;
        }
        else if (event == 1){
            Citizen.randomChgBerserk(50);
            Citizen.randomChgDiligent(50);
            Citizen.randomChgFearless(50);
        }
        else if (event == 2){
            Citizen.randomChgEmotional(50);
            Citizen.randomChgNervous(50);
            Citizen.randomChgLazy(50);
        }
        else if (event == 3){
            s.play(6);
            Tax.Travelling();
        }
        else {
            Tower.Learning();
            Wall.Learning();
        }
        Summer();
    }
    
    public void autumn() throws UnsupportedAudioFileException, IOException, LineUnavailableException{
        event = r.nextInt(5);
        if (event == 0){
            s.play(7);
            Tower.upgAccu(-0.20);
            rainy = true;
        }
        else if (event == 1){
            s.play(8);
            Wall.chgHP(-50);
            flooded = true;
        }
        else if (event == 2){
            Tax.RandomEvent();
        }
        else if (event == 3){
            Dragon.Pandemic();
        }
        else {
            Citizen.randomChgEmotional(50);
            Citizen.randomChgNervous(50);
            Citizen.randomChgLazy(50);
            Citizen.randomChgBerserk(-50);
            Citizen.randomChgDiligent(-50);
            Citizen.randomChgFearless(-50);
        }
        Autumn();
    }
    
    public void winter() throws UnsupportedAudioFileException, IOException, LineUnavailableException{
        event = r.nextInt(5);
        if (event == 0){
            Wall.chgHP(-50);
        }
        else if (event == 1){
            Citizen.randomChgEmotional(50);
            Citizen.randomChgNervous(50);
            Citizen.randomChgLazy(50);
        }
        else if (event == 2){
            Tower.upgAccu(-0.20);
            hunger = true;
        }
        else if (event == 3){
            s.play(9);
            Tax.RandomEvent();
        }
        else {
            s.play(10);
            Dragon.Mutation();
        }
        Winter();
    }
    
    public void resetEvent() {
        if (rainy == true) {
            Tower.upgAccu(0.20);
            rainy = false;
        }
        else if (hunger == true) {
            Tower.upgAccu(0.20);
            hunger = false;
        }
        else if (flooded == true) {
            flooded = false;
        }
        else if (droughtiness == true) {
            droughtiness = false;
        }
        else if (wishes == true){
            wishes = false;
        }
    }
    
}

