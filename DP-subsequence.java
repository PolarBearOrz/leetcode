// 区间型dp
// https://www.lintcode.com/submission/29224805/?action_type=1
public class Solution {
    /**
     * @param stones: 
     * @param K: 
     * @return: return a integer 
     */
    public int mergeStones(int[] stones, int K) {
        // write your code here
        int n = stones.length;
        if ((n - 1) % (K - 1) != 0) {
            return -1;
        }
        
        
        int[] sum = new int[n + 1];
        sum[0] = 0;
        for (int i = 1; i <= n; ++i) {
            sum[i] = sum[i - 1] + stones[i - 1];
        }
        
        int[][][] dp = new int[n][n][K + 1];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                for (int k = 0; k <= K; ++k) {
                    dp[i][j][k] = Integer.MAX_VALUE;
                }
            }
        }
        
        for (int i = 0; i < n; ++i) {
            dp[i][i][1] = 0;
        }
        
        for (int len = 2; len <= n; ++len) {
            for (int i = 0; i + len <= n; ++i) {
                int j = i + len - 1;
                for (int k = 2; k <= K; ++k) {
                                        //这是一个加速， 中间大部分都是没有解的。
                    for (int m = i; m < j; m += K - 1) {
                        dp[i][j][k] = Math.min(dp[i][j][k], dp[i][m][1] + dp[m + 1][j][k - 1]);
                    }
                }
                dp[i][j][1] = dp[i][j][K] + sum[j + 1] - sum[i];
            }
        }
        
        return dp[0][n - 1][1];
    }
}
