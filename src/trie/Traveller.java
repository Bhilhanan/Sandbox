package trie;

public class Traveller {
	Node currPosition;

	public Traveller(Node root) {
		currPosition=root;
	}

	public Node goTo(char key) {
		currPosition=currPosition.children.get(key);
		return currPosition;
	}

	public boolean canGoTo(char key) {
		return currPosition.children.containsKey(key);
	}

	public Node getPrevious() {
		return currPosition.parent;
	}

}
