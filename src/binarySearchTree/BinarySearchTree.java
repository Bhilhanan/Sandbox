package binarySearchTree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BinarySearchTree {

	public Node root;

	public Node addNode(Node n, int value) {
		if (n == null) {
			return new Node(value);
		}
		if (n.value == value) {
			return n;
		}
		if (value < n.value) {
			n.left = addNode(n.left, value);
			n.left.parent = n;
		} else {
			n.right = addNode(n.right, value);
			n.right.parent = n;
		}
		return n;
	}

	public Node addInsert(int i) {
		root = addNode(root, i);
		return root;
	}

	public void inOrderTraverse() {
		inOrderTraverse(root);
	}

	private void inOrderTraverse(Node n) {
		if (n == null) {
			return;
		}
		inOrderTraverse(n.left);
		System.out.println(n.value);
		inOrderTraverse(n.right);
	}

	public void remove(int i) {
		root = remove(root, i);
	}

	private Node remove(Node n, int value) {
		if (n == null) {
			return n;
		}
		if (value < n.value) {
			n.left = remove(n.left, value);
		} else if (value > n.value) {
			n.right = remove(n.right, value);
		} else if (n.left != null && n.right != null) { // two children
			n.value = minValue(n.right);
			n.right = remove(n.right, n.value);
		} else {
			n = (n.left != null) ? n.left : n.right;
		}
		return n;
	}

	private int minValue(Node n) {
		if (n.left == null) {
			return n.value;
		}
		return minValue(n.left);
	}

	public Node find(Node n, int value) {
		if (n == null) {
			return n;
		}
		if (value == n.value) {
			return n;
		}
		if (value < n.value) {
			return find(n.left, value);
		}
		return find(n.right, value);
	}

	public Node findMin() {
		return findMin(root);
	}

	private Node findMin(Node n) {
		if (n == null) {
			return n;
		}
		if (n.left != null) {
			return findMin(n.left);
		}
		return n;
	}

	public Node findMax() {
		return findMax(root);
	}

	private Node findMax(Node n) {
		if (n == null) {
			return n;
		}
		if (n.right != null) {
			return findMax(n.right);
		}
		return n;
	}

	public boolean isEmpty() {
		return root == null;
	}

	public void makeEmpty() {
		root = null;
	}

	public int getHeight() {
		return getHeightFrom(root, 0);
	}

	private int getHeightFrom(Node node, int level) {
		if (node == null) {
			return level;
		}
		if (node.left == null && node.right == null) {
			return level + 1;
		}
		return Math.max(getHeightFrom(node.left, level + 1),
				getHeightFrom(node.right, level + 1));
	}

	public void printLevelOrder() {
		if (root == null) {
			return;
		}
		List<Node> stack = new ArrayList<Node>();
		stack.add(root);

		while (!stack.isEmpty()) {
			Node curr = stack.remove(0);
			if (curr == null) {
				continue;
			}
			System.out.print(curr.value + " ");
			stack.add(curr.left);
			stack.add(curr.right);
		}
	}

	public void printLevelOrderPrettyPrint(Node startNode) {
		Map<Integer, ArrayList<Node>> mapStack = new HashMap<Integer, ArrayList<Node>>();
		ArrayList<Node> level1List = new ArrayList<Node>();
		level1List.add(startNode);
		mapStack.put(1, level1List);
		int level = 1;
		while (!mapStack.isEmpty()) {
			if (mapStack.get(level).isEmpty()) {
				mapStack.remove(level);
				level++;
				System.out.println("");
			}
			ArrayList<Node> arrayList = mapStack.get(level);
			if (arrayList==null||arrayList.isEmpty()) {
				continue;
			}
			Node curr = mapStack.get(level).remove(0);
			if (curr == null) {
				continue;
			}
			ArrayList<Node> childList;
			if (!mapStack.containsKey(level + 1)) {
				childList = new ArrayList<Node>();
			} else {
				childList = mapStack.get(level + 1);
			}
			System.out.print(curr.value+","+curr.isBlack + "(" + curr.parent + ") ");
			childList.add(curr.left);
			childList.add(curr.right);
			mapStack.put(level + 1, childList);

		}
	}

	public void setRoot(Node newNode) {
		root=newNode;
	}

}

