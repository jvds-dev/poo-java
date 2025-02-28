public class Character {
    private String name;
    private int healthPoints;

    public Character(String name, int healthPoints){
        this.name = name;
        this.healthPoints = healthPoints;
    }

    public String getName(){
        return name;
    }

    public int getHealthPoints(){
        return healthPoints;
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
