public class Solution {
    /**
     * @param a: A list of integers
     * @return: An integer
     */
    public int jump(int[] a) {
        // state
        int len = a.length;
        int[] dp = new int[len];

        // init
        for (int i = 0; i < len; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        dp[0] = 0;

        // function
        for (int i = 1; i < len; i++) {
            for (int prev = 0; prev < i; prev++) {
                if (dp[prev] != Integer.MAX_VALUE && a[prev] >= (i - prev)) {
                    dp[i] = Math.min(dp[i], dp[prev] + 1);
                    // System.out.println(i);
                    // System.out.println(dp[i]);
                    // System.out.println("-------");
                }
            }
        }

        return dp[len - 1];
    }
}
