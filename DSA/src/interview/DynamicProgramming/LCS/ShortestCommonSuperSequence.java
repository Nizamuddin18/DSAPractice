package interview.DynamicProgramming.LCS;

public class ShortestCommonSuperSequence {
	int getCommonSuperSequence(String a, String b, int m, int n){
		LCSTabulation longestcommonsubsequence = new LCSTabulation();
		int lcs = longestcommonsubsequence.getLCSTabulation(a, b, m, n);
		int ret_num = (m + n) - lcs;
		return ret_num;
	}
}
