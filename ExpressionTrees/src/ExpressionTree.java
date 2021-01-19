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
		Stack<Object> temp = new Stack<Object>();
		for (int i = 0; i < exp.length; i++) {
			if (exp[i] != "+" && exp[i] != "*") {
				temp.push(exp[i]);
			}
			else if (exp[i] == "+") {
				TreeNode tempNode = new TreeNode(exp[i]);
				tempNode.setRight(new TreeNode(temp.pop()));
				tempNode.setLeft(new TreeNode(temp.pop()));
				
				temp.push(tempNode);
			}
			else if (exp[i] == "*") {
				TreeNode tempNode = new TreeNode(exp[i]);
				tempNode.setRight(new TreeNode(temp.pop()));
				tempNode.setLeft(new TreeNode(temp.pop()));
				
				temp.push(tempNode);
			}
		}
		return new ExpressionTree(temp.pop());
	}

	//@Override
	public int evalTree() {
		if (this.getLeft() == null && this.getRight() == null) {
			return this.getValue();
		}
		int left = new ExpressionTree(this.getLeft()).evalTree();
		int right = new ExpressionTree(this.getRight()).evalTree();
		
		if (this.getValue() == "+") {
			return left + right;
		}
		if (this.getValue() == "*") {
			return left * right;
		}
		
		return 0;
	}

	@Override
	public String toPrefixNotation() {
		String notation = "";
		
		notation += this.getValue();
		if (this.getLeft() != null) {
			notation += new ExpressionTree(this.getLeft()).toPrefixNotation();
		}
		if (this.getRight() != null) {
			notation += new ExpressionTree(this.getRight()).toPrefixNotation();
		}
		return notation;
	}

	@Override
	public String toInfixNotation() {
		String notation = "";
		
		if (this.getLeft() != null) {
			notation += "( ";
			notation += new ExpressionTree(this.getLeft()).toPrefixNotation();
		}
		notation += this.getValue();
		if (this.getRight() != null) {
			notation += new ExpressionTree(this.getRight()).toPrefixNotation();
			notation += " )";
		}
		return notation;
	}

	@Override
	public String toPostfixNotation() {
		String notation = "";
		
		if (this.getLeft() != null) {
			notation += new ExpressionTree(this.getLeft()).toPrefixNotation();
		}
		if (this.getRight() != null) {
			notation += new ExpressionTree(this.getRight()).toPrefixNotation();
		}
		notation += this.getValue();
		return notation;
	}
	
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
		return (int) temp.pop();
	}
	
	public static void main(String[] args) {
		ExpressionTree tree = new ExpressionTree(new TreeNode("*"), new TreeNode(5), new TreeNode(4));
		String[] arr = {"*", "6", "7"};
		System.out.println(postfixEval(arr));
	}


}
