package code;

public class Year_And_Season {
    
    private static String season ;
    private static int year, round, Season;
    
    public String getStringSeason(int Season) {
        String str = "";
        switch(Season) {
            case 0 -> str = "Spring";
            case 1 -> str = "Summer";
            case 2 -> str = "Autumn";
            case 3 -> str = "Winter";
        }
        return str;
    }
    
    public void changeYear(){
        Year_And_Season.year += 1;
    }
    
    public void changeSeason(){
        Year_And_Season.Season += 1;
    }
    
    public void changeRound(){
        Year_And_Season.round += 1;
    }

    public String getseason(){
        return season;
    }

    public void setYear(int year) {
        Year_And_Season.year = year;
    }

    public void setRound(int round) {
        Year_And_Season.round = round;
    }

    public void setSeason(int Season) {
        Year_And_Season.Season = Season;
    }
    
    public int getSeason(){
        return Season;
    }
    
    public int getYear() {
        return year;
    }

    public int getRound() {
        return round;
    }
    @Override
    public String toString(){
         return "Year : " + year + "\nSeason: " + season + "\nRound : " + round + "\n";
    }
}
