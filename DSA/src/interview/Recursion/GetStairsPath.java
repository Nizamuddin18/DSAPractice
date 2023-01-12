package interview.Recursion;
import java.util.*;

public class GetStairsPath {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Stair Path Size :");
		int n = sc.nextInt();
		ArrayList<String> stairPath = getStairPath(n);
		System.out.println(stairPath);

	}

	private static ArrayList<String> getStairPath(int n) {
		if(n == 0){
			ArrayList<String> baseCase = new ArrayList<>();
			baseCase.add("");
			return baseCase;
		}else if(n < 0){
			ArrayList<String> baseCaseNeg = new ArrayList<>();
			return baseCaseNeg;
		}
		
		ArrayList<String> path1 = getStairPath(n-1);
		ArrayList<String> path2 = getStairPath(n-2);
		ArrayList<String> path3 = getStairPath(n-3);
		ArrayList<String> paths = new ArrayList<>();
		
		for(String path : path1)
			paths.add(1 + path);
		for(String path : path2)
			paths.add(2 + path);
		for(String path : path3)
			paths.add(3 + path);
		return paths;

	}

}
