package trie;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Trie {

	private Node root;
	private final Traveller traveller;

	public Trie() {
		root = new Node();
		root.parent=null;
		traveller = new Traveller(root);
	}

	public void insert(String word) {
		insert(word,root);
		
	}

	private void insert(String word,Node parentNode) {
		Map<Character, Node> children = root.children;
		Node currNode=null;
		for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);

			if (children.containsKey(c)) {
				parentNode=currNode;
				currNode = children.get(c);
			} else {
				currNode = new Node(c);
				currNode.parent=parentNode;
				children.put(c, currNode);
			}
			children = currNode.children;

			if (i == word.length() - 1) {
				currNode.isLeaf = true;
			}
		}
	}

	public boolean search(String word) {
		Map<Character, Node> children = root.children;
		for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			if (!children.containsKey(c)) {
				return false;
			}
			Node node = children.get(c);
			children = node.children;
			if (i == word.length() - 1) {
				return node.isLeaf;
			}
		}

		return true;
	}

	public List<String> autoComplete(String word) {
		if (root == null || word == null || word.isEmpty()) {
			return null;
		}
		Node node = getNode(word);
		if (node == null) {
			return null;
		}
		List<String> leaves = findAllLeaves(node, new StringBuilder());
		for (int i = 0; i < leaves.size(); i++) {
			leaves.set(i, word + leaves.get(i));
		}
		return leaves;
	}

	private List<String> findAllLeaves(Node node, StringBuilder sb) {
		List<String> leafStrings = new ArrayList<String>();
		for (Entry<Character, Node> entry : node.children.entrySet()) {
			StringBuilder sbNode = new StringBuilder(sb.toString());
			Node child = entry.getValue();
			if (child.isLeaf) {
				leafStrings.add(sbNode.toString() + child.key);
			}
			sbNode.append(child.key);
			leafStrings.addAll(findAllLeaves(child, sbNode));
		}
		return leafStrings;
	}

	private Node getNode(String word) {
		Node currNode = root;
		for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			if (!currNode.children.containsKey(c)) {
				return null;
			}
			currNode = currNode.children.get(c);
		}
		return currNode;
	}

	public void insertAll(Set<String> dictionary) {
		for (String word : dictionary) {
			insert(word);
		}
	}

	public Node getRoot() {
		return root;
	}

	public String getLongestCommonPrefix() {
		Node node = root;
		StringBuilder longestCommonPrefix = new StringBuilder();
		while (true) {
			if (node.children.size() != 1 || node.isLeaf) {
				return longestCommonPrefix.toString();
			}
			for (Character chid : node.children.keySet()) {
				node = node.children.get(chid);
				break;
			}
			longestCommonPrefix.append(node.key);
		}
	}

	public Traveller getTraveller() {
		return traveller;
	}
}