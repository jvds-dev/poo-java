import java.util.Scanner;

public class Battle {
    private Scanner scanner;
    private Player player;
    private Enemy enemy;
    
    public Battle(Player player, Enemy enemy){
        this.player = player;
        this.enemy = enemy;
        scanner = new Scanner(System.in);
    }

    public void startBattle(){
        while(player.getHealthPoints() > 0 && enemy.getHealthPoints() > 0){

            playerTurn();
            if(enemy.getHealthPoints() <= 0){
                break;
            }

            enemyTurn();
            if(player.getHealthPoints() <= 0){
                break;
            };
        }
    }

    public void playerTurn(){
        System.out.println("MAKE YOUR MOVE:");
        System.out.println("1. ATTACK\n2.HEAL");
        int choice = scanner.nextInt();
        switch(choice) {
            case 1: player.attack(enemy, 10); break;
            case 2: player.heal(10); break;
            default: System.out.println("Invalid option!"); break;
        }
    }

    public void enemyTurn(){
        enemy.attack(player, 10);
    }


}
