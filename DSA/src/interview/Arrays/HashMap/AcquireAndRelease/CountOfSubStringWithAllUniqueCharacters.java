package interview.Arrays.HashMap.AcquireAndRelease;

import java.util.HashMap;
import java.util.Map;

public class CountOfSubStringWithAllUniqueCharacters {

	public static void main(String[] args) {
		String str = "aabc";
		System.out.println(" :::::Count Of SubString With All Unique Characters ::::: ");
		int output = getCountOfSubStringWithAllUniqueCharacters(str);
		System.out.println("Input   : " + str);
		System.out.println("Output  : " + output);
	}

	private static int getCountOfSubStringWithAllUniqueCharacters(String str) {
		Map<Character, Integer> map = new HashMap<>();
		int count = 0;
		int acq = 0;
		int rel = 0;
		while (true) {
			boolean isAccquired = false;
			boolean isReleased = false;

			//accquire
			while (acq < str.length()) {
				isAccquired = true;
				char ch = str.charAt(acq);
				acq++;
				map.put(ch, map.getOrDefault(ch, 0) + 1); //  add to map
				if (map.get(ch) == 2)
					break;
				else
					count += (acq - rel);
			}

			// release
			while (rel < acq) {
				isReleased = true;
				char ch = str.charAt(rel);
				rel++;
				if (map.containsKey(ch)) {
					map.replace(ch, map.get(ch) - 1);              //  remove from map
					if (map.get(ch) == 1){
						count += (acq - rel);
						break;
					}

				}
			}

			if (isAccquired == false && isReleased == false)
				break;
		}
		return count;
	}
}
