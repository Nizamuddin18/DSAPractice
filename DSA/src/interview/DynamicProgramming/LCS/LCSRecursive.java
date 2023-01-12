package interview.DynamicProgramming.LCS;

import java.util.*;

public class LCSRecursive {

	public int getLCS(String x, String y, int m, int n) {
		if (m == 0 || n == 0)
			return 0;
		if (x.charAt(m - 1) == y.charAt(n - 1)) {
			return 1 + getLCS(x, y, m - 1, n - 1);
		} else {
			return (Math.max(getLCS(x, y, m - 1, n), getLCS(x, y, m, n - 1)));
		}
	}
}
