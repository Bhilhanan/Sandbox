package binarySearchTree;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BinarySearchTreeTest {
	private BinarySearchTree bst;

	@Before
	public void init() {
		bst = new BinarySearchTree();
		bst.addInsert(10);
		bst.addInsert(20);
		bst.addInsert(15);
	}

	@Test
	public void shouldRemove() {
		bst.inOrderTraverse();
		bst.remove(15);
		bst.inOrderTraverse();
	}

	@Test
	public void shouldFind() {
		Node node = bst.find(20);
		Assert.assertNotNull(node);
		Assert.assertEquals(20, node.value);
	}

	@Test
	public void shouldReturnMin() {
		Node node = bst.findMin();
		Assert.assertNotNull(node);
		Assert.assertEquals(10, node.value);
	}

	@Test
	public void shouldReturnMax() {
		Node node = bst.findMax();
		Assert.assertNotNull(node);
		Assert.assertEquals(20, node.value);
	}

	@Test
	public void shouldTestIsEmpty() {
		Assert.assertFalse(bst.isEmpty());
	}

	@Test
	public void shouldMakeEmpty() {
		bst.makeEmpty();
		Assert.assertTrue(bst.isEmpty());
	}
	
	@Test
	public void shouldReturnHeight(){
		bst = new BinarySearchTree();
		bst.addInsert(10);
		bst.addInsert(5);
		bst.addInsert(20);
		bst.addInsert(4);
		Assert.assertEquals(3,bst.getHeight());
	}
}
