package interview.HashmapHeaps;

import java.util.Collections;
import java.util.HashMap;
import java.util.PriorityQueue;
class NonRepeatingPair implements Comparable<NonRepeatingPair>{
	char ch;
	int count;
	NonRepeatingPair (char ch , int count){
		this.ch = ch;
		this.count = count;
	}
	public int compareTo(NonRepeatingPair p) {
		if(this.count > p.count)
			return 1;
		else if(this.count < p.count)
			return -1;
		else
			return 0;
	}
}
public class KNonRepeatingCharacters {
	
	private static void findKNonRepeating(String str, int k) {
		HashMap<Character , Integer> map = new HashMap<>();
		PriorityQueue<NonRepeatingPair> pq = new PriorityQueue<NonRepeatingPair>(k+1, Collections.reverseOrder());
		for(int i = 0 ; i < str.length() ; i++){
			char ch = str.charAt(i);
			if(map.containsKey(ch))
			{
				int val = map.get(ch);
				map.put(ch, val+1);
			}else{
				map.put(ch, 1);
			}
		}
		System.out.println("Map : " + map);
		int size = 0;
		for(Character c : map.keySet()){
			NonRepeatingPair pair = new NonRepeatingPair(c , map.get(c));
			pq.add(pair);
			if(pq.size() > k)
				pq.remove();
		}
		for(NonRepeatingPair p : pq)
			System.out.print(" " + p.ch);
	}
	public static void main(String[] args) {
		String str = "ABCDBAGHCHFAC";
		int k = 3;
		findKNonRepeating(str , k);

	}

	

}
