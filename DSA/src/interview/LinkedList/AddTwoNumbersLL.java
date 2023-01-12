package interview.LinkedList;

public class AddTwoNumbersLL {
	Node head;
	Node tail;

	class Node {
		int data;
		Node next;

		Node(int data) {
			this.data = data;
		}

		Node() {
		}

		@Override
		public String toString() {
			return "(" + data + ")";
		}

	}

	public Node createNode(int val) {
		Node temp = new Node();
		temp.data = val;
		temp.next = null;
		return temp;
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

	public void printList(Node head) {
		Node temp = head;
		while (temp != null) {
			System.out.print(" " + temp.data + " ");
			temp = temp.next;
		}
		System.out.println();
	}

	public Node reverse(Node head) {
		Node cur = head;
		Node prev = null;
		Node forward = null;
		while (cur != null) {
			forward = cur.next;
			cur.next = prev;
			prev = cur;
			cur = forward;
		}
		return prev;
	}

	private Node addTowNumbers(AddTwoNumbersLL list1, AddTwoNumbersLL list2) {
		AddTwoNumbersLL sumList = new AddTwoNumbersLL();
		int sum = 0, carry = 0;
		Node dummy = createNode(0);
		// Node tail = dummy;
		Node l1 = list1.head;
		Node l2 = list2.head;
		while (l1 != null || l2 != null || carry > 0) {
			sum = 0;
			if (l1 != null) {
				sum = sum + l1.data;
				l1 = l1.next;
			}
			if (l2 != null) {
				sum = sum + l2.data;
				l2 = l2.next;
			}
			sum = sum + carry;
			carry = sum / 10;
			int rem = sum % 10;
			Node newNode = createNode(rem);
			if (sumList.head == null && sumList.tail == null) {
				sumList.head = newNode;
				sumList.tail = newNode;
			} else {
				sumList.tail.next = newNode;
				sumList.tail = newNode;
			}
		}
		return sumList.head;
	}
	
	
	public static void main(String args[]) {
		AddTwoNumbersLL list1 = new AddTwoNumbersLL();
		AddTwoNumbersLL list2 = new AddTwoNumbersLL();
		list1.push(2);
		list1.push(4);
		list1.push(3);

		list2.push(5);
		list2.push(6);
		list2.push(4);
		System.out.print("List 1 : ");
		list1.printList(list1.head);
		System.out.print("List 2 : ");
		list2.printList(list2.head);
		Node sumHead = list1.addTowNumbers(list1, list2);
		System.out.print("Added List  : ");
		list1.printList(sumHead);
	}

	

}
