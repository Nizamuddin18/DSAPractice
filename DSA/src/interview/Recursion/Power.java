package interview.Recursion;

public class Power {
	private static int getPower(int n, int i) {
		if(i == 0)
			return 1;
		int res = getPower(n , i-1);
		return n*res;
	}
	public static void main(String[] args) {
		int n = 3;
		int i = 0;
		int power = getPower(n , i);
		System.out.println(n + "^" + i +" = " + power);
	}
}
