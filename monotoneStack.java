 // lintcode 1852
 // https://www.lintcode.com/problem/1852/

public class Solution {
    /**
     * @param prices: a list of integer
     * @return: return the actual prices
     */
    public int[] finalDiscountedPrice(int[] prices) {
        int[] ans = Arrays.copyOf(prices, prices.length);
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < prices.length; i++) {
            while (!stack.isEmpty() && prices[i] <= prices[stack.peek()]) {
                ans[stack.peek()] = prices[stack.peek()] - prices[i];
                stack.pop();
            }
            stack.push(i);
        }

        return ans;
    }
}
