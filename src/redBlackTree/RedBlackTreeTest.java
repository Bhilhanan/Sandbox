package redBlackTree;

import org.junit.Before;
import org.junit.Test;

import binarySearchTree.Node;

public class RedBlackTreeTest {

	RedBlackTree rbt = new RedBlackTree();

	@Before
	public void init() {
		rbt.insert(20);
		rbt.insert(6);
		rbt.insert(3);
		rbt.insert(12);
		rbt.insert(2);
		rbt.insert(5);
		rbt.insert(9);
		System.out.println("Original");
		rbt.prettyPrint(rbt.getRoot());
	}

	@Test
	public void shouldRightRotate(){
		Node node=rbt.searchNode(12);
		Node root=rbt.rightRotate(rbt.getRoot(),node);
		System.out.println("Right rotate");
		rbt.prettyPrint(root);
	}
	
	@Test
	public void shouldLeftRotate(){
		Node node=rbt.searchNode(6);
		Node root=rbt.leftRotate(rbt.getRoot(),node);
		System.out.println("Left rotate");
		rbt.prettyPrint(root);
	}
	
	@Test
	public void shouldTransplant(){
		Node newNode=new Node(11);
		Node root=rbt.transplant(rbt.getRoot(),rbt.searchNode(12),newNode);
		System.out.println("Transplant");
		rbt.prettyPrint(root);
	}
	
	@Test
	public void shouldGetBlackHeight(){
		System.out.println("RB Heighht="+rbt.getBHeight());
	}
}
