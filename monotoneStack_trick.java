// https://leetcode.com/problems/largest-rectangle-in-histogram/
// lc 84
class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int n = heights.length;
        int ans = 0;
        for (int i = 0; i <= n; i++) {
            // set the rightside bar heights[n] = -1 to pop the remaining elements
            int value = i == n ? -1 : heights[i];
            while (!stack.isEmpty() && heights[stack.peek()] > value) {
                int top = stack.pop();
                int h = heights[top];
                // set the leftside bar heights[-1] = -1 to get the width 
                int left = stack.isEmpty() ? -1 : stack.peek();
                int w = i - left - 1;
                ans = Math.max(ans, w * h);
            }
            stack.add(i);
        }
        
        return ans;
    }
}
