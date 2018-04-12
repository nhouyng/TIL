package binary_tree;

public class BinaryTreeNode {

	private Object data;
	public BinaryTreeNode leftNode;
	public BinaryTreeNode rightNode;

	BinaryTreeNode(Object data) {
		this.data = data;
		this.leftNode = null;
		this.rightNode = null;
	}

	public Object getData() {
		return data;
	}
}
