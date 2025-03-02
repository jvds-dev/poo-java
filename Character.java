public class Character {
    private String name;
    private int healthPoints;
    private int x, y;
    private int damagePoints;
    private float criticalChance;
    // private float dodgeChance;

    public Character(String name, int x, int y,int healthPoints, int damagePoints, float criticalChance){
        this.name = name;
        this.x = x;
        this.y = y;
        this.healthPoints = healthPoints;
        this.damagePoints = damagePoints;
        this.criticalChance = criticalChance;
    }

    public String getName(){
        return name;
    }

    public int getHealthPoints(){
        return healthPoints;
    }

    public int getDamagePoints(){
        return damagePoints;
    }

    public float getCriticalChance(){
        return criticalChance;
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
    }

    public String attack(Character target){
        int damage = this.getDamagePoints();
        if(Math.random() <= this.getCriticalChance()){
            damage = damage * 2;
            target.takeDamage(damage);
            return this.getName() + " critical attacked " + target.getName() + " causing " + damage + " damage to it's HP!";
        }
        else{
            target.takeDamage(damage);
            return this.getName() + " attacked " + target.getName()  + " causing " + damage + " damage to it's HP!";
        }
    }
}
