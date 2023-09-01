package interview.Stacks;

import java.util.HashMap;

public class LRUCache {
	class Node{
		Node prev;
		int key;
		int value;
		Node next;
		Node(int key , int value){this.key = key;this.value = value;}
		Node(){}
	}
	Node head;
	Node tail;
	int N;
	static HashMap<Integer,Node> map = new HashMap<>();
	LRUCache(int N){
		this.N = N;
	}
	LRUCache(){}
	private void print(){
		Node temp = head;
		System.out.print("List : ");
		while(temp!=null){
			System.out.print(temp.value + " ");
			temp = temp.next;
		}
		System.out.println();
	}
	private Node createNode(int key , int value){
		Node temp = new Node(key , value);
		temp.prev = null;
		temp.next = null;
		return temp;
	}
	private void createList(Node temp){
		if(head == null && tail == null){
			head = temp;
			tail = temp;	
		}else{
			tail.next = temp;
			temp.prev = tail;
			tail = temp;
		}
	}
	private Node getLeastUsedNode(){
		Node temp = head;
		head = temp.next;
		temp.next.prev = null;
		return temp;
	}
	private void removeFromap(Node lru){
		map.remove(lru.key);
	}
	private void put(int key , int value){
		Node temp = createNode(key , value);
		if(map.size() >= N){
			Node lru = getLeastUsedNode();
			removeFromap(lru);
			
		}
		map.put(key, temp);
		createList(temp);
	}
	private void adjustNodes(int key){
		Node temp = map.get(key);
		temp.prev.next = temp.next;
		temp.next.prev = temp.prev;
		tail.next = temp;
		temp.prev = tail;
		temp.next = null;
		tail = temp;
	}
	private void get(int key){
		int value;
		if(map.containsKey(key)){
			value = map.get(key).value;
			adjustNodes(key);
		}else{
			value = -1;
		}
		System.out.println("get(" + key + ") : " + value);
	}
	
	public static void main(String[] args) {
		LRUCache lru = new LRUCache(5);
		lru.put(1, 10);
		lru.put(2, 20);
		lru.put(4, 30);
		lru.put(3, 40);
		lru.put(8, 50);
		lru.print();
		lru.get(4);
		lru.print();
		lru.get(2);
		lru.print();
		lru.get(7);
		lru.print();
		lru.put(5, 60);
		lru.print();
	}

}
