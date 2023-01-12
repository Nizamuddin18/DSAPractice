package interview.HashmapHeaps;

import java.util.Collections;
import java.util.PriorityQueue;
class Pair2 implements Comparable<Pair2>{
	int x;
	int y;
	int distance;
	public Pair2(int x, int y , int distance){
		this.x = x;
		this.y = y;
		this.distance = distance;
	}
	public Pair2(){
		
	}
	
	
	@Override
	public String toString() {
		return "[x=" + x + ", y=" + y + "]";
	}
	public int compareTo(Pair2 p) {
		if(this.distance > p.distance)
			return 1;
		else if(this.distance < p.distance)
			return -1;
		else
			return 0;
	}
}
public class KClosestPoints {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int k = 2;
		int arr[][] = {
				{1,3},
				{-2,2},
				{5,8},
				{0,1}
				};
		PriorityQueue<Pair2> pq = new PriorityQueue<Pair2>(k+1, Collections.reverseOrder());
		for(int i =0 ;i< 4;i++){
			int x_Cord = arr[i][0]*arr[i][0];
			int y_Cord = arr[i][1]*arr[i][1];
			int dist = (int) Math.sqrt(x_Cord + y_Cord);
			pq.add(new Pair2(arr[i][0],arr[i][1],dist));
			if(pq.size() > k){
				pq.remove();
			}	
		}
		System.out.println("Closest Points : " +pq);
	}

}
