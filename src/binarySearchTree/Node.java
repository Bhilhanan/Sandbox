package binarySearchTree;

public class Node {
	public int value;
	public Node left;
	public Node right;
	public Node parent;
	public boolean isBlack=false;
	
	public Node(int n) {
		value = n;
	}

	@Override
	public String toString() {
		return "value=" + value+" black="+isBlack;

	}
}
