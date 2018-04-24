package binary_tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Main {

	public static void main(String[] args) {

		LinkedTree tree = new LinkedTree();

		BinaryTreeNode n7 = tree.addTree(null, '7', null);
		BinaryTreeNode n6 = tree.addTree(null, '6', null);
		BinaryTreeNode n5 = tree.addTree(null, '5', null);
		BinaryTreeNode n4 = tree.addTree(null, '4', null);
		BinaryTreeNode n3 = tree.addTree(n6, '3', n7);
		BinaryTreeNode n2 = tree.addTree(n4, '2', n5);
		BinaryTreeNode n1 = tree.addTree(n2, '1', n3);

		// BinaryTreeNode n0 = new LinkedTree().addTree(n1, 0, null);

//		System.out.print("[preOreder on recursive] > ");
//		preOrderTraversal(n1);
//		System.out.print("\n[inOreder on recursive] > ");
//		inOrderTraversal(n1);
//		System.out.print("\n[postOreder on recursive] > ");
//		postOrderTraversal(n1);

		System.out.print("\n[preOrder on stack] > ");
		ArrayList<Object> arrayList = preOrderOnStack(n1);
		for (Object obj : arrayList)
			System.out.print(obj + " ");

		System.out.print("\n[inOrder on stack] > ");
		arrayList.clear();
		arrayList = inOrderOnStack(n1);
		for (Object obj : arrayList)
			System.out.print(obj + " ");
		
		System.out.print("\n[postOrder on stack] > ");
		arrayList.clear();
		arrayList = postOrderOnStack(n1);
		for (Object obj : arrayList)
			System.out.print(obj + " ");
		
		System.out.print("\n[levelOrder on queue] > ");
		arrayList.clear();
		arrayList = levelOrderOnQueue(n1);
		for (Object obj : arrayList)
			System.out.print(obj + " ");
	}

	public static void preOrderTraversal(BinaryTreeNode node) {
		if (node == null)
			return;
		System.out.print(node.getData() + " ");
		preOrderTraversal(node.leftNode);
		preOrderTraversal(node.rightNode);
	}

	public static void inOrderTraversal(BinaryTreeNode node) {
		if (node == null)
			return;
		inOrderTraversal(node.leftNode);
		System.out.print(node.getData() + " ");
		inOrderTraversal(node.rightNode);
	}

	public static void postOrderTraversal(BinaryTreeNode node) {
		if (node == null)
			return;
		postOrderTraversal(node.leftNode);
		postOrderTraversal(node.rightNode);
		System.out.print(node.getData() + " ");
	}

	public static ArrayList<Object> preOrderOnStack(BinaryTreeNode head) {
		Stack<BinaryTreeNode> stack = new Stack<>();
		ArrayList<Object> result = new ArrayList<>();

		BinaryTreeNode node = head;

		stack.push(node);

		while (!stack.isEmpty()) {

			node = stack.pop();
			result.add(node.getData());
			if (node.rightNode != null)
				stack.push(node.rightNode);
			if (node.leftNode != null)
				stack.push(node.leftNode);
		}

		return result;
	}

	public static ArrayList<Object> inOrderOnStack(BinaryTreeNode head) {
		Stack<BinaryTreeNode> stack = new Stack<>();
		ArrayList<Object> result = new ArrayList<>();

		BinaryTreeNode node = head;

		stack.push(null);

		while (true) {
			while (node != null) {
				stack.push(node);
				node = node.leftNode;
			}

			node = stack.pop();
			if (node == null)
				break;
			result.add(node.getData());
			node = node.rightNode;
		}

		return result;
	}

	public static ArrayList<Object> postOrderOnStack(BinaryTreeNode head) {
		Stack<BinaryTreeNode> stack = new Stack<>();
		ArrayList<Object> result = new ArrayList<>();

		BinaryTreeNode node = head;
		BinaryTreeNode temp = null;

		while (true) {

			if (node != null && node != temp) {
				stack.push(node);

				do {
					if (node.rightNode != null)
						stack.push(node.rightNode);
					if (node.leftNode != null)
						stack.push(node.leftNode);
					node = node.leftNode;
				} while (node != null);
			}

			if (!stack.isEmpty()) {
				node = stack.pop();
				if (node.leftNode != null && node.rightNode == null && node.leftNode != temp) {
					stack.push(node);
					node = node.leftNode;
				}
				if (node.rightNode == null || node.rightNode == temp) {
					result.add(node.getData());
					temp = node;
				}
			} else
				break;
		}

		return result;
	}

	public static ArrayList<Object> levelOrderOnQueue(BinaryTreeNode head) {
		Queue<BinaryTreeNode> queue = new LinkedList<>();
		ArrayList<Object> result = new ArrayList<>();

		BinaryTreeNode node = head;
		
		queue.add(node);
		
		while(!queue.isEmpty()) {
			node = queue.poll();
			if(node.leftNode != null)
				queue.add(node.leftNode);
			if(node.rightNode != null)
				queue.add(node.rightNode);
			result.add(node.getData());
		}
		
		return result;
	}
}
