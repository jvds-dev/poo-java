import java.util.Scanner;

public class Game {
    private Map map;
    private Player player;
    private Scanner scanner;
    private Enemy enemy;
    private Battle battle;
    private String lastOutput = "Move with W,A,S,D [Confirm with ENTER]: ";

    public Game(){
        map = new Map(5, 5);
        player = new Player("Joao", 2, 2, 100, 10, 0.2f);
        enemy = new Enemy("Skeleton", 4, 4, 50, 10, 1f);

        map.addElement(player.getX(), player.getY(), 'P');
        scanner = new Scanner(System.in);
        map.addElement(enemy.getX(), enemy.getY(), 'S');
        battle = new Battle(player, enemy, scanner);
    }

    public void start(){
        while (player.getHealthPoints() > 0) {
            clearConsole();
            System.out.println(lastOutput);
            System.out.println("=========");
            map.displayMap();
            char direction = scanner.next().toUpperCase().charAt(0);
            moveCharacter(direction);
        }
        // lastOutput = "";
    }

    public void moveCharacter(char direction){
        int newX = player.getX();
        int newY = player.getY();

        switch (direction) {
            case 'W': newX--; break;
            case 'A': newY--; break;
            case 'S': newX++; break;
            case 'D': newY++; break;
            default: lastOutput = "Invalid move! Try W, A, S or D "; return;
        }
        lastOutput = "Move with W,A,S,D [Confirm with ENTER]: ";

        if(newX < 0 || newX >= map.getSizeX() || newY < 0 || newY >= map.getSizeY()){
            lastOutput = "Invalid move [MAP SIZE LIMIT COLLISION]";
            return;
        }
        if(map.getElement(newX, newY) == 'S' ){
            // lastOutput += "\nSTARTING BATTLE";
            battle.startBattle();
            map.movePlayer(player, newX, newY);
        }
        if(!map.movePlayer(player, newX, newY)){
            lastOutput = "Invalid move!";
        }
    }

    public void clearConsole(){
        try{
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args){
        new Game().start();
    }
}
