// leetcode 862
// https://leetcode.com/problems/shortest-subarray-with-sum-at-least-k/

class Solution {
    public int shortestSubarray(int[] nums, int k) {
        int n = nums.length;
        Deque<Integer> deque = new ArrayDeque<>();
        long[] prefixSum = new long[n + 1];
        for (int i = 0; i < n; i++) {
            prefixSum[i + 1] = prefixSum[i] + nums[i];
        }
        
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < n + 1; i++) {
            while (!deque.isEmpty() && prefixSum[i] - prefixSum[deque.peekFirst()] >= k) {
                ans = Math.min(ans, i - deque.pollFirst());
            }
            while (!deque.isEmpty() && prefixSum[i] <= prefixSum[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.addLast(i);
        }
        
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}
