public interface Expressions {

static ExpressionTree buildTree(String[] exp) {
	return null;
}

int evalTree();
String toPrefixNotation();
String toInfixNotation();
String toPostfixNotation();

static int postfixEval(String[] exp) {
	return 0;
}

}