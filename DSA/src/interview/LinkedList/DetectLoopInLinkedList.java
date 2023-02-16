package interview.LinkedList;

import java.util.Scanner;
public class DetectLoopInLinkedList {
	class NodeList {
		int data;
		NodeList next;

		NodeList(int data) {
			this.data = data;
		}

		NodeList() {

		}
	}
	
	NodeList head;

	private void printList(NodeList temp) {
		while (temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
	}

	private NodeList detectLoop(NodeList head) {
		NodeList slow = head;
		NodeList fast = head;
		boolean flag = false;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) {
				flag = true;
				break;
			}
		}
		if (flag) {
			slow = head;
			while (slow.next != fast.next) {
				slow = slow.next;
				fast = fast.next;
			}
		}
		return fast;
	}

	private void detectAndRemoveLoop(NodeList head) {
		NodeList slow = head;
		NodeList fast = head;
		boolean flag = false;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) {
				flag = true;
				break;
			}
		}
		if (flag) {
			slow = head;
			while (slow.next != fast.next) {
				slow = slow.next;
				fast = fast.next;
			}
			fast.next = null;
		}
	}
	
	private void check() {
		Scanner sc = new Scanner(System.in);
		System.out.println("1.Detect Loop in LinkedList\n2.Detect and Remove Loop in Linked List");
		System.out.println("Enter Choice : ");
		int choice = sc.nextInt();
        head = new NodeList(50);
        head.next = new NodeList(20);
        head.next.next = new NodeList(15);
        head.next.next.next = new NodeList(4);
        head.next.next.next.next = new NodeList(10);
        // Creating a loop for testing
        head.next.next.next.next.next = head.next.next;
        
        if(choice == 1){
        	NodeList loopingNode = detectLoop(head);
	        System.out.println("Loop starts in Linked List from Node : " + loopingNode.data);
        }else if(choice == 2){
            detectAndRemoveLoop(head);
	        System.out.println("Linked List after removing loop : ");
	        printList(head);
        }else{
        	
        }
	}
	
	public static void main(String[] args) {
		DetectLoopInLinkedList list = new DetectLoopInLinkedList();
		list.check();
	}
	
}
