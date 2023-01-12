package interview.LinkedList;


public class IntersectionOfTwoSortedLL {
	class Node{
		int data;
		Node next;
		Node(int data){this.data = data;}
		Node(){}
		@Override
		public String toString() {
			return "(" + data + ")";
		}
	}
	Node head;
	Node tail;
	int size;
	private int size(){
		return this.size;
	}
	private void print(){
		Node temp = head;
		while(temp!=null){
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
		System.out.println();
	}
	private Node createNode(int data){
		Node node = new Node();
		node.data = data;
		node.next = null;
		return node;
	}
	private void push(int data){
		Node node = createNode(data);
		if(head == null && tail == null){
			head = node;
			tail = node;
		}else{
			tail.next = node;
			tail = node;
		}
		size++;
	}
	private void addLast(int data){
		Node temp = createNode(data);
		if(this.head == null && this.tail == null){
			this.head = temp;
			this.tail = temp;
		}else{
			this.tail.next = temp;
			this.tail = temp;
		}
	}
	private void getIntersectionNodes(IntersectionOfTwoSortedLL list1 , IntersectionOfTwoSortedLL list2){
		Node l1 = list1.head;
		Node l2 = list2.head;
		while(l1!=null && l2!=null){
			if(l1.data==l2.data){
				addLast(l2.data);
				l2 = l2.next;
			}
			l1 = l1.next;
		}
	}
	public static void main(String[] args) {
		IntersectionOfTwoSortedLL list1 = new IntersectionOfTwoSortedLL();
		IntersectionOfTwoSortedLL list2 = new IntersectionOfTwoSortedLL();
		IntersectionOfTwoSortedLL list3 = new IntersectionOfTwoSortedLL();
		System.out.println("Input : ");
		list1.push(1);
		list1.push(2);
		list1.push(3);
		list1.push(4);
		list1.push(6);
		System.out.print("List1 : ");
		list1.print();
		list2.push(2);
		list2.push(4);
		list2.push(6);
		list2.push(8);
		System.out.print("List2 : ");
		list2.print();
		list3.getIntersectionNodes(list1, list2);
		System.out.print("Output : ");
		list3.print();
	}
}
