import java.util.Scanner;

public class Battle {
    private Scanner scanner;
    private Player player;
    private Enemy enemy;
    private ScreenManager screen = new ScreenManager();
    private String[] turnOutput = new String[2];

    public Battle(Player player, Enemy enemy, Scanner scanner){
        this.player = player;
        this.enemy = enemy;
        this.scanner = scanner;
    }

    public void startBattle(){
        while(player.getHealthPoints() > 0 && enemy.getHealthPoints() > 0){

            screen.clearConsole();
            if(turnOutput[0] != null && turnOutput[1] != null){
                System.out.println(turnOutput[0] + "\n" + turnOutput[1]);
            }

            System.out.println(String.format("%s [%s HP] vs %s [%s HP]",
                                player.getName(),
                                player.getHealthPoints(),
                                enemy.getName(),
                                enemy.getHealthPoints()));

            playerTurn();
            if(enemy.getHealthPoints() <= 0){
                break;
            }

            enemyTurn();
            if(player.getHealthPoints() <= 0){
                break;
            }
        }
    }

    public void playerTurn(){
        System.out.println("=============================");
        System.out.println("MAKE YOUR MOVE:");
        System.out.println("1. ATTACK\n2. HEAL");
        int choice = scanner.nextInt();
        switch(choice) {
            case 1: 
                turnOutput[0] = player.attack(enemy);
                break;
            case 2: 
                turnOutput[0] =  player.heal(player.getDamagePoints());
            default: System.out.println("Invalid option!"); break;
        }
    }

    public void enemyTurn(){
        turnOutput[1] = enemy.attack(player);
    }


}
