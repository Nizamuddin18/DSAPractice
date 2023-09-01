package interview.Recursion;

import java.util.ArrayList;
import java.util.Scanner;

public class GetMazePaths {
	private static ArrayList<String> getMazePaths(int drow, int dcol, int srow, int scol) {
		if (srow == drow && scol == dcol) {
			ArrayList<String> base = new ArrayList<>();
			base.add("");
			return base;
		}
		ArrayList<String> paths = new ArrayList<>();

		if (scol < dcol) {
			ArrayList<String> hpath = getMazePaths(drow, dcol, srow, scol + 1);
			for (String hp : hpath)
				paths.add("h" + hp);
		}
		if (srow < drow) {
			ArrayList<String> vpath = getMazePaths(drow, dcol, srow + 1, scol);
			for (String vp : vpath)
				paths.add("v" + vp);
		}
		return paths;
	}

	

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		/*
		 * System.out.println("Enter source row : "); 
		 * int sr = scn.nextInt();
		 * System.out.println("Enter source col : "); 
		 * int sc = scn.nextInt();*/

		System.out.println("Enter dest row : ");
		int dr = scn.nextInt();
		System.out.println("Enter dest col : ");
		int dc = scn.nextInt();
		System.out.println(getMazePaths(dr-1 , dc-1 , 0 , 0));
	}

}
