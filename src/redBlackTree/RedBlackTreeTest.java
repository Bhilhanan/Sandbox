package redBlackTree;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import binarySearchTree.Node;

public class RedBlackTreeTest {

	RedBlackTree rbt = new RedBlackTree();
	private Node root;

	@Before
	public void init() {
		rbt.insert(20);
		rbt.insert(6);
		rbt.insert(3);
		rbt.insert(12);
		rbt.insert(2);
		rbt.insert(5);
		root = rbt.insert(9);
	}

	@Test
	public void shouldRightRotate(){
		Node node=rbt.searchNode(rbt.getRoot(),12);
		Node childNode=rbt.searchNode(root, 9);
		Assert.assertEquals(node, childNode.parent);
		root=rbt.rightRotate(root,node);
		Assert.assertEquals(childNode,node.parent);
	}
	
	@Test
	public void shouldLeftRotate(){
		Node node=rbt.searchNode(root,6);
		Node childNode=rbt.searchNode(root, 12);
		Assert.assertEquals(node, childNode.parent);
		root=rbt.leftRotate(root,node);
		Assert.assertEquals(childNode,node.parent);
	}
	
	@Test
	public void shouldTransplant(){
		Node newNode=new Node(11);
		Node root=rbt.transplant(rbt.getRoot(),rbt.searchNode(this.root,12),newNode);
		Assert.assertNull(rbt.searchNode(root,12));
		Assert.assertNotNull(rbt.searchNode(root,11));
	}
	
	@Test
	public void shouldGetBlackHeight(){
		Assert.assertEquals(3, rbt.getBHeight());
	}
}
