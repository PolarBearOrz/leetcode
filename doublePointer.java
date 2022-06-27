// leetcode 209
// https://leetcode.com/problems/minimum-size-subarray-sum/

public class Solution {
    /**
     * @param nums: an array of integers
     * @param s: An integer
     * @return: an integer representing the minimum size of subarray
     */
    public int minimumSize(int[] nums, int s) {
        int ans = Integer.MAX_VALUE;
        int left = 0, right = 0;
        int sum = 0;
        while (right < nums.length) {
            sum += nums[right++];
            while (sum >= s) {
                ans = Math.min(ans, right - left);
                sum -= nums[left++];
            }
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}
