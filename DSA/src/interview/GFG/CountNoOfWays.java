package interview.GFG;

public class CountNoOfWays {

	public static void main(String[] args) {
		getCount(3 , "");
	}
	
	public static void getCount(int n , String psf){
		if(n == 0) {
			System.out.println(psf + " ");
			return;
		}
		getCount(n-1 , psf + (n-1));
		getCount(n-2, psf + (n-1));
		
		
	}

}
