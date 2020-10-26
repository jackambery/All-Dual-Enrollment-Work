import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class IndexMaker {

	public static void checkInput(String input) {
		if (!(input.contains(".txt"))) {
			input += ".txt";
		}
	}
	
	public static void createOutput(String output) {
		if (output == "") {
			//File outputFile = new File();
			output += "testtest";
		}
	}
	
//--------------------------------------------------------------------------------
	public static void main(String[] args) throws FileNotFoundException {
		
		DocumentIndex index = new DocumentIndex();
		Scanner kb = new Scanner(System.in);
		String inPathname = "";
		String outPathname = "";
		
		System.out.println("What is the input file?");
		inPathname += kb.nextLine();

		//checkInput(inputFile);
		
//		System.out.println("What is the output file?\nLeave blank to create output file.");
//		String outputFile = kb.nextLine();
//		
//		createOutput(outputFile);
		
		File inputFile = new File(inPathname);
		Scanner inputScanner = new Scanner(inputFile);
		
		int lineNumber = 1;
		while (inputScanner.hasNextLine()) {
			String line = inputScanner.nextLine();
			index.addAllWords(line, lineNumber);
			lineNumber++;
		}
		
		File outputFile = new File(outPathname);
		PrintWriter outputWriter = new PrintWriter(outputFile);
		for (IndexEntry entry : index.getEntries().values()) {
			outputWriter.println(entry.toString());
		}
		
		
		kb.close();
		inputScanner.close();
		outputWriter.close();
	}

}
