import java.util.Scanner;
public class inputReader
{
    Scanner scan;
    String input;
    
    public inputReader()
    {
        scan = new Scanner(System.in);
    }
    public String getInput()
    {   
        return scan.nextLine().toLowerCase().trim();
    }
    public int getIntInput()
    {   
        return scan.nextInt();
    }
}