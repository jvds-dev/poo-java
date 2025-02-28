public class Game {
    public static void main(String[] args){
        Player player = new Player("Jvds", 100);
        Enemy skeleton = new Enemy("Skeleton", 50);

        System.out.println(player.getName() + " vs " + skeleton.getName());
        player.attack(skeleton, 10);
        player.attack(skeleton, 30);
        player.attack(skeleton, 20);
        player.attack((skeleton), 100);

    }
}
