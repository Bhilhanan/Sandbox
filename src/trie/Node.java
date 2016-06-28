package trie;

import java.util.HashMap;
import java.util.Map;

public class Node {

	char key;
	Map<Character, Node> children = new HashMap<Character, Node>();
	boolean isLeaf;
	Node parent;

	public Node() {
	}

	public Node(char c) {
		this.key = c;
	}

	public Map<Character, Node> getChildren() {
		return children;
	}

	public boolean isLeaf() {
		return isLeaf;
	}
}