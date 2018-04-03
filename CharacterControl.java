import Classes.*;
import Classes.Character;

import java.util.ArrayList;
import java.util.Random;
public class CharacterControl
{
    private int charId;
    ArrayList<String> classes = new ArrayList<String>();
    ArrayList<Character> characters = new ArrayList<Character>();
    Random r = new Random();
    NameGenerator ng = new NameGenerator();
    Character player;
    public CharacterControl()
    {
           populateClassArray(classes);
           run();
    }
    public void populateServer(int count)
    {
        for(int i = 0; i < count; i++)
        {
            addCharacter(classes.get(r.nextInt(classes.size())), ng.generateName());
        }
    }
    public void populateClassArray(ArrayList<String> classArray)
    {
        // HUMANOID ( 0 - 5 )
        classArray.add("HUMAN");  
        classArray.add("TROLL");
        classArray.add("ORC");
        classArray.add("NIGHTELF");
        classArray.add("DWARF");
        classArray.add("DRAGON");
        // ANIMAL   ( 6 - 8 )
        classArray.add("GIRAFFE");
        classArray.add("WOLF");
        classArray.add("MEERKAT");
        
        // CRITTER  ( 9 - 11 )
        classArray.add("SQUIRREL");
        classArray.add("SNAKE");
        classArray.add("MOUSE");
    }
    public void run()
    {
        inputReader input = new inputReader();
        
         for(int i = 0; i < 20; i++) { System.out.print("-^"); }
         System.out.print("-\n\n        Beep, Boop, Running game... \n\n");
         for(int i = 0; i < 20; i++) { System.out.print("-'"); }
         System.out.println("-");
         System.out.println("Populating Server");
         populateServer(10);
         for(int i = 2; i >= 0; i--)
         {
                try{
                    Thread.sleep(1000);
                } 
                    catch(InterruptedException ex){
                }
                System.out.println(".." + (i + 1));
         }
         try{
                    Thread.sleep(1000);
                } 
                    catch(InterruptedException ex){
                }
         System.out.println("Server populated, fetching character list \n");
         try{
                    Thread.sleep(2000);
                } 
                    catch(InterruptedException ex){
                }
         statusAll();
         try{
                    Thread.sleep(2000);
                } 
                    catch(InterruptedException ex){
                }


         setPlayer(characters.get(input.getIntInput() -1));
           

        
    }
    public void status()
    {
         System.out.println("Characters alive:");
         characters.stream().filter(b -> b.getStatus()).forEach(System.out::println);        
         System.out.println("Characters dead:");
         characters.stream().filter(b -> !(b.getStatus())).forEach(System.out::println);  
    }
        public void statusAll()
    {
         characters.stream().forEach(System.out::println);        
    }

    public boolean attackCharacter(Character attack, Character receive)
    {
         attack.doDamage(attack.getAttack(), receive);            
         if(!receive.getStatus()) { return true; }
         else return false;
   }
   
   public void addCharacter(String type, String Name)
   {
       charId++;
       switch(type)
       {
           // HUMANOIDS
           
           case "HUMAN": characters.add(new Human(Name, charId));
           break;
           case "TROLL": characters.add(new Troll(Name, charId));
           break;
           case "ORC": characters.add(new Orc(Name, charId));
           break;
           case "NIGHTELF": characters.add(new Nightelf(Name, charId));
           break;
           case "DWARF": characters.add(new Dwarf(Name, charId));
           break;
           case "DRAGON": characters.add(new Dragon(Name, charId));
           break;
           
           // ANIMALS
           
           case "WOLF": characters.add(new Wolf(Name, charId));
           break;
           case "GIRAFFE": characters.add(new Giraffe(Name, charId));
           break;
           case "MEERKAT": characters.add(new Meerkat(Name, charId));
           break;
           
           // CRITTERS
           
           case "SQUIRREL": characters.add(new Squirrel(Name, charId));
           break;
           case "SNAKE": characters.add(new Snake(Name, charId));
           break;
           case "MOUSE": characters.add(new Mouse(Name, charId));
           break;
           
       }
   }
   public void setPlayer(Character cha)
   { player = cha; }
   public Character getPlayer()
   { return player; }
   
}
