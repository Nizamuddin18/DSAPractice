package interview.Arrays.SlidingWindow;

public class Housing {

	public static void main(String[] args) {
		int plots[] = {1,3,2,1,4,1,3,2,1,1};
		int k = 8;
		housingPlots(plots , k);
		int smallestWindow = smallestWindowHousingPlots(plots , k);
		System.out.println("Smallest Window size : " + smallestWindow );
	}

	private static int smallestWindowHousingPlots(int[] plots, int k) {
		int i = 0;
		int j = 0;
		int cur_sum = 0;
		int minWindow = Integer.MAX_VALUE;
		while(j < plots.length){
			cur_sum += plots[j];
			j++;
			while(cur_sum > k && i < j){
				cur_sum = cur_sum - plots[i];
				i++;
			}
			if(cur_sum == k){
				int windowSize = j - i;
				minWindow = Math.min(minWindow , windowSize);
			}
		}
		return minWindow;
	}

	private static void housingPlots(int[] plots, int k) {
		int i = 0;
		int j = 0;
		int cur_sum = 0;
		while(j < plots.length){
			//expansion
			cur_sum += plots[j];
			j++; 
			
			// remove and Contraction
			while(cur_sum > k && i < j){
				cur_sum = cur_sum - plots[i];
				i++;
			}
			
			if(cur_sum == k){
				System.out.println("[" + i + " , " + (j-1) + "]");
			}
		}
	}

}
