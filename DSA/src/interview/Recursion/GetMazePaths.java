package interview.Recursion;

import java.util.ArrayList;
import java.util.Scanner;

public class GetMazePaths {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Destination Row");
		int row = sc.nextInt();
		System.out.println("Enter Destination Column");
		int column = sc.nextInt();
		ArrayList<String> mazePath = getMazePath(1,1,row,column);
		System.out.println(mazePath);
	}

	private static ArrayList<String> getMazePath(int sr, int sc, int drow, int dcolumn) {
		if(sr == drow && sc == dcolumn){
			ArrayList<String> baseCase = new ArrayList<>();
			baseCase.add("");
			return baseCase;

		}
		ArrayList<String> hPath = new ArrayList<>();
		ArrayList<String> vPath = new ArrayList<>();
		
		if(sc < dcolumn)
			hPath = getMazePath(sr,sc+1,drow,dcolumn);
		if(sr < drow)
			vPath = getMazePath(sr+1,sc,drow,dcolumn);
		 
		ArrayList<String> paths = new ArrayList<>();
		
		for(String path : hPath)
			paths.add('h' + path);
		for(String path : vPath)
			paths.add('v' + path);

		return paths;
	}

}
