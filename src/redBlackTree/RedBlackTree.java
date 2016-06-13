package redBlackTree;

import binarySearchTree.BinarySearchTree;
import binarySearchTree.Node;

public class RedBlackTree {
	BinarySearchTree bst;

	public RedBlackTree() {
		bst = new BinarySearchTree();
	}

	public Node insert(int i) {
		Node root=bst.addInsert(i);
		preserveRBProperty(bst.find(root,i));
		return bst.root;
	}

	private void preserveRBProperty(Node node) {
		if(node==bst.root){
			node.isBlack=true;
			return;
		}
		if(node.parent.isBlack){
			return;
		}
		Node parent=node.parent;
		Node gran=parent.parent;
		Node uncle=getSibling(node.parent);
		if(uncle!=null && !uncle.isBlack){
			parent.isBlack=true;
			gran.isBlack=false;
			preserveRBProperty(gran);
		}else{
			if(parent.left==node && gran.left==parent){
				leftLeftCase(parent, gran);
			}else if(parent.right==node && gran.right==parent){
				rightRightCase(parent, gran);
			}else if(parent.right==node && gran.left==parent){
				leftRotate(bst.root,parent);
				leftLeftCase(node, gran);
			}else{
				rightRotate(bst.root,parent);
				rightRightCase(node,gran);
			}
		}
	}

	private void rightRightCase(Node parent, Node gran) {
		leftRotate(bst.root,gran);
		gran.isBlack=!gran.isBlack;
		parent.isBlack=!parent.isBlack;
	}

	private void leftLeftCase(Node parent, Node gran) {
		rightRotate(bst.root, gran);
		gran.isBlack=!gran.isBlack;
		parent.isBlack=!parent.isBlack;
	}

	public Node getSibling(Node node){
		if(node==null || node==bst.root){
			return null;
		}
		Node parent=node.parent;
		if(parent.left==node){
			return parent.right;
		}
		return parent.left;
	}
	public void inOrderTraverse() {
		bst.inOrderTraverse();
	}

	public void printLevelOrder() {
		bst.printLevelOrder();
	}

	public void prettyPrint(Node node) {
		bst.printLevelOrderPrettyPrint(node);
	}

	public Node rightRotate(Node root, Node node) {
		Node child = node.left;
		Node granChild=child.right;
		root=transplant(root,node,child);
		node.parent=child;
		child.right=node;
		node.left=granChild;
		if(granChild!=null){
			granChild.parent=node;
		}
		return root;
	}

	public Node leftRotate(Node root, Node node) {
		Node child=node.right;
		Node granChild=child.left;
		root=transplant(root,node,child);
		node.parent=child;
		child.left=node;
		node.right=granChild;
		if(granChild!=null){
			granChild.parent=node;
		}
		return root;
	}

	public Node searchNode(Node root, int i) {
		return bst.find(root,i);
	}

	public Node getRoot() {
		return bst.root;
	}

	public Node transplant(Node root, Node oldNode, Node newNode) {
		Node parent = oldNode.parent;
		if (parent == null) {
			bst.setRoot(newNode);
		} else if (parent.left == oldNode) {
			parent.left = newNode;
		} else {
			parent.right = newNode;
		}
		if (newNode != null) {
			newNode.parent = parent;
		}
		return bst.root;
	}

	public int getBHeight() {
		return getBHeight(bst.root,0);
	}

	private int getBHeight(Node node,int bHeight) {
		if(node==null){
			return bHeight;
		}
		if(node.isBlack){
			bHeight++;
		}
		int leftHeight= getBHeight(node.left,bHeight);
		int rightHeight=getBHeight(node.right,bHeight);
		return leftHeight>rightHeight?leftHeight:rightHeight;
	}
}
