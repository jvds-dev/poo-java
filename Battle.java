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
            screen.clearConsole();
            if(enemy.getHealthPoints() <= 0){
                break;
            }

            enemyTurn();
            if(player.getHealthPoints() <= 0){
                break;
            }
        }
        if (player.getHealthPoints() <= 0) {
            System.out.println(player.getName() + " died!");
        }
        else{
            System.out.println(player.getName() + " defeated " + enemy.getName());
            System.out.println("Press ENTER to continue: ");
            scanner.nextLine();
            scanner.nextLine();
        }
    }

    public void playerTurn(){
        
        int choice = -1;

        while(true){
            System.out.println("=============================");
            System.out.println("MAKE YOUR MOVE:");
            System.out.println("1. ATTACK\n2. HEAL");
            if(scanner.hasNextInt()){
                choice = scanner.nextInt();
                if(choice == 1 || choice == 2){ break; }
            } 
            else{
                screen.clearConsole();
                System.out.println("Invalid input!");
                scanner.next();
            }
        }

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
