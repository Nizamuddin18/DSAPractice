package interview.DynamicProgramming.Foundation;

public class FriendsPairing {

	private static int friendsPairing(int n) {
		int dp[] = new int[n+1];
		dp[1] = 1;
		dp[2] = 2;
		for(int i = 3; i < dp.length ; i++)
			dp[i] = dp[i-1] + (n-1 * dp[i-2]);
		
		return dp[n];
	}

	public static void main(String[] args) {
		int n = 3; // n is no of friends
		int noofPairing = friendsPairing(n);
		System.out.println("No of Pairing possible for " + n + " friends : " + noofPairing);
	}

}
