public class Game {
    public static void main(String[] args){
        Player player = new Player("Jvds", 100);
        Enemy skeleton = new Enemy("Skeleton", 50);

        System.out.println(player.getName() + " vs " + skeleton.getName());
        player.attack(skeleton, 10);

    }
}
