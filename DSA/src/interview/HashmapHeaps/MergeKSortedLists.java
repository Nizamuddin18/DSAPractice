package interview.HashmapHeaps;

import java.util.ArrayList;
import java.util.PriorityQueue;
public class MergeKSortedLists {
	class ListNode{
		int val;
		ListNode next;
		ListNode(){}
		ListNode(int val){
			this.val = val;
			this.next = null;
		}
		ListNode(int val , ListNode next){
			this.val = val;
			this.next = next;
		}
	}
	
	class Pair implements Comparable<Pair>{
		int li; 	//listIndex - > to keep track of which list the data belongs to
		int di ; 	// dataIndex - > to keep track of data index from the present list
		int val;	// value
		Pair(int li , int di , int val){
			this.li = li;
			this.di = di;
			this.val = val;
		}
		@Override
		public int compareTo(Pair other) {
			return this.val - other.val;
		}
	}
	
	class PairLL implements Comparable<PairLL>{
		ListNode node;
		PairLL(ListNode node){
			this.node = node;
		}
		
		@Override
		public int compareTo(PairLL o) {	
			return this.node.val - o.node.val;
		}	
	}
	
	public ArrayList<Integer> mergeKSortedLists(ArrayList<ArrayList<Integer>> lists) {
		ArrayList<Integer> rv = new ArrayList<>();
		PriorityQueue<Pair> pq = new PriorityQueue<>();
		
		for(int i = 0 ; i < lists.size() ; i++){
			Pair p = new Pair(i , 0 , lists.get(i).get(0));
			pq.add(p);
		}
		
		while(!pq.isEmpty()){
			Pair rem = pq.remove();
			rv.add(rem.val);
			rem.di++;
			
			if(rem.di < lists.get(rem.li).size()){
				rem.val = lists.get(rem.li).get(rem.di);
				pq.add(rem);
			}
			
		}
		return rv;
	}
	
	public ListNode mergeKSortedLL(ListNode[] lists){
		PriorityQueue<PairLL> pq = new PriorityQueue<>();
		for(int  i = 0 ; i < lists.length ; i++){
			if(lists[i] != null)
				pq.add(new PairLL(lists[i]));
		}
		
		ListNode dummy = new ListNode(-1);
		ListNode prev = dummy;
		while(!pq.isEmpty()){
			PairLL rem = pq.remove();
			prev.next = rem.node;
			prev = prev.next;
			
			if(rem.node.next != null){
				pq.add(new PairLL(rem.node.next));
			}
		}
		return dummy.next;
	}
	
	public static void main(String[] args) {
		MergeKSortedLists obj = new MergeKSortedLists();
		ArrayList<Integer> list1 = new ArrayList<>();
		ArrayList<Integer> list2 = new ArrayList<>();
		ArrayList<Integer> list3 = new ArrayList<>();
		ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
		System.out.println("Input : ");
		list1.add(10);
		list1.add(20);
		list1.add(30);
		list1.add(40);
		System.out.println(list1);
		list2.add(5);
		list2.add(9);
		list2.add(12);
		list2.add(18);
		list2.add(32);
		System.out.println(list2);
		list3.add(11);
		list3.add(15);
		list3.add(17);
		System.out.println(list3);
		lists.add(list1);
		lists.add(list2);
		lists.add(list3);
		ArrayList<Integer> res = obj.mergeKSortedLists(lists);
		System.out.println("Output : " + res);
	}

}
