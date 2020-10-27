import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Creates DocumentIndex from the input file and 
 * writes the DocumentIndex to an output file
 * 
 * @author Jack Ambery
 */
public class IndexMaker {
	
	/**
	 * A
	 * Main method, asks user for input and output file
	 * If input is not found, program throws exception
	 * If output is not found, creates new file named the input file's name plus "Index"
	 * Uses Scanner to read files and PrintWriter to write to files
	 * 
	 * @param args 
	 * @throws FileNotFoundException if input file does not exist
	 */
	public static void main(String[] args) throws FileNotFoundException {
		
		Scanner kb = new Scanner(System.in);
		DocumentIndex index = new DocumentIndex();
		
		//Input
		String inPathname = "";

		System.out.println("What is the input file?");
		inPathname += kb.nextLine();
		
		File inputFile = new File(inPathname);
		Scanner inputScanner = new Scanner(inputFile);
		int lineNumber = 1;
		while (inputScanner.hasNextLine()) {
			index.addAllWords(inputScanner.nextLine(), lineNumber);
			lineNumber++;
		}
		
		
		//Output
		String outPathname = "";
		
		System.out.println("What is the output file?"
				+ "\nLeave blank to create output file."
				+ "\nIf output file entered is not found, one will be created");
		outPathname += kb.nextLine();
		
		//create and check output file
		File outputFile = new File(outPathname);
		
		if (!(outputFile.exists())) {
			if (inPathname.contains(".txt")) {
				inPathname = inPathname.substring(0, inPathname.indexOf(".txt"));
			}
			String name = inPathname + "Index";
			File defaultTest = new File(name);
			PrintWriter outputWriter = new PrintWriter(defaultTest);
			for (IndexEntry entry : index.getEntries().values()) {
				outputWriter.println(entry.toString());
			}
			outputWriter.close();
		}
		else { 
			PrintWriter outputWriter = new PrintWriter(outputFile);
			for (IndexEntry entry : index.getEntries().values()) {
				outputWriter.println(entry.toString());
			}
			outputWriter.close();
		}		
		
		kb.close();
		inputScanner.close();
	}

}
