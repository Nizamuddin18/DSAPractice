package interview.LinkedList;

public class MoveLastNodeToFirst {
	Node head;
	Node tail;

	class Node {
		int data;
		Node next;

		Node(int d) {
			data = d;
			next = null;
		}

		public Node() {
		}
	}

	public Node createNode(int val) {
		Node temp = new Node();
		temp.data = val;
		temp.next = null;
		return temp;
	}

	void moveToFront() {
		if (head == null || head.next == null)
			return;
		Node curr = head;
		Node prev = null;
		while (curr.next != null) {
			prev = curr;
			curr = curr.next;
		}
		prev.next = null;
		curr.next = head;
		head = curr;
	}

	public void push(int new_data) {
		Node temp = createNode(new_data);
		if (head == null && tail == null) {
			head = temp;
			tail = temp;
		} else {
			tail.next = temp;
			tail = temp;
		}
	}

	void printList() {
		Node temp = head;
		while (temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
		System.out.println();
	}

	/* Driver program to test above functions */
	public static void main(String args[]) {
		MoveLastNodeToFirst llist = new MoveLastNodeToFirst();
		/* Constructed Linked List is 1->2->3->4->5->null */
		llist.push(1);
		llist.push(2);
		llist.push(3);
		llist.push(4);
		llist.push(5);
		System.out.println("Linked List before moving last to front ");
		llist.printList();
		llist.moveToFront();
		System.out.println("Linked List after moving last to front ");
		llist.printList();
	}
}