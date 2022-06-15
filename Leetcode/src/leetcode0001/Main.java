/**
 * SOLVED : Solved
 * DATE : 2022.06.14
 * USER : KI-WOONG KIM
 * FROM : https://leetcode.com/problems/two-sum/
 * ALGORITHM : Hash
 * NOTE : 
 */

package leetcode0001;

import java.util.Arrays;
import java.util.HashMap;

class Solution {
    public int[] twoSum(int[] nums, int target) {
	int[] answer = { -1, -1 };
	HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
	for (int i = 0; i < nums.length; i++) {
	    if (hm.get(nums[i]) == null) {
		hm.put(nums[i], i);
	    } else if (nums[i] * 2 == target) {
		answer[0] = hm.get(nums[i]);
		answer[1] = i;
		return answer;
	    }
	}

	Integer idx;
	for (int i = 0; i < nums.length; i++) {
	    if ((idx = hm.get(target - nums[i])) != null) {
		if (idx != i) {
		    answer[0] = hm.get(nums[i]);
		    answer[1] = idx;
		    break;
		}
	    }
	}
	return answer;
    }
}

public class Main {
    public static void main(String[] args) {
	Solution sol = new Solution();
	int[] nums = { 3, 2, 4 };
	int target = 6;
	int[] answer = sol.twoSum(nums, target);
	System.out.println(Arrays.toString(answer));
    }
}
