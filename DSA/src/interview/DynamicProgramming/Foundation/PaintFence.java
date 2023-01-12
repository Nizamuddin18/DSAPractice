package interview.DynamicProgramming.Foundation;

public class PaintFence {

	public static void main(String[] args) {
		long n = 5;
		long k = 3;
		long same = k*1;
		long diff = k*(k-1);
		long total = same + diff;
		for(int i = 3 ; i <= n ; i++){
			same = diff;
			diff = total*(k-1);
			total = same + diff;
		}
		System.out.println("TOTAL NO OF WAYS : " + total);

	}

}
