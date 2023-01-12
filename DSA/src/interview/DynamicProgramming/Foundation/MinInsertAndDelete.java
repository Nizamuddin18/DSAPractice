package interview.DynamicProgramming.Foundation;

public class MinInsertAndDelete {
	static int t[][];
	private int getLCSMemo(String x, String y, int m, int n) {
		t = new int[m+1][n+1];
		for(int i=1; i<= m; i++){
			for(int j =1; j<=n; j++){
				if(x.charAt(i-1) == y.charAt(j-1)){
					t[i][j] = 1+ t[i-1][j-1];
				}
				else{
					t[i][j] = Math.max(t[i][j-1], 
							t[i-1][j]);
				}
			}
		}
		return t[m][n];
	}
	public static void main(String[] args) {
		MinInsertAndDelete minIandD = new MinInsertAndDelete();
		String x = "geeksforgeeks";
		String y = "geeks";
		int m = x.length();
		int n = y.length();
		int deletion;
		int insertion;
		int lcs = minIandD.getLCSMemo(x, y, m, n);
		deletion = m - lcs;
		insertion = n - lcs;
		System.out.println("Minimum Number of Deletion : " + deletion +"\nMinimum Number of Insertion : " + insertion);
	}

}
