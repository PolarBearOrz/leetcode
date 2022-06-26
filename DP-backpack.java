// 背包dp
// https://www.lintcode.com/submission/29153821/?action_type=1

public class Solution {
    /**
     * @param a: An integer array
     * @param target: An integer
     * @return: An integer
     */
    public int minAdjustmentCost(List<Integer> a, int target) {
        // state: the minium cost for adjust ith element to j while accords to the requirements
        int n = a.size();
        int[][] dp = new int[n][101];

        // init
        for (int j = 0; j <= 100; j++) {
            dp[0][j] = Math.abs(j - a.get(0));
        }

        // function
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= 100; j++) {
                int upper = j + target > 100 ? 100 : j + target;
                int lower = j - target < 0 ? 0 : j - target;
                int currMin = Integer.MAX_VALUE;
                for (int last = lower; last <= upper; last++) {
                    currMin = Math.min(currMin, dp[i - 1][last] + Math.abs(j - a.get(i)));
                }
                dp[i][j] = currMin;
            }
        }

        // ans
        int currMin = Integer.MAX_VALUE;
        for (int i = 0; i <= 100; i++) {
            currMin = Math.min(currMin, dp[n - 1][i]);
            // System.out.println(dp[n - 1][i]);
            // System.out.println(i);
            // System.out.println("---------");
        }

        return currMin;
    }
}
