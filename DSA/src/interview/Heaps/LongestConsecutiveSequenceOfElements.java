package interview.Heaps;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class LongestConsecutiveSequenceOfElements {
	public static int longestConsecutive(int[] nums) {
		Set<Integer> set = new HashSet<Integer>();
		for (int num : nums)
			set.add(num);
		System.out.println(set);
		int longestSeq = 0;
		for(int num : nums){
			if(!set.contains(num-1)){
				int currNum = num;
				int currSeq = 1;
				
				while(set.contains(currNum+1)){
					currNum += 1;
					longestSeq += 1;
				}
				longestSeq = Math.max(currSeq, longestSeq);
			}
		}
		return longestSeq;
	}
	
	public static int longestConsecutive1(int[] nums) {
		
		HashMap<Integer,Boolean> map = new HashMap<>();
		for (int key : nums)
			map.put(key, true);

		for(int key : nums){
			if(map.containsKey(key-1) == true)
				map.put(key, false);
		}		
		
		int maxLength = 0;
		int start = 0;
		for(int key : nums){
			if(map.get(key) == true){
				//key is starting point;
				int len = 1;
				int stPoint = key;
				
				while(map.containsKey(key+1) == true){
					len++;
					key++;
				}
				if(maxLength < len){
					maxLength = len;
					start = stPoint;
				}
				map.put(key, false);
			}
		}
		
		for(int i = 0 ; i < maxLength ; i++)
			System.out.println(start++);
		return maxLength;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		/*int n = sc.nextInt();
		int arr[] = new int[n];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}*/
		int arr[] = {0,3,7,2,5,8,4,6,0,1};
		int l = longestConsecutive1(arr);
		System.out.println("Longest Length : " + l);
		/*0,3,7,2,5,8,4,6,0,1*/
	}

}
