package interview.LinkedList;

public class CheckCircularLL {
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

	Node head;
	Node tail;
	int size;

	private int size() {
		return this.size;
	}

	private void print() {
		Node temp = head;
		while (temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
		System.out.println();
	}

	private Node createNode(int data) {
		Node node = new Node();
		node.data = data;
		node.next = null;
		return node;
	}

	private void push(int data) {
		Node node = createNode(data);
		if (head == null && tail == null) {
			head = node;
			tail = node;
		} else {
			tail.next = node;
			tail = node;
		}
		size++;
	}

	private void makeCircular(){
		Node temp = head;
		while(temp.next!=null){
			temp = temp.next;
		}
		temp.next = head;
	}
	
	private boolean checkCircular(){
		boolean flag = false;
		Node temp = head;
		while(temp!=null){
			if(temp.next == head){
				flag = true;
				break;
			}
			temp = temp.next;
		}
		return flag;
	}
	public static void main(String[] args) {
		CheckCircularLL list1 = new CheckCircularLL();

		System.out.println("Input : ");
		list1.push(1);
		list1.push(2);
		list1.push(3);
		list1.push(4);
		list1.push(5);
		list1.push(6);
		System.out.print("List : ");
		//list1.makeCircular();
		boolean retFlag = list1.checkCircular();
		System.out.print("Output : " + retFlag);
	}
}
