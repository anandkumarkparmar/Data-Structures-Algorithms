public class TreeTraversalExample {
	public TreeNode root;

	public TreeTraversalExample() {
		this.createATree();
	}
	
	private void createATree() {
		// Level 1
		root = new TreeNode(1);

		// Level 2
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);

		// Level 3
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);

		// Level 4
		root.left.left.left = new TreeNode(8);
		root.right.left.left = new TreeNode(9);
		root.right.left.right = new TreeNode(10);
	}

	public static void main(String[] args) {
		TreeTraversalExample treeTraversalExample = new TreeTraversalExample();
		
		TreeTraversalUtil util = new TreeTraversalUtil();
		System.out.println("------------------------------------");
		util.printInorderTraversal(treeTraversalExample.root);
		System.out.println("------------------------------------");
		util.printPreorderTraversal(treeTraversalExample.root);
		System.out.println("------------------------------------");
		util.printPostorderTraversal(treeTraversalExample.root);
		System.out.println("------------------------------------");
		util.printLevelorderTraversal(treeTraversalExample.root);
		System.out.println("------------------------------------");
	}
}