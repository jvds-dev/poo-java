public class ScreenManager {
    public String RESET = "\u001B[0m";
    public String RED = "\u001B[31m";
    public String GREEN = "\u001B[32m";
    public String YELLOW = "\u001B[33m";
    public String BLUE = "\u001B[34m";

    public void clearConsole(){
        try{
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public String colorText(String text, String color){
        return color + text + RESET;
    }

    
}
