package interview.Recursion;

import java.util.Scanner;

public class PrintStairsPath {
	// Optimized
	public static void printStairPathsOptimized(int n, String path) {
		if (n == 0) {
			System.out.println(path);
			return;
		}
		for (int jump = 1; jump <= 3 && n - jump >= 0; jump++) {
			printStairPathsOptimized(n - jump, path + jump);
		}
	}

	public static void printStairPaths(int n, String path) {
		if (n == 0) {
			System.out.println(path);
			return;
		}
		if (n - 1 >= 0)
			printStairPaths(n - 1, path + 1);
		if (n - 2 >= 0)
			printStairPaths(n - 2, path + 2);
		if (n - 3 >= 0)
			printStairPaths(n - 3, path + 3);
	}

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Stairs length : ");
		int n = sc.nextInt();
		printStairPathsOptimized(n, "");
	}

}
