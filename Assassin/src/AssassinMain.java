import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

// It reads a file of names, shuffles the names, 
// and constructs an object of type AssassinManager. 

public class AssassinMain {
   private static final String FILENAME = "Assassins.txt";

   public static void main(String[] args) {
      List<String> assassins = new ArrayList<String>();
      File f = new File(FILENAME);
      Scanner killers = null;
      try {
         killers = new Scanner(f);
      } catch  (FileNotFoundException e)  {
         System.out.println("File " + FILENAME + " not found.");
         System.exit(0);
      }
      
      while (killers.hasNext())
         assassins.add(killers.next());
        
      killers.close();
      System.out.println(assassins);
      String[] temp = assassins.toArray(new String[0]);
      Arrays.sort(temp);
      assassins = Arrays.asList(temp);
            
      AssassinManager am = new AssassinManager(assassins);
        String winner = am.winner();
        String killer = "";
        Scanner kb = new Scanner(System.in);
        while (winner == null) {
        	System.out.println(am.killRingContains("jack"));
          System.out.println("Current Kill Ring:");
          am.printKillRing();
          System.out.println("Current Graveyard:");
          am.printGraveyard();
          System.out.print("\nnext victim: ");
          killer = kb.nextLine();
        }  
        
   System.out.println("\nGame was won by: " + winner);
   am.printGraveyard();
   }
}