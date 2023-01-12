package interview.LinkedList;


public class AddNumberToLinkedList{
	NodeList head;
	NodeList tail;
	class NodeList{
		int data;
		NodeList next;
		NodeList(int data){
			this.data = data;
		}
		NodeList(){}
	}
	public NodeList createNode(int val){
		NodeList temp = new NodeList();
		temp.data = val;
		temp.next = null;
		return temp;
	}
	 public void push(int new_data) 
	    { 
	    	NodeList temp = createNode(new_data);
	        if(head == null && tail == null){
	        	head = temp;
				tail = temp;
	        }else{
	        	tail.next = temp;
				tail = temp;
	        }
	    } 
	 public void printList(NodeList head) 
	    { 
		 NodeList temp = head; 
	        while(temp != null) 
	        { 
	           System.out.print(" " + temp.data+" "); 
	           temp = temp.next; 
	        }   
	        System.out.println(); 
	    } 
	 
	 public NodeList reverse(NodeList head){
		 NodeList cur = head;
		 NodeList prev = null;
		 NodeList forward = null;
		 while(cur!=null){
			 forward = cur.next;
			 cur.next =  prev;
			 prev = cur;
			 cur = forward;
		 }
		 return prev;
	 }
	 public NodeList add1toNumber(NodeList nHead) {
		 int val = 1;
		 nHead.data = nHead.data + val;
		 NodeList temp = nHead;
		 NodeList prev = null;
		 int carry = 0;
		 while(temp!=null && (temp.data > 9 || carry > 0)){
			 temp.data = temp.data + carry;
			 carry = temp.data/10;
			 int rem = temp.data%10;
			 temp.data = rem;
			 prev = temp;
			 temp = temp.next;
		 }
		 if(carry > 0){
			 NodeList newNode = createNode(carry);
			 prev.next = newNode;
		 }
		 return nHead;
		}
	public static void main(String args[]){
		AddNumberToLinkedList ll = new AddNumberToLinkedList();
		NodeList rHead , nHead;
		ll.push(9);
		ll.push(9);
		ll.push(9);
		System.out.println("::::: PROGRAM TO ADD 1 NUMBER TO LINKED LIST :::::");
		System.out.print("Input  : ");
		ll.printList(ll.head);
		rHead = ll.reverse(ll.head);
		nHead = ll.add1toNumber(rHead);
		nHead = ll.reverse(nHead);
		System.out.print("OutPut : ");
		ll.printList(nHead);
	}
	
}