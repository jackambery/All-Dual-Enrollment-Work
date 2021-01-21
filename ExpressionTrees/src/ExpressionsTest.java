import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * This is the main class. It takes in a file name containing postfix expressions.
 * It produces a file of various expressions.
 * 
 * @author Jack Ambery
 *
 */
public class ExpressionsTest {

	/**
	 * This is the main method.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in); 
		System.out.println("What is the name of the test file?");
		String testFileName = kb.nextLine();
		File testFile = new File(testFileName);
		Scanner testScanner;
		try {

			testScanner = new Scanner(testFile);

			ArrayList<String> expressions = new ArrayList<String>();
			while(testScanner.hasNextLine()) {
				expressions.add(testScanner.nextLine());
			}

			//Output writer
			File output = new File("jackAmbery_Expressions.txt");
			PrintWriter p = new PrintWriter(output);

			for (String s : expressions) {

				String[] exp = s.split(" ");

				ExpressionTree tree = ExpressionTree.buildTree(exp);

				p.printf("Expression: " + s + "\n\n");

				p.printf("Tree Value (evalTree): " + tree.evalTree() + "\n\n");

				String prefix = tree.toPrefixNotation();
				String infix = tree.toInfixNotation();
				String postfix = tree.toPostfixNotation();

				p.printf("Prefix notation: " + prefix + "\n");
				p.printf("Infix notation: " + infix + "\n");
				p.printf("Postfix notation: " + postfix + "\n\n");					

				p.printf("Postfix String Array Evaluation (postFixEval): " + ExpressionTree.postfixEval(exp) + "\n");

				p.printf("\n\n");

			}

			testScanner.close();
			p.close();
		} 
		catch (FileNotFoundException e) {
			System.out.printf("The file entered was not found.\n");
			System.out.printf("The file \"postFixExpressions.txt\" will be used.\n");
			
		}

		kb.close();
	}
}
