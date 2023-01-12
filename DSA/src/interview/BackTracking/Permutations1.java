package interview.BackTracking;
import java.util.*;
/*Permutation using ITEMS on LEVEL ORDER and BOXES on OPTIONS
 * Boxes = An Array of No. of Boxes in which unidentical i.e distinct items can be placed
 */
public class Permutations1 {

	public static void main(String[] args) {
		/* There n Boxes and r items = > In how many possible ways can these be arranged */
		int nboxes = 4;
		int ritems = 3;
		// nboxes[] = {0,0,0,0} this array is used to show that at which place items to be placed
		permutations(1 ,new int[nboxes] ,ritems); 

	}
	
	private static void permutations(int curItem, int[] boxes, int totItem) {
		if (curItem > totItem) {
			for (int i = 0; i < boxes.length; i++) {
				System.out.print(boxes[i]);
			}
			System.out.println();
			return;
		}
		for (int i = 0; i < boxes.length; i++) {
			if (boxes[i] == 0) {
				boxes[i] = curItem; // Items Placed
				permutations(curItem + 1, boxes, totItem);
				boxes[i] = 0; // BackTracking
			}
		}
	}

}
