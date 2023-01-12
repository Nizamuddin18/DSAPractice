package interview.LinkedList;

public class IntersectionPointsOfTwoLL {
	class Node{
		int data;
		Node next;
		Node(int data){this.data = data;}
		Node(){}
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
	private Node findIntersectionPoint(IntersectionPointsOfTwoLL list1 , IntersectionPointsOfTwoLL list2){
		int sizeDiff = Math.abs(list1.size - list2.size);
		Node l1 = list1.head;
		Node l2 = list2.head;
		if (list1.size > list2.size) {
			for (int i = 0; i < sizeDiff; ++i) {
				l1 = l1.next;
			}
		}else{
			for (int i = 0; i < sizeDiff; ++i) {
				l2 = l2.next;
			}
		}
		while(l1.data!=l2.data){
			l1 = l1.next;
			l2 = l2.next;
		}
		return l1;
	}
	public static void main(String[] args) {
		IntersectionPointsOfTwoLL list1 = new IntersectionPointsOfTwoLL();
		IntersectionPointsOfTwoLL list2 = new IntersectionPointsOfTwoLL();
		IntersectionPointsOfTwoLL list3 = new IntersectionPointsOfTwoLL();
		System.out.println("Input : ");
		list1.push(10);
		list1.push(20);
		list1.push(30);
		list1.push(50);
		list1.push(55);
		list1.push(70);
		System.out.print("List1 : ");
		list1.print();
		list2.push(15);
		list2.push(35);
		list2.push(50);
		list2.push(55);
		list2.push(70);
		System.out.print("List2 : ");
		list2.print();
		Node mergePoint = list3.findIntersectionPoint(list1,list2);
		System.out.println("Output : " + mergePoint.data);
	}

}
