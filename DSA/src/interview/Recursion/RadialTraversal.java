package interview.Recursion;

public class RadialTraversal {
	public static void display(int arr[][]){
		for(int i = 0 ; i < arr.length ; i++){
			for(int j = 0 ; j < arr[0].length ; j++){
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	public static void traversal(int arr[][] , int row , int col){
		int rdir[] = {-1 , 0 , 1 , 0};
		int cdir[] = {0 , 1 , 0 , -1};
		String dirs[] = {"top" , "left" , "down" , "right"};
		int n = arr.length;
		int m = arr[0].length;
		
		int radius = Math.max(n, m);
		for(int r = 1 ; r <= radius ; r++){
			for(int dir = 0 ; dir < rdir.length ; dir++){
				int newrow = row + (r * rdir[dir]);
				int newcol = col + (r * cdir[dir]);
				if(newrow >= 0 && newrow < n && newcol >= 0 && newcol < m)
					System.out.println("Radius : " + r + " Direction : " + dirs[dir] + " Row : " + newrow + " Col : " + newcol);
			}
		}
	}
	
	public static void main(String[] args) {
		int arr[][] = new int[8][8];
		//display(arr);
		traversal(arr, 3, 3);
	}

}
