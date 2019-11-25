import java.util.*;

public class TreeTraversalUtil {
	/** Inorder Traversal **/
	private void inorderTraversal(TreeNode root) {
		if (root != null) {
			inorderTraversal(root.left);
			System.out.print(root.data + " ");
			inorderTraversal(root.right);
		}
	}

	/** Preorder Traversal **/
	private void preorderTraversal(TreeNode root) {
		if (root != null) {
			System.out.print(root.data + " ");
			preorderTraversal(root.left);
			preorderTraversal(root.right);
		}
	}

	/** Postorder Traversal **/
	private void postorderTraversal(TreeNode root) {
		if (root != null) {
			postorderTraversal(root.left);
			postorderTraversal(root.right);
			System.out.print(root.data + " ");
		}
	}

	/** Level Order Traversal **/
	private void levelorderTraversal(TreeNode root) {
		if (root == null) {
			return;
		}

		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);

		while (!queue.isEmpty()) {
			TreeNode node = queue.remove();
			System.out.print(node.data + " ");

			if (node.left != null) {
				queue.add(node.left);
			}

			if (node.right != null) {
				queue.add(node.right);
			}
		}
	}

	/** Print Functions **/
	public void printInorderTraversal(TreeNode root) {
		System.out.print("Inorder: ");
		inorderTraversal(root);
		System.out.println("");
	}

	public void printPreorderTraversal(TreeNode root) {
		System.out.print("Preorder: ");
		preorderTraversal(root);
		System.out.println("");
	}

	public void printPostorderTraversal(TreeNode root) {
		System.out.print("Postorder: ");
		postorderTraversal(root);
		System.out.println("");
	}

	public void printLevelorderTraversal(TreeNode root) {
		System.out.print("Levelorder: ");
		levelorderTraversal(root);
		System.out.println("");
	}
}