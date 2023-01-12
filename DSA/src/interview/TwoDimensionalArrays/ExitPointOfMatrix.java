package interview.TwoDimensionalArrays;
import java.util.*;
public class ExitPointOfMatrix {
	private static void exitPointOfBoard(int arr[][]){
		int i = 0;
		int j = 0;
		int direct = 0;
		while(i >= 0 && i < arr.length && j >= 0 && j < arr[0].length){	
			direct = (direct + arr[i][j]) % 4;
			if(direct == 0){
				j++;
			}else if(direct  == 1){
				i++;
			}else if(direct == 2){
				j--;
			}else if(direct == 3){
				i--;
			}
		}
		if(direct == 0){
			j--;
		}else if(direct  == 1){
			i--;
		}else if(direct == 2){
			j++;
		}else if(direct == 3){
			i++;
		}
		System.out.println(i);
		System.out.println(j);
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//System.out.println("Enter row : ");
		int n = sc.nextInt();
		//System.out.println("Enter Column :");
		int m = sc.nextInt();
		int arr[][] = new int [n][m];
		for(int i = 0 ; i < n ; i++){
			for(int j = 0 ; j < m ; j++){
				arr[i][j] = sc.nextInt();
			}
		}
		exitPointOfBoard(arr);
	}

}
