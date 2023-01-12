package interview.Foundation.Recursion;
import java.util.Scanner;

public class PrintEncodings {
	private static void printEncodings(String str , String asf){
		if(str.length() == 0){
			System.out.println(asf);
			return;
		}
		int n1 = str.charAt(0) - '0';
		if(n1 == 0){
			return;
		}
		char ch1 = (char)(n1 + 'a' -1);
		String roq1 = str.substring(1);
		printEncodings(roq1 , asf +  ch1);
		
		if(str.length() > 1){
			int n2 = str.charAt(1) - '0';
			int n = n1 * 10 + n2;
			if(n <= 26){
				char ch2 = (char)(n + 'a' - 1);
				String roq2 = str.substring(2);
				printEncodings(roq2 , asf + ch2);
			}
		}
		
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter String : ");
		String str = sc.nextLine();
		printEncodings(str, "");

	}

}
