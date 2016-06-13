package linkedList.test;

import org.junit.Before;
import org.junit.Test;

import linkedList.src.LinkedList;

public class LinkedListTest {

	private LinkedList linkedList;

	@Before
	public void init() {
		linkedList = new LinkedList();
		linkedList.add(1);
		linkedList.add(2);
		linkedList.add(3);
		linkedList.add(4);
	}

	@Test
	public void shouldReverseRecursive() {
		linkedList.printList();
		linkedList.reverse();
		linkedList.printList();
	}

	@Test
	public void shouldReverseIterative() {
		linkedList.printList();
		linkedList.reverseIterative();
		linkedList.printList();
	}
}
