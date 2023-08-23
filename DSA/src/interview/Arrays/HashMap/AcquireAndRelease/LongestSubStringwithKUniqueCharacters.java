package interview.Arrays.HashMap.AcquireAndRelease;

import java.util.HashMap;
import java.util.Map;

public class LongestSubStringwithKUniqueCharacters {
    public static void main(String[] args) {
        String str = "aabcbcdbca";
        int k = 2;
        int ans2 = longestSubStringwithKUniqueCharacters2(str, k);
        System.out.println(" ::::: Longest SubString With K Unique Characters ::::: ");
        System.out.println("Input(String)  	: " + str);
        System.out.println("Input(K)  		: " + k);
        System.out.println("Output			: " + ans2);
    }

    private static int longestSubStringwithKUniqueCharacters2(String str, int k) {
        Map<Character, Integer> map = new HashMap<>();
        int acq = 0;
        int rel = 0;
        int length = Integer.MIN_VALUE;
        while (true) {
            boolean isAcquired = false;
            boolean isReleased = false;
            // acquire
            while (acq < str.length()) {
                char ch = str.charAt(acq);
                acq++;
                isAcquired = true;
                map.put(ch, map.getOrDefault(ch, 0) + 1);
                if (map.size() < k)
                    continue;
                else if (map.size() == k)
                    length = Math.max(length, (acq - rel));
                else
                    break;
            }
            // release
            while (rel < acq) {
                char ch = str.charAt(rel);
                rel++;
                isReleased = true;
                if (map.containsKey(ch))
                    map.replace(ch, map.get(ch) - 1);
                if (map.get(ch) == 0)
                    map.remove(ch);

                if (map.size() > k)
                    continue;
                else if (map.size() == k)
                    break;
            }

            if (isAcquired == false && isReleased == false)
                break;
        }
        return length;
    }
}
