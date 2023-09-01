package interview.Recursion;

public class LogarithmicPower {
	private static int getLogarithmicPower(int n, int i) {
		if(i == 0) return 1;
		int halfpower = getLogarithmicPower(n , i/2);
		int xn = halfpower * halfpower;
		if(i%2!=0)
			xn = n * xn;
		return xn;
	}
	public static void main(String[] args) {
		int n = 2;
		int i = 5;
		int power = getLogarithmicPower(n , i);
		System.out.println(n + "^" + i +" = " + power);
	}
}
