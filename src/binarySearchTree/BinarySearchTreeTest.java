package binarySearchTree;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

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
		assertNotNull(bst.find(bst.root, 15));
		bst.remove(15);
		assertNull(bst.find(bst.root, 15));
	}

	@Test
	public void shouldFind() {
		Node node = bst.find(bst.root,20);
		assertNotNull(node);
		assertEquals(20, node.value);
	}

	@Test
	public void shouldReturnMin() {
		Node node = bst.findMin();
		assertNotNull(node);
		assertEquals(10, node.value);
	}

	@Test
	public void shouldReturnMax() {
		Node node = bst.findMax();
		assertNotNull(node);
		assertEquals(20, node.value);
	}

	@Test
	public void shouldTestIsEmpty() {
		assertFalse(bst.isEmpty());
	}

	@Test
	public void shouldMakeEmpty() {
		bst.makeEmpty();
		assertTrue(bst.isEmpty());
	}
	
	@Test
	public void shouldReturnHeight(){
		bst = new BinarySearchTree();
		bst.addInsert(10);
		bst.addInsert(5);
		bst.addInsert(20);
		bst.addInsert(4);
		assertEquals(3,bst.getHeight());
	}
}
