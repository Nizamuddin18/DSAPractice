package interview.Stacks;

import java.util.Stack;

public class CelebrityProblem {
	public static void findCelebrity(int[][] arr) {
        // if a celebrity is there print it's index (not position), if there is not then
        // print "none"
		Stack<Integer> st = new Stack<>();
		int len = arr.length;
		for(int i = 0 ; i < len ; i++)
			st.push(i);
		while(st.size() > 1){
			int i = st.pop();
			int j = st.pop();
			if(arr[i][j] == 1){
				//i knows j thus i  is not celebrity
				st.push(j);
			}else{
				////j knows i thus j  is not celebrity
				st.push(i);
			}
		}
		
		int celeb = st.pop();
		for(int i = 0 ; i < arr.length ; i++){
			if(i != celeb){
				if(arr[i][celeb] == 0 || arr[celeb][i] == 1){
					System.out.println("none");
					return;
				}
			}
		}
		System.out.println("Celebrity : " + celeb);
    }

	public static void main(String[] args) {
		int matrix[][] = {
						{1,0,1,0,1},
						{1,1,1,1,0},
						{0,0,0,0,0},
						{1,0,1,1,0},
						{0,1,1,1,0}};
		findCelebrity(matrix);
	}

}
