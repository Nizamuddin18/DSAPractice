package interview.Graph;

import java.util.ArrayDeque;
import java.util.Queue;

public class RottingOranges {
	static class Pair {
		int time;
		int x, y;

		Pair(int time, int x, int y) {
			this.time = time;
			this.x = x;
			this.y = y;
		}
	}

	static int xdir[] = { -1, 0, 1, 0 };
	static int ydir[] = { 0, -1, 0, 1 };
	private static int rottenOranges(int[][] arr) {
		Queue<Pair> queue = new ArrayDeque<>();
		int noOfOranges = 0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				if (arr[i][j] == 2) {
					queue.add(new Pair(1, i, j));
				} else if (arr[i][j] == 1) {
					noOfOranges++;
				}
			}
		}

		int minutes = 0;
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				Pair rem = queue.remove();
				int currRow = rem.x;
				int currCol = rem.y;

				for (int dir = 0; dir < xdir.length; dir++) {
					int r = currRow + xdir[dir];
					int c = currCol + ydir[dir];
					if (r >= 0 && r < arr.length && c >= 0 && c < arr[0].length && arr[r][c] == 1) {
						noOfOranges--;
						arr[r][c] = 2;
						queue.add(new Pair(rem.time + 1, r, c));
					}
				}
			}
			if (queue.size() > 0)
				minutes++;
		}
		return noOfOranges == 0 ? minutes : -1;
	}

	public static void main(String[] args) {
		int arr[][] = { { 2,1,1 }, { 1,1,0 }, {0,1,1 } };
		int time = rottenOranges(arr);
		System.out.println(time);
	}
}
