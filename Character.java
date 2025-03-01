public class Character {
    private String name;
    private int healthPoints;
    private int x, y;

    public Character(String name, int healthPoints, int x, int y){
        this.name = name;
        this.healthPoints = healthPoints;
        this.x = x;
        this.y = y;
    }

    public String getName(){
        return name;
    }

    public int getHealthPoints(){
        return healthPoints;
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }
    
    public void setPosition(int x, int y){
        this.x = x;
        this.y = y;
    }

    public void setHealthPoints(int newHp){
        healthPoints = newHp;
    }

    public void takeDamage(int ammount){
        healthPoints = Math.max(healthPoints - ammount, 0);
        System.out.println(healthPoints == 0 ? name + " is dead." : name + " has " + healthPoints + " HP left." );
    }

    public void attack(Character target, int damage){
        System.out.println(this.name + " a attacked " + target.name + " causing " + damage + " points of damage!");
        target.takeDamage(damage);
    }
}
