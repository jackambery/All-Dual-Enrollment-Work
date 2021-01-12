
public class Exercises {

	public int sumTree(TreeNode root) {
		
		if (root == null) {
			return 0;
		}
		
		int sum = 0;
		sum += sumTree(root.getLeft());
		sum += sumTree(root.getRight());
		sum += (int) root.getValue();
		return sum;
	}
	
	public int countPaths(TreeNode root) {
		if (root == null) {
			return 0;
		}
		
		int count = 0;
		if (root.getLeft() != null) {
			count = 1 + countPaths(root.getLeft());
		}
		if (root.getRight() != null) {
			count = 1 + countPaths(root.getRight());
		}
		
		return count;
	}
	
	public int depth(TreeNode root) {
		if (root == null) {
			return 0;
		}
		if (root.getLeft() != null || root.getRight() != null) {
			return Math.max(1 + depth(root.getLeft()), 1 + depth(root.getRight()));
		}
		else {
			return Math.max(depth(root.getLeft()), depth(root.getRight()));
		}
	}
}

