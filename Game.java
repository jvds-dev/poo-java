import java.util.Scanner;

public class Game {
    private Map map;
    private Player player;
    private Scanner scanner;
    private Enemy enemy;

    public Game(){
        map = new Map(5, 5);
        player = new Player("Jvds", 100, 2, 2);
        map.addElement(player.getX(), player.getY(), 'P');
        scanner = new Scanner(System.in);
        enemy = new Enemy("Skeleton", 50, 4, 4);
        map.addElement(enemy.getX(), enemy.getY(), 'S');
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
        if(map.getElement(newX, newY) == 'S' ){
            System.out.println("INICIAR BATALHA");
            startBattle(enemy);
            map.movePlayer(player, newX, newY);
        }
        else if(!map.movePlayer(player, newX, newY)){
            System.out.println("Movimento inválido");
        }
    }

    public void startBattle(Enemy enemy){
        System.out.println(player.getName() + " vs " + enemy.getName());
    }

    public static void main(String[] args){
        new Game().start();
    }
}
