package interview.DynamicProgramming.LCS;

public class MinNoInsertionAndDeletion {

	public static void main(String[] args) {
		LCSTabulation lcs = new LCSTabulation();
		String str1 = "heap";
		String str2 = "pea";
		int m = str1.length();
		int n = str2.length();
		int count = lcs.getLCSTabulation(str1, str2, m, n);
		int insertion = Math.abs(m - count);
		int deletion = Math.abs(n - count);
		System.out.println("MIN NO OF INSERTION : " + insertion);
		System.out.println("MIN NO OF DELETION : " + deletion);

	}

}
