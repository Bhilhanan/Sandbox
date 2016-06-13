package linkedList.src;

public class LinkedList {

	private Node head;
	private Node tail;

	public Node add(int n) {
		if (head == null) {
			head = new Node(n);
			tail = head;

		} else {
			tail.next = new Node(n);
			tail = tail.next;
		}
		return head;
	}

	public void printList() {
		Node curr = head;
		while (curr != null) {
			System.out.print(curr.value + " ");
			curr = curr.next;
		}
		System.out.println("");
	}

	public void reverse() {
		head = reverseRecursive(head, null);
	}

	private Node reverseRecursive(Node curr, Node prev) {
		if (curr == null) {
			return prev;
		}
		Node newHead = reverseRecursive(curr.next, curr);
		curr.next = prev;
		return newHead;
	}

	public void reverseIterative() {
		Node curr = head;
		Node next = null;
		Node prev = null;
		Node newHead = null;
		while (true) {
			if (curr== null) {
				newHead = prev;
				break;
			}
			next = curr.next;
			curr.next = prev;
			prev=curr;
			curr = next;
		}
		head = newHead;
	}
}

class Node {
	int value;
	Node next;

	public Node(int n) {
		value = n;
	}
}