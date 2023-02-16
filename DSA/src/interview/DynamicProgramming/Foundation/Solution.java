package interview.DynamicProgramming.Foundation;

import java.util.Scanner;
public class Solution {
	private static boolean isSubsequence(String s, String t, int k, int l) {
		boolean t1[][];
		t1 = new boolean[k+1][l+1];
		int count = 0;
		for(int i=0;i<=k;i++)
			t1[i][0] = true;
		for(int i = 1; i<=k;i++){
			for(int j=1;j<=l;j++){
				if(s.charAt(i-1) == t.charAt(j-1)){
					t1[i][j] = true;
					count++;
				}
				else
					t1[i][j] = false;
			}
		}
		if(count == k)
			return true;
		else 
			return false;
	}
	
	
	public static int scoreGame(int n){
		if(n ==0) return 1;
		if( n < 0 ) return 0;
		int n1 = scoreGame(n-3);
		int n2 = scoreGame(n-5);
		int n3 = scoreGame(n-10);
		int tot = n1+n2+n3;
		return tot;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		/*String s = "aaa";
		String t = "ahbgdc";
		int k = s.length();
		int l = t.length();
		boolean isPresent = isSubsequence(s, t ,k, l);
		System.out.println(isPresent);*/
		/*int V = 3;
		int E = 3;
		int i = 0;
		ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<>();

		while(i++ < E){
			System.out.print("Enter Source : ");
			int u = sc.nextInt();
			System.out.println("Enter Destination : ");
			int v = sc.nextInt();
			System.out.println("Enter Weight : ");
			int w = sc.nextInt();
			ArrayList<Integer> t1 = new ArrayList<>();
			ArrayList<Integer> t2 = new ArrayList<>();
			t1.add(v);
			t1.add(w);
			t2.add(u);
			t2.add(w);
			System.out.println("T1 :" + t1);
			System.out.println("T2 :" + t2);
			adj.get(u).add(t1);
			adj.get(v).add(t2);
		}
		System.out.println("ADJ :" + adj);*/
		
		
		 int n = 8;
		 int result = scoreGame(n);
		 System.out.println(result);
	}

	

}
