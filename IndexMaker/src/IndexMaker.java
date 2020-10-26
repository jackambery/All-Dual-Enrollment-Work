import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class IndexMaker {

//	public static void checkInput(String input) {
//		if (!(input.contains(".txt"))) {
//			input += ".txt";
//		}
//	}
//	
	public static void createOutput(File output) {

	}
//	
//--------------------------------------------------------------------------------
	public static void main(String[] args) throws FileNotFoundException {
		
		DocumentIndex index = new DocumentIndex();
		Scanner kb = new Scanner(System.in);
		String inPathname = "";
		String outPathname = "";
		
		System.out.println("What is the input file?");
		inPathname += kb.nextLine();
		
		File inputFile = new File(inPathname);
		Scanner inputScanner = new Scanner(inputFile);
		
		int lineNumber = 1;
		while (inputScanner.hasNextLine()) {
			index.addAllWords(inputScanner.nextLine(), lineNumber);
			lineNumber++;
		}

		//checkInput(inputFile);
		
		System.out.println("What is the output file?"
						+ "\nLeave blank to create output file."
						+ "\nIf output file entered is not found, one will be namedma");
		outPathname += kb.nextLine();
		
		//create and check output file
		File outputFile = new File(outPathname);
		if (!(outputFile.exists())) {
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
//		createOutput(outputFile);
		

		

		
		
		
		kb.close();
		inputScanner.close();
	}

}
