  private float getLCS(List<String> words1, List<String> words2, UnionFind uf) {
      // state
      int n = words1.size(), m = words2.size();
      int[][] dp = new int[n + 1][m + 1];

      // init
      // dp[0][0] = dp[0][1] = dp[1][0] = 0;

      // function
      for (int i = 1; i <= n; i++) {
          for (int j = 1; j <= m; j++) {
              // can be changed to 
              // if (words1.get(i - 1) == words2.get(j - 1)) 
              if (uf.isConnected(words1.get(i - 1), words2.get(j - 1))) {
                  dp[i][j] = dp[i - 1][j - 1] + 1;
              } else {
                  dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
              }
          }
      }

      return dp[n][m];
  }
