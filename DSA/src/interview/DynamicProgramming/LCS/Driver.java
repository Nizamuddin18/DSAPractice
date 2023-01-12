package interview.DynamicProgramming.LCS;

import java.util.Scanner;

public class Driver {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String x = "abcdgh";
		String y = "abedfhr";
		LCSRecursive lcsrec = new LCSRecursive();
		LCSMemoize lcsmemo = new LCSMemoize();
		LCSTabulation lcstab = new LCSTabulation();
		System.out.println("1. LCS Recursive ");
		System.out.println("2. LCS Memoize ");
		System.out.println("3. LCS Tabulation ");
		System.out.println("4. LCS Tabulation 2");
		int m = x.length();
		int n = y.length();
		boolean res = true;
		while(res){
			System.out.println("Enter Choice...");
			int choice = sc.nextInt();
			switch(choice){
			case 1 : 
				int count = lcsrec.getLCS(x , y , m , n);
				System.out.println("Longest Common Subsequence Recursive : " + count);
				break;
			case 2 : 
				int dp[][] = new int[m+1][n+1];
				for(int i = 0 ; i < dp.length ; i++){
					for(int j = 0 ; j < dp[0].length ; j++){
						dp[i][j] = -1;
					}
				}
				int memo = lcsmemo.getLCSMemoize(x, y, m, n, dp);
				System.out.println("Longest Common Subsequence Memoize : " + memo);
				break;
			case 3 :
				int tabulation = lcstab.getLCSTabulation(x, y, m, n);
				System.out.println("Longest Common Subsequence Tabulation : " + tabulation);
				break;
			case 4 :
				int tabulation2 = lcstab.getLCSTabulation2(x, y, m, n);
				System.out.println("Longest Common Subsequence Tabulation 2: " + tabulation2);
				break;
			default : 
				res = false;
			}
		}
	}

}
