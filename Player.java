public class Player extends Character{
    private static final int MAX_HP = 100;

    public Player(String name, int healthPoints){
        super(name, healthPoints);
    }

    public void heal(int ammount){
        int newHp = getHealthPoints() + ammount;
        if(newHp > MAX_HP){
            newHp = MAX_HP;
        }
        setHealthPoints(newHp);
    }
}
