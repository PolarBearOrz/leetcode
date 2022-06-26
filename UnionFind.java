// lintcode 1463
// https://www.lintcode.com/problem/1463/

public class Solution {
    class UnionFind {
        HashMap<String, String> fathers = new HashMap<>();
        int numOfSet = 0;
        HashMap<String, Integer> rootToNums = new HashMap<>();
        
        private void add(String x) {
            if (fathers.containsKey(x)) {
                return;
            }
            fathers.put(x, null);
            rootToNums.put(x, 1);
            numOfSet++;
        }
        
        private void merge(String x, String y) {
            String rootX = find(x);
            String rootY = find(y);
            if (!rootX.equals(rootY)) {
                fathers.put(rootX, rootY);
                numOfSet--;
                rootToNums.put(rootY, rootToNums.get(rootX) + rootToNums.get(rootY));
            }
        }
        
        private String find(String x) {
            String root = x;
            while (fathers.get(root) != null) {
                root = fathers.get(root);
            }
            while (!x.equals(root)) {
                String currRoot = fathers.get(x);
                fathers.put(x, root);
                x = currRoot;
            }
            return root;
        }
        
        private int getNumOfSet() {
            return numOfSet;
        }
        
        private int getNumInASet(String x) {
            return rootToNums.get(find(x));
        }
        
        private boolean isConnected(String x, String y) {
            return find(x).equals(find(y));
        }
    }

    /**
     * @param words1: the words in paper1
     * @param words2: the words in paper2
     * @param pairs: the similar words pair
     * @return: the similarity of the two papers
     */
    public float getSimilarity(List<String> words1, List<String> words2, List<List<String>> pairs) {
        // Write your code here
        UnionFind uf = new UnionFind();
        for (String w : words1) {
            uf.add(w);
        }
        for (String w : words2) {
            uf.add(w);
        }
        for (List<String> p : pairs) {
            uf.add(p.get(0));
            uf.add(p.get(1));
            uf.merge(p.get(0), p.get(1));
        }

        float lcs = getLCS(words1, words2, uf);
        float length = words1.size() + words2.size();
        System.out.println(lcs);
        System.out.println(length);
        return lcs * 2 / length;
    }

    private float getLCS(List<String> words1, List<String> words2, UnionFind uf) {
        // state
        int n = words1.size(), m = words2.size();
        int[][] dp = new int[n + 1][m + 1];
        
        // init
        // dp[0][0] = dp[0][1] = dp[1][0] = 0;

        // function
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (uf.isConnected(words1.get(i - 1), words2.get(j - 1))) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[n][m];
    }
}
