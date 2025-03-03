public class Character {
    private String name;
    private int x, y, healthPoints, damagePoints;
    private float criticalChance;
    private char mapElement;
    // private float missChance = 0.2f;
    private ScreenManager screen = new ScreenManager();

    public Character(String name, int x, int y,int healthPoints, int damagePoints, float criticalChance, char mapElement){
        this.name = name;
        this.x = x;
        this.y = y;
        this.healthPoints = healthPoints;
        this.damagePoints = damagePoints;
        this.criticalChance = criticalChance;
        this.mapElement = mapElement;
    }

    public String getName(){
        return name;
    }

    public char getMapElement(){
        return mapElement;
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
            return String.format("%s %s %s causing %s damage to it's HP!",
                                this.getName(),
                                screen.colorText("critical attacked", screen.RED),
                                target.getName(),
                                damage
                                );
        }
        else{
            target.takeDamage(damage);
            return String.format("%s %s %s causing %s damage to it's HP!",
                                this.getName(),
                                screen.colorText("attacked", screen.YELLOW),
                                target.getName(),
                                damage
                                );
        }
    }
}
