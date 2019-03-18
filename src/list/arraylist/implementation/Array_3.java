package list.arraylist.implementation;
// 배열의 특정 숫자끼리 더해서 특정 숫자가 나오는 인덱스찾

import java.util.HashMap;

// 배열로 찾는데 O(n^2) 이 걸린다.
//
//class Solution{	
//public int[] twoSum(int[] nums, int target) {
//	for(int i=0; i<nums.length; i++) {
//		for(int j=i+1; j<nums.length; j++) {
//			if(target == nums[i] + nums[j]) {
//				return new int[] {i, j};
//			}
//		}
//	}
//	throw new IllegalArgumentException("No two sum solution");
//}
//}

// HashTable을 이용한 방법 1 / HashTable을 만들어 놓고 검색. 
//class Solution {
//	public int[] twoSum(int[] nums, int target) {
//		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
//		for (int i = 0; i < nums.length; i++)
//			map.put(nums[i], i);
//		for (int i1 = 0; i1 < nums.length; i1++) {
//			Integer i2 = map.get(target - nums[i1]);
//			if (i2 != null && i1 != 12)
//				return new int[] { i1, i2 };
//		}
//		throw new IllegalArgumentException("No two sum solution");
//	}
//}

// HashTable을 이용한 방법 2 / HashTable을 만들면서 검색. 
class Solution {
	public int[] twoSum(int[] nums, int target) {
		HashMap<Integer, Integer> maps = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++) {
			if (maps.containsKey(target - nums[i]))
				return new int[] { maps.get(target - nums[i]), i };
			maps.put(nums[i], i);
		}
		throw new IllegalArgumentException("No two sum solution");
	}
}

public class Array_3 {
	public static void main(String[] args) {
		int[] nums = { 6, 4, 3, 8, 7, 5, 2 };
		Solution sol = new Solution();
		int[] result = sol.twoSum(nums, 5);
		System.out.println(result[0] + ", " + result[1]);
	}

}
