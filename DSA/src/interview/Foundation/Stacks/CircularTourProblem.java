package interview.Foundation.Stacks;

public class CircularTourProblem {
	private static int circularTour(int petrol[] , int dist[]){
		int sum = 0;
		int diff = 0;
		int start = 0;
		//expected output  = 1(index from where tour starts)
		for(int i = 0 ; i < petrol.length ; i++){
			sum = petrol[i] - dist[i];
			if(sum < 0){
				diff = sum + diff;
				sum = 0;
				start = i+1;
			}
		}
		if(sum >= 0) 
			return start;
		else
			return -1;
	}
	public static void main(String[] args) {
		int petrol[] = {1,2,3,4,5};
		int dist[] = {3,4,5,1,2};
		int retIndex = circularTour(petrol , dist);
		System.out.println("Index from which tour starts : " + retIndex);
	}
	

}
