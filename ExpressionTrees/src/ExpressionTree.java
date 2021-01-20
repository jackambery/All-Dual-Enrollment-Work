import java.util.Stack;

public class ExpressionTree extends TreeNode implements Expressions {

	//constructors
	public ExpressionTree(Object initValue, TreeNode initLeft, TreeNode initRight) {
		super(initValue, initLeft, initRight);
	}

	public ExpressionTree(Object initValue) {
		super(initValue);
	}
	
	//methods
	public static ExpressionTree buildTree(String[] exp) {
		Stack<ExpressionTree> stack = new Stack<ExpressionTree>();
		for (int i = 0; i < exp.length; i++) {
			
			if (exp[i] != "+" && exp[i] != "*") {
				stack.push(new ExpressionTree(exp[i]));
			}
			else if (exp[i] == "+") {
				ExpressionTree tree = new ExpressionTree(exp[i]);
				tree.setRight(stack.pop());
				tree.setLeft(stack.pop());
				
				stack.push(tree);
			}
			else if (exp[i] == "*") {
				ExpressionTree tree = new ExpressionTree(exp[i]);
				tree.setRight(stack.pop());
				tree.setLeft(stack.pop());
				
				stack.push(tree);
			}
		}
		return stack.pop();
		
	}

	//@Override
	public int evalTree() {
		if (this.getValue() != null) {
			if (this.getLeft() == null && this.getRight() == null) {
				return Integer.parseInt((String) this.getValue());
			}
			int left = new ExpressionTree(this.getLeft().getValue()).evalTree();
			int right = new ExpressionTree(this.getRight().getValue()).evalTree();

			if (this.getValue().equals("+")) {
				return left + right;
			}
			if (this.getValue().equals("*")) {
				return left * right;
			}
		}
		return 0;
	}

	@Override
	public String toPrefixNotation() {
		String notation = "";
		
		notation += this.getValue();
		if (this.getLeft() != null) {
			notation += new ExpressionTree(this.getLeft().getValue()).toPrefixNotation();
		}
		if (this.getRight() != null) {
			notation += new ExpressionTree(this.getRight().getValue()).toPrefixNotation();
		}
		return notation;
	}

	@Override
	public String toInfixNotation() {
		String notation = "";
		
		if (this.getLeft() != null) {
			notation += "( ";
			notation += new ExpressionTree(this.getLeft().getValue()).toPrefixNotation();
		}
		notation += this.getValue();
		if (this.getRight() != null) {
			notation += new ExpressionTree(this.getRight().getValue()).toPrefixNotation();
			notation += " )";
		}
		return notation;
	}

	@Override
	public String toPostfixNotation() {
		String notation = "";
		
		if (this.getLeft() != null) {
			notation += new ExpressionTree(this.getLeft().getValue()).toPostfixNotation();
		}
		if (this.getRight() != null) {
			notation += new ExpressionTree(this.getRight().getValue()).toPostfixNotation();
		}
		notation += this.getValue();
		return notation;
	}
	
	/**
	 * This method takes in a postfix expression in the form of a String array and 
	 * returns the solution to the expression.
	 * 
	 * @param exp Array of strings representing an expression in postfix notation
	 * @return the integer answer of the given expression
	 * WORKS
	 */
	public static int postfixEval(String[] exp) {
		Stack<Object> temp = new Stack<Object>();
		for (int i = 0; i < exp.length; i++) {
			if (exp[i] != "+" && exp[i] != "*") {
				temp.push(exp[i]);
			}
			else if (exp[i] == "+") {
				int sum = Integer.parseInt((String) temp.pop()) + Integer.parseInt((String) temp.pop());
				temp.push(String.valueOf(sum));
			}
			else if (exp[i] == "*") {
				int product = Integer.parseInt((String) temp.pop()) * Integer.parseInt((String) temp.pop());
				temp.push(String.valueOf(product));
			}
		}
		return Integer.parseInt((String) temp.pop());
	}

}
