import java.util.Scanner;

public class Game {
    private Map map;
    private Player player;
    private Scanner scanner;

    public Game(){
        map = new Map(5, 5);
        player = new Player("Jvds", 100, 2, 2);
        map.addElement(player.getX(), player.getY(), 'P');
        scanner = new Scanner(System.in);
    }

    public void start(){
        while (true) {
            map.displayMap();
            System.out.println("Digite W, A, S ou D para mover: ");
            char direction = scanner.next().toUpperCase().charAt(0);
            moveCharacter(direction);
        }
    }

    public void moveCharacter(char direction){
        int newX = player.getX();
        int newY = player.getY();

        switch (direction) {
            case 'W': newX--; break;
            case 'A': newY--; break;
            case 'S': newX++; break;
            case 'D': newY++; break;
            default: System.out.println("Movimento inválido! Tente W/A/S/D "); return;
        }
        if(!map.movePlayer(player, newX, newY)){
            System.out.println("Movimento inválido");
        }
    }

    public static void main(String[] args){
        new Game().start();
    }
}
