public class Player extends Character{
    private static final int MAX_HP = 100;
    
    public Player(String name, int healthPoints, int x, int y){
        super(name, healthPoints, x, y);
    }

    public void heal(int ammount){
        int newHealth = Math.min(getHealthPoints() + ammount, MAX_HP);
        setHealthPoints(newHealth);
        System.out.println(getName() + (newHealth == MAX_HP ? " health is full." : " healed and now have " + newHealth + "HP"));
    }
}
