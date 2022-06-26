// 二维dp
// 矩阵里正方形

public class Solution {
    /**
     * @param matrix: a matrix of 0 an 1
     * @return: an integer
     */
    public int maxSquare2(int[][] matrix) {
        // write your code here
        int m = matrix.length;
        int n = matrix[0].length;

        //state
        int[][] dp = new int[m][n];

        // init
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 1) {
                    dp[i][j] = 1;
                }
            }
        }

        // function
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 1 && dp[i - 1][j - 1] != 0) {
                    int len = dp[i - 1][j - 1];
                    for (; len > 0; len--) {
                        if (matrix[i - len][j] != 0 || matrix[i][j - len] != 0) {
                            break;
                        }
                    }
                    if (len == 0) {
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                    }
                }
            }
        }

        // ans
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                ans = Math.max(ans, dp[i][j]);
            }
        }

        return ans * ans;
    }
}
