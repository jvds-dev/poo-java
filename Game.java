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

        if(newX < 0 || newX >= map.getSizeX() || newY < 0 || newY >= map.getSizeY()){
            System.out.println("Invalid move [MAP SIZE LIMIT COLLISION]");
            return;
        }

        if(map.getElement(newX, newY) == 'S' ){
            System.out.println("INICIAR BATALHA");
            startBattle(enemy);
            map.movePlayer(player, newX, newY);
        }
        if(!map.movePlayer(player, newX, newY)){
            System.out.println("Movimento inválido");
        }
    }

    public void startBattle(Enemy enemy){
        System.out.println(player.getName() + " vs " + enemy.getName());

        while(player.getHealthPoints() > 0 && enemy.getHealthPoints() > 0){
            player.attack(enemy, 10);
            if(enemy.getHealthPoints() <= 0){
                System.out.println(enemy.getName() + " morreu!");
                break;
            }

            enemy.attack(player, 5);
            if(player.getHealthPoints() <= 0){
                System.out.println(player.getName() + " foi derrotado!");
                break;
            }
        }
    }

    public static void main(String[] args){
        new Game().start();
    }
}
