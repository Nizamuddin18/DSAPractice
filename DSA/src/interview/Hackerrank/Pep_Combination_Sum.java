package interview.Hackerrank;
import java.util.*;

public class Pep_Combination_Sum {
	public static List<List<Integer>> combinationSum(int[] candidates, int target) {
		ArrayList<Integer> arr = new ArrayList<>();
		for(int i = 0 ; i < candidates.length ; i++){
			int val = candidates[i];
			arr.add(val);
		}
		List<List<Integer> > ans = new ArrayList<>();
		List<Integer> temp = new ArrayList<>();
		Set<Integer> set = new HashSet<>(arr);
		arr.clear();
		arr.addAll(set);
		Collections.sort(arr);
		combinationSumHelper(ans, arr, target, 0, temp);
		return ans;
	}

	private static void combinationSumHelper(List<List<Integer>> ans, ArrayList<Integer> arr, int sum, int indx,List<Integer> temp) {
		if (sum == 0) {
			ans.add(new ArrayList<>(temp));
			return;
		}
		for (int i = indx; i < arr.size(); i++) {
			if ((sum - arr.get(i)) >= 0) {
				temp.add(arr.get(i));
				combinationSumHelper(ans, arr, sum - arr.get(i), i, temp);
				temp.remove(arr.get(i));
			}
		}
	}
	
	private static void combinationSumHelper1(List<List<Integer>> ans, ArrayList<Integer> arr, int tar, int ssf,int indx, List<Integer> temp) {
		if (ssf == tar) {
			ans.add(new ArrayList<>(temp));
			return;
		}
		for (int i = indx; i < arr.size(); i++) {
			if (arr.get(i) + ssf <= tar) {
				temp.add(arr.get(i));
				combinationSumHelper1(ans, arr, tar, ssf + arr.get(i), i, temp);
				temp.remove(arr.get(i));
			}
		}
	}
	
	public static List<List<Integer>> combinationSum1(int[] candidates, int target) {
		ArrayList<Integer> list = new ArrayList<>();
		for (int i = 0; i < candidates.length; i++) {
			int val = candidates[i];
			list.add(val);
		}
		List<List<Integer>> ans = new ArrayList<>();
		List<Integer> temp = new ArrayList<>();
		combinationSumHelper1(ans, list, target, 0, 0, temp);
		return ans;
	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = scn.nextInt();
		}
		int target = scn.nextInt();
		List<List<Integer>> res = combinationSum1(arr, target);
		System.out.println(res);
	}
}
