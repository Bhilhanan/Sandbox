package linkedList.src;

import org.junit.Assert;
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
		Node headBefore = linkedList.getHead();
		Node tailBefore=linkedList.getTail();
		linkedList.reverse();
		Node headAfter=linkedList.getHead();
		Node tailAfter=linkedList.getTail();
		Assert.assertEquals(headBefore.value, tailAfter.value);
		Assert.assertEquals(tailBefore.value, headAfter.value);
	}

	@Test
	public void shouldReverseIterative() {
		Node headBefore = linkedList.getHead();
		Node tailBefore=linkedList.getTail();
		linkedList.reverseIterative();
		Node headAfter=linkedList.getHead();
		Node tailAfter=linkedList.getTail();
		Assert.assertEquals(headBefore.value, tailAfter.value);
		Assert.assertEquals(tailBefore.value, headAfter.value);
	}
}
