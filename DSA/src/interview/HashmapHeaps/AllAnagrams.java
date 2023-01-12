package interview.HashmapHeaps;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AllAnagrams {
	public static void main(String args[]) {
		String s = "cbaebabacd";
		String p = "abc";
		List<Integer> res = findAnagrams(s , p);
		System.out.println(res);

	}

	private static List<Integer> findAnagrams(String s, String p) {
		List<Integer> ans = new ArrayList<>();
		Map<Character,Integer> map=new HashMap<>();
		int len=p.length();
		int start=0, end=len;

		//Edge cases
		if(s==null || s.length()==0 || p==null || len==0 || s.length()<len)
			return ans;

		//Putting pattern values in Map
		for(int i=0;i<len;i++) {
			int c= map.getOrDefault(p.charAt(i),0);
			map.put(p.charAt(i),c+1);
		}

		int count=map.size();

		//Constructing first sliding window
		for(int i=0;i<len;i++) {
			if(map.containsKey(s.charAt(i))) {
				map.put(s.charAt(i),map.get(s.charAt(i))-1);
				if(map.get(s.charAt(i))==0)
					count--;
			}
			if(count==0)
				ans.add(0);
		}

		while(end<s.length()) {
			//Removing char from start
			if(map.containsKey(s.charAt(start))) {
				map.put(s.charAt(start),map.get(s.charAt(start))+1);
				if(map.get(s.charAt(start))==1)
					count++;
			}
			//Adding char from end
			if(map.containsKey(s.charAt(end))) {
				map.put(s.charAt(end),map.get(s.charAt(end))-1);
				if(map.get(s.charAt(end))==0)
					count--;
			}
			start++;
			end++;
			if(count==0)
				ans.add(start);
		}
		return ans;
	}
}
