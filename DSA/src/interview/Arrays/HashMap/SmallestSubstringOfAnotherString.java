package interview.Arrays.HashMap;

import java.util.HashMap;
import java.util.Map;

public class SmallestSubstringOfAnotherString {
    public static void main(String[] args) {
        String str1 = "timetopractice";
        String str2 = "toc";
        String output = getSmallestSubstringOfAStringContainingAllCharactersOfAnotherString(str1, str2);
        System.out.println("::::: Smallest Substring Of A String Containing All Characters Of Another String :::::");
        System.out.println("Input(str1) : " + str1);
        System.out.println("Input(str2) : " + str2);
        System.out.println("Output      : " + output);
    }

    private static String getSmallestSubstringOfAStringContainingAllCharactersOfAnotherString(String str1, String str2) {
        // create a Frequency Map of str2
        Map<Character, Integer> fmap = new HashMap<>();
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < str2.length(); i++) {
            char ch = str2.charAt(i);
            fmap.put(ch, fmap.getOrDefault(ch, 0) + 1);
        }
        int acq = 0;
        int rel = 0;
        int count = 0;
        int requirement = str2.length();
        String ans = "";
        while (true) {
            boolean isAccquired = false;
            boolean isRreleased = false;

            //accquire
            while (acq < str1.length() && count < requirement) {
                char ch = str1.charAt(acq);
                acq++;
                map.put(ch, map.getOrDefault(ch, 0) + 1); //  add to map
                if (map.get(ch) <= fmap.getOrDefault(ch, 0))
                    count++;

                isAccquired = true;
            }

            // release
            while (count == requirement) {
                String tempAns = str1.substring(rel, acq);
                if (ans.length() == 0 || tempAns.length() < ans.length())
                    ans = tempAns;
                char ch = str1.charAt(rel);
                rel++;
                if (map.containsKey(ch)) {
                    map.replace(ch, map.get(ch) - 1);              //  remove from map
                    if (map.get(ch) == 0)
                        map.remove(ch);

                    if (map.getOrDefault(ch, 0) < fmap.getOrDefault(ch, 0))
                        count--;

                }
                isRreleased = true;
            }

            if (isAccquired == false && isRreleased == false)
                break;
        }
        return ans;
    }
}
