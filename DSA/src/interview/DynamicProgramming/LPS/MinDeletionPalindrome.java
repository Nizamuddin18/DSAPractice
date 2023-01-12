package interview.DynamicProgramming.LPS;

public class MinDeletionPalindrome {

	public static void main(String[] args) {
		LongestPalindromicSubsequence lps = new LongestPalindromicSubsequence();
		String str = "agbcba";
		int count = lps.getPalindromicSubSequence1(str);
		int length = str.length();
		int val = length - count;
		System.out.println("MINIMUM NO OF DELETION TO MAKE PALINDROME : " + val);

	}
}
