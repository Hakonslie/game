import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class NameGenerator
{
   ArrayList<String> maleNamesArray;
   ArrayList<String> femaleNamesArray;
   Random r;
   public NameGenerator()
   {
       maleNamesArray = getWordsInFileWithScanner("Resources/malenames.txt");
       femaleNamesArray = getWordsInFileWithScanner("Resources/femalenames.txt");
       r = new Random();
       //Generate some names
                           
   }
   public ArrayList<String> generateNames(int count)
   {
       ArrayList<String> nameList = new ArrayList<>();
       System.out.println(
            "Generating some names:");
       for(int i = 0; i < count; i++)
       {
           nameList.add(generateName());
        }
      return nameList;
   }
   
   public String generateName()
   {
       String temp = "";
       
       while(temp.length() < 4 || temp.length() > 8)
       {
           temp = cutRandomName(femaleNamesArray) + cutRandomName(maleNamesArray);
    }
              
       return temp.substring(0, 1).toUpperCase() + temp.substring(1);
   }

   public String cutRandomName(ArrayList<String> names)
   {
       String temp = "";
       while(temp.length() < 5)
       {
           temp = names.get(r.nextInt(names.size()));
       }   
       return temp.substring((temp.length() - r.nextInt(temp.length())), temp.length()).toLowerCase();
   }
    
   public ArrayList<String> getWordsInFileWithScanner(String filename)
   {
        ArrayList<String> words = new ArrayList<>();
        try{
            Scanner in = new Scanner(new FileInputStream(filename));
            
            while(in.hasNext())
            {
                words.add(in.next());
            }
        }
        catch(IOException exc) {
            System.out.println("Error reading words in file: " + exc);
        }
        return words;
   }
    
}