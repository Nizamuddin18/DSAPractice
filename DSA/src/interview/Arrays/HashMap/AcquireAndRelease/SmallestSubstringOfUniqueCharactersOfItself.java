package interview.Arrays.HashMap.AcquireAndRelease;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class SmallestSubstringOfUniqueCharactersOfItself {
    public static void main(String[] args) {
        String str = "bbacacdcbbcaadcdca";
        int output = getSmallestSubstringOfAStringContainingAllUniqueCharactersOfItself(str);
        System.out.println("::::: Length of Smallest Substring Of A String Containing All Unique Characters Of Itself :::::");
        System.out.println("Input(str) : " + str);
        System.out.println("Output      : " + output);
    }

    private static int getSmallestSubstringOfAStringContainingAllUniqueCharactersOfItself(String str) {
        // create a HashSet of all the Characters of given String
        HashSet<Character> set = new HashSet<>();
        for (int i = 0; i < str.length(); i++) {
            set.add(str.charAt(i));
        }
        // create a Frequency Map of str
        Map<Character, Integer> map = new HashMap<>();
        int acq = 0;
        int rel = 0;
        int requirement = set.size();
        int ans = Integer.MAX_VALUE;
        while (true) {
            boolean isAccquired = false;
            boolean isReleased = false;

            //accquire
            while (acq < str.length() && map.size() < requirement) {
                char ch = str.charAt(acq);
                acq++;
                map.put(ch, map.getOrDefault(ch, 0) + 1); //  add to map
                isAccquired = true;
            }

            // release
            while (map.size() == requirement) {
                int temp = acq - rel;
                if (ans == Integer.MAX_VALUE || temp < ans)
                    ans = temp;
                char ch = str.charAt(rel);
                rel++;
                if (map.containsKey(ch)) {
                    map.replace(ch, map.get(ch) - 1);              //  remove from map
                    if (map.get(ch) == 0)
                        map.remove(ch);
                }
                isReleased = true;
            }

            if (isAccquired == false && isReleased == false)
                break;
        }
        return ans;
    }
}
