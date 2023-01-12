package interview.BackTracking;
/*
 if n = 5 
 Sequence  : 0 1 2 3 4
 k = 3
 I can kill the values at k steps starting from 0
 ex : 0 1 2 thus 2 is killed
 	Remaining 0,1 is shifted to right side of 3,4 thus new sequence looks like
 					3 4 0 1  will be converted to
 					0 1 2 3
 	0 1 2 thus 2 is killed
 	 	Remaining 0,1 is shifted to right side of 3 thus new sequence looks like
 	 				3 0 1 will be converted to
 	 				0 1 2
 	0 1 thus 2 is killed 
 	 	Remaining 0,1 is shifted to right side thus new sequence looks like 
 	 				0 1 will be converted to 
 	 				0 1
 	0 1 thus 0 is killed
 		Remaining 1 
 				1 will be converted to 
 				0

 */
public class JosephusProblem {

	public static void main(String[] args) {
		int n = 5;
		int k = 3;
		int ret_val = josephusSolution(n , k);
		System.out.println(ret_val);

	}
	private static int josephusSolution(int  n , int k){
		if(n==1)
			return 0;
		int x = josephusSolution(n-1 , k);
		int y = (x + k) % n;
		return y;
		
	}

}
