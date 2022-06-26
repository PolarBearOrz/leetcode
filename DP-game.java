// lintcode 394
// https://www.lintcode.com/submission/29262469/?action_type=1

public class Solution {
    /**
     * @param values: a vector of integers
     * @return: a boolean which equals to true if the first player will win
     */
    public boolean firstWillWin(int[] values) {
        // write your code here
        int len = values.length;
        if (len == 0) {
            return false;
        }
        if (len == 1) {
            return true;
        }

        // state
        int[][] dp = new int[len][len];

        // init
        for (int i = 0; i < len; i++) {
            dp[i][i] = values[i];
        }

        // function
        for (int step = 2; step <= len; step++) {
            for (int i = 0; i + step - 1 < len; i++) {
                int j = i + step - 1;
                dp[i][j] = Math.max(values[i] - dp[i + 1][j], values[j] - dp[i][j - 1]);
            }
        }

        return dp[0][len - 1] > 0;
    }
}
