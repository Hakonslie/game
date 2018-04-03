public abstract class Character
{
    protected int positionX, positionY, health, maxHealth, speed, attack, id;
    public String color, name, sex;
    protected boolean isAlive;
    public char c;
    protected Character target;
    
    public Character(String name, int maxHealth, int attack, char c, int ID)
    {
        
         this.name = name;
         this.maxHealth = maxHealth;
         health = maxHealth;
         this.attack = attack;
         this.c = c;
         isAlive = true;
         target = null;
         this.id = ID;
     
    }
    public Character()
    {
        name = "unknown";
        maxHealth = 50;
        health = maxHealth;
        isAlive = true;
        color = "brown";
        target = null;
    }
    
    void movement(int moveX, int moveY)
    {
        positionX += moveX;
        positionY += moveY;
    }
    void takeDamage(int dmg)
    {
        health -= dmg;
        if(health <= 0) die();        
        
    }
    void doDamage(int dmg, Character receiver)
    {
        int returnDmg;
        if(receiver.getStatus())
        {
            System.out.println("Doing " + dmg + " to " + receiver.getName());
            if(receiver.getHealth() < dmg) { System.out.println("Overkill: " + (dmg - 
                    receiver.getHealth()) + " dmg");}
            receiver.takeDamage(dmg);  
            
            returnDmg = receiver.defend();
            takeDamage(returnDmg);  
            System.out.println(getName() + " took " + returnDmg + " dmg from " + receiver.getName());
        
        } 
        else System.out.println(receiver.getName() + " is already dead");
    
    }
    int defend()
    {        
        return attack / 2;
    }
    boolean getStatus()
    {
        if(isAlive == true) return true;
        else return false;
    }
    String getName()
    {
        return name;
    }
    void die()
    {
        isAlive = false;
        health = 0;
        System.out.println(getName() + " died!");
    }
    public String toString()
    {
        return getName() + " > " + getHealth() + "/" + maxHealth + " Health [" + getClass().getSimpleName() + "] ID: " + id;
    }
    
    /* Get/set */
    public void setAttack(int atk)
    { attack = atk; }
    public int getAttack()
    { return attack; }
    public int getHealth()
    { return health; }
    public char getChar()
    { return c; }
    public int getPositionX()
    { return positionX; }
    public int getPositionY()
    { return positionY; }    
    public void moveX(int range)
    { positionX += range;}
    public void moveY(int range)
    { positionY += range; }
    public int[] getPosition()
    { 
        int[] position = new int [2];
        position[0] = getPositionX();
        position[1] = getPositionY();
        return position; 
    }
    public void setTarget(Character target)
    { this.target = target; }
    public Character getTarget()
    { return target; }
        
}