package interview.LinkedList;

import java.util.Scanner;

public class LinkedListDriver {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("======== Linked List Operations ========");
		LinkedListCustom l = new LinkedListCustom();
		System.out.println("1.Display LinkedList");
		System.out.println("2.Add First to LinkedList");
		System.out.println("3.Add Last to LinkedList");
		System.out.println("4.Size of LinkedList");
		System.out.println("5.Rotate LinkedList");
		System.out.println("7.Reverse LinkedList");
		System.out.println("8.Add At Specific Position to LinkedList");
		System.out.println("9.Kth Element from End");
		System.out.println("10.Middle of LinkedList");
		System.out.println("11.Merge Sort Of LinkedList");
		System.out.println("12.Remove duplicates from a sorted linked list");
		System.out.println("13.Linked List To Stack");
		System.out.println("14.Fold LinkedList");
		System.out.println("15.Segregate Odd evn Linked List");
		System.out.println("16.Remove First from LinkedList");
		System.out.println("17.Remove Last from LinkedList");
		System.out.println("18.Remove At from LinkedList");
		System.out.println("19.Merge Two Sorted LinkedList");
		System.out.println("20.K Reverse LinkedList");
		System.out.println("21.Is Plaindrome ? ");
		System.out.println("22.Mid Node1 and Mid Node 2 :  ");
		System.out.println("23.Next Greater Node :  ");
		System.out.println("24.Add 2 numbers LinkedList : ");
		System.out.println("25.Reverse in K Groups ");
		System.out.println("26.Remove Duplicates ");
		while(true){
			System.out.println("Enter Choice (Press -1 to exit) : ");
			int choice = sc.nextInt();
			switch(choice){
			case 1 :
				l.printList();
				break;
				
			case 2 :
				System.out.println("Enter Value To be Added :");
				int dataFirst = sc.nextInt();
				l.addFirst(dataFirst);
				break;
				
			case 3 :
				System.out.println("Enter Value To be Added :");
				int dataLast = sc.nextInt();
				l.addLast(dataLast);
				break;
				
			case 4 :
				int size = l.getSize();
				System.out.println("Size :" + size);
				break;
			
			case 5 : 
				System.out.println("Enter K value :");
				int k = sc.nextInt();
				l.rotateLinkedList(k);
				break;
				
			case 6 :
				System.out.println("Loop detection :");
				boolean isCycle = l.cycleDetection();
				if(isCycle)
					System.out.println("true");
				else
					System.out.println("false");
				break;
				
			case 7 :
				System.out.println("Original Linked List :");
				l.printList();
				l.reverseLinkedList();
				System.out.println("Reversed Linked List :");
				l.printList();
				break;
				
			case 8 :
				System.out.println("Enter index : ");
				int index = sc.nextInt();
				System.out.println("Enter value to be added");
				int dataAtPos = sc.nextInt();
				l.addAtIndex(index, dataAtPos);
				break;
				
			case 9 :
				int element = l.kthFromLast(2);
				System.out.println("Kth Element from Last is : " + element);
				break;
			
			case 10 :
				int mid = l.getMid();
				System.out.println("Element at Middle of LinkedList : " + mid);
				break;
			
			case 11 :
				size = l.getSize();
				int startIndex = 0;
				int endIndex = size - 1;
				Node li = l.getAt(startIndex);
				Node ri = l.getAt(endIndex);
				l.mergeSort(li, ri);
				break;
			case 12 :
				System.out.println("Before Removal of Duplicates : ");
				l.printList();
				l.removeDuplicate();
				System.out.println("After Removal of Duplicates  : ");
				l.printList();
				break;
			case 13 : 
				System.out.println("Linked List To Stack");
				boolean flag = true;
				while(flag){
					System.out.println("1.PUSH\n2.POP\n3.TOP\n4.PRINT\n-1. Exit Stack...");
					System.out.println("Enter Choice");
					int choiceSt = sc.nextInt();
					switch(choiceSt){
					case 1: 
						System.out.println("Enter Data : ");
						int data = sc.nextInt();
						l.addFirst(data);
						break;
					case 2 : 
						l.removeFirst();
						break;
					case 3 : 
						l.checkTop();
						break;
					case 4 : 
						l.printList();
						break;
					default : 
						flag = false;
					}
				}
			case 14 : 
				l.foldLinkedList();
				break;
			case 15 : 
				l.oddEvenSegregate();
				l.printList();
				break;
			case 16 : 
				l.removeFirst();
				l.printList();
				break;
			case 17 : 
				l.removeLast();
				l.printList();
				break;
			case 18 : 
				System.out.println("Enter Position to be Removed : ");
				int pos = sc.nextInt();
				l.removeAt(pos);
				l.printList();
				break;
			case 19 :
				LinkedListCustom l1 = new LinkedListCustom();
				LinkedListCustom l2 = new LinkedListCustom();
				l1.addLast(5);
				l1.addLast(10);
				l1.addLast(15);
				System.out.print("List1 : ");
				l1.printList();
				
				l2.addLast(2);
				l2.addLast(3);
				l2.addLast(20);
				System.out.print("List2 : ");
				l2.printList();
				l.head = l.mergeTwoSortedLists(l1.head , l2.head);
				System.out.print("Sorted List : ");
				l.printList();
				
				break;
			case 20 : 
				l.printList();
				int krev = 3;
				l.kReverese(krev);
				l.printList();
				break;
			case 21 : 
				l.printList();
				boolean ret_flag = l.IsPlaindrome(l.head);
				System.out.println("Is Plaindrome ? " + ret_flag);
				break;
			case 22 :
				l.printList();
				Node mid1 = l.getMidNode1();
				Node mid2 = l.getMidNode2();
				System.out.println("Mid Node1 : " + mid1.data);
				System.out.println("Mid Node2 : " + mid2.data);
				break;
			case 23 : 
				l.printList();
				int arr[] = l.nextGreaterNode(l.head);
				for(int i = 0 ; i < arr.length ; i++)
					System.out.print(arr[i] + " ");
				break;
			case 24 : 
				LinkedListCustom ll1 = new LinkedListCustom();
				LinkedListCustom ll2 = new LinkedListCustom();
				ll1.addLast(7);
				ll1.addLast(2);
				ll1.addLast(4);
				ll1.addLast(3);
				
				ll2.addLast(5);
				ll2.addLast(6);
				ll2.addLast(4);
				l.addTwoNumbers(ll1.head, ll2.head);
				break;
			case 25:
				LinkedListCustom llc1 = new LinkedListCustom();
				int k_group = 3;
				llc1.addLast(1);
				llc1.addLast(2);
				llc1.addLast(3);
				llc1.addLast(4);
				llc1.addLast(5);
				llc1.addLast(6);
				llc1.addLast(7);
				llc1.addLast(8);
				//llc1.addLast(9);
				System.out.println("Input List : ");
				llc1.printList();
				Node rev_head = llc1.KReverseInGroup(llc1.head , k_group);
				System.out.println("Reversed List : ");
				llc1.printListCustom(rev_head);
				break;
			case 26:
				LinkedListCustom list1 = new LinkedListCustom();
				list1.addLast(1);
				list1.addLast(2);
				list1.addLast(3);
				list1.addLast(3);
				list1.addLast(4);
				list1.addLast(4);
				list1.addLast(5);
				System.out.println("Input List : ");
				list1.printList();
				Node ret_head = list1.removeDuplicates(list1.head);
				System.out.println("List after Removal of Duplicates");
				list1.printListCustom(ret_head);
				break;
			default :
				System.out.println("...Quit...");
				System.exit(0);
			}
		}
	}
}
