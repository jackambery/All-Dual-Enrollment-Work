import java.util.Stack;

public class ExpressionTree extends TreeNode implements Expressions {

	/**
	 * This constructor creates a new ExpressionTree by calling the super TreeNode class and sets the root, left node, and right
	 * node all with given values.
	 * 
	 * @param initValue value given for root
	 * @param initLeft value given for left node
	 * @param initRight value given for right node
	 */
	public ExpressionTree(Object initValue, TreeNode initLeft, TreeNode initRight) {
		super(initValue, initLeft, initRight);
	}

	/**
	 * This constructor creates a new ExpressionTree by calling the super TreeNode class and sets the root but sets
	 * left and right nodes to null.
	 * 
	 * @param initValue value given for root
	 */
	public ExpressionTree(Object initValue) {
		super(initValue);
	}

	/**
	 * This method takes in an array of strings which represent the terms of
	 * a post fix expression then builds an expression tree with the terms.
	 * 
	 * @param exp array of expression terms (integers, "+", and "*")
	 * @return an expression tree consisting of every element in exp
	 */
	public static ExpressionTree buildTree(String[] exp) {
		Stack<ExpressionTree> stack = new Stack<ExpressionTree>();
		for (int i = 0; i < exp.length; i++) {

			if (!exp[i].equals("+") && !exp[i].equals("*")) {
				stack.push(new ExpressionTree(exp[i]));
			}
			else if (exp[i].equals("+")) {
				ExpressionTree tree = new ExpressionTree(exp[i]);
				tree.setRight(stack.pop());
				tree.setLeft(stack.pop());

				stack.push(tree);
			}
			else if (exp[i].equals("*")) {
				ExpressionTree tree = new ExpressionTree(exp[i]);
				tree.setRight(stack.pop());
				tree.setLeft(stack.pop());

				stack.push(tree);
			}
		}
		return stack.pop();

	}

	/**
	 * This method calculates the value of an ExpressionTree
	 * 
	 * @return int integer value of ExpressionTree
	 */
	//@Override
	public int evalTree() {
		if (this.getValue() != null) {
			if (this.getLeft() == null && this.getRight() == null) {
				return Integer.parseInt((String) this.getValue());
			}
			int left = ((ExpressionTree) this.getLeft()).evalTree();
			int right = ((ExpressionTree) this.getRight()).evalTree();

			if (this.getValue().equals("+")) {
				return left + right;
			}
			if (this.getValue().equals("*")) {
				return left * right;
			}
		}
		return 0;
	}

	/**
	 * This method, used on an ExpressionTree, returns the prefix traversal of the tree
	 * 
	 * @return String which is the ExpressionTree in prefix notation 
	 */
	@Override
	public String toPrefixNotation() {
		String notation = "";

		notation += this.getValue();
		
		if (this.getLeft() != null) {
			notation += ((ExpressionTree) this.getLeft()).toPrefixNotation();
		}
		
		if (this.getRight() != null) {
			notation += ((ExpressionTree) this.getRight()).toPrefixNotation();
		}
		return notation;
	}

	/**
	 * This method, used on an ExpressionTree, returns the infix traversal of the tree
	 * 
	 * @return String which is the ExpressionTree in infix notation 
	 */
	@Override
	public String toInfixNotation() {
		String notation = "";

		if (this.getLeft() != null) {
			notation += "(";
			notation += ((ExpressionTree) this.getLeft()).toInfixNotation();
		}
		
		notation += this.getValue();
		
		if (this.getRight() != null) {
			notation += ((ExpressionTree) this.getRight()).toInfixNotation();
			notation += ")";
		}
		return notation;
	}

	/**
	 * This method, used on an ExpressionTree, returns the postfix traversal of the tree
	 * 
	 * @return String which is the ExpressionTree in postfix notation 
	 */
	@Override
	public String toPostfixNotation() {
		String notation = "";

		if (this.getLeft() != null) {
			notation += ((ExpressionTree) this.getLeft()).toPostfixNotation();
		}
		
		if (this.getRight() != null) {
			notation += ((ExpressionTree) this.getRight()).toPostfixNotation();
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
	 */
	public static int postfixEval(String[] exp) {
		Stack<Object> temp = new Stack<Object>();
		for (int i = 0; i < exp.length; i++) {
			if (!exp[i].equals("+") && !exp[i].equals("*")) {
				temp.push(exp[i]);
			}
			else if (exp[i].equals("+")) {
				int sum = Integer.parseInt((String) temp.pop()) + Integer.parseInt((String) temp.pop());
				temp.push(String.valueOf(sum));
			}
			else if (exp[i].equals("*")) {
				int product = Integer.parseInt((String) temp.pop()) * Integer.parseInt((String) temp.pop());
				temp.push(String.valueOf(product));
			}
		}
		return Integer.parseInt((String) temp.pop());
	}
}
