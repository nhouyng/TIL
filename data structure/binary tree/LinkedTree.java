package binary_tree;

public class LinkedTree {

	private BinaryTreeNode root;

	public BinaryTreeNode addTree(BinaryTreeNode node1, Object data, BinaryTreeNode node2) {
		BinaryTreeNode root = new BinaryTreeNode(data);
		root.leftNode = node1;
		root.rightNode = node2;

		return root;
	}
}
