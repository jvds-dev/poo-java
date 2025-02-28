public class Game {
    public static void main(String[] args){
        Player player = new Player("Jvds", 50);
        Enemy skeleton = new Enemy("Skeleton", 50);

        System.out.println(player.getName() + " vs " + skeleton.getName());
        
        player.heal(10);
        player.heal(30);
        player.heal(30);
        player.heal(30);

    }
}
