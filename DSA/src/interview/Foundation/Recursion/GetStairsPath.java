package interview.Recursion;

import java.util.ArrayList;
import java.util.Scanner;
public class GetStairsPath {
	
	private static ArrayList<String> getStairsPath(int n){
		//Base case
		if(n == 0){
			ArrayList<String> baseList = new ArrayList<>();
			baseList.add("");
			return baseList;
		}else if(n < 0){
			ArrayList<String> baseList = new ArrayList<>();
			return baseList;
		}
		
		ArrayList<String> path1 = getStairsPath(n-1);
		ArrayList<String> path2 = getStairsPath(n-2);
		ArrayList<String> path3 = getStairsPath(n-3);
		ArrayList<String> paths = new ArrayList<>();
		for(String str : path1)
			paths.add("1" + str);
		for(String str : path2)
			paths.add("2" + str);
		for(String str : path3)
			paths.add("3" + str);
		return paths;

	}
	
	private static ArrayList<String> getStairsPathOptimized(int n){
		//Base case
		if(n == 0){
			ArrayList<String> baseList = new ArrayList<>();
			baseList.add("");
			return baseList;
		}
		ArrayList<String> paths = new ArrayList<>();
		if(n-1 >= 0){
			ArrayList<String> path1 = getStairsPathOptimized(n-1);
			for(String str : path1)
				paths.add("1" + str);
		}
		if(n-2 >= 0){
			ArrayList<String> path2 = getStairsPathOptimized(n-2);
			for(String str : path2)
				paths.add("2" + str);
		}
		if(n-3 >= 0){
			ArrayList<String> path3 = getStairsPathOptimized(n-3);
			for(String str : path3)
				paths.add("3" + str);
		}
		return paths;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Steps : ");
		int n = sc.nextInt();
		System.out.println(getStairsPathOptimized(n));
	}
}
