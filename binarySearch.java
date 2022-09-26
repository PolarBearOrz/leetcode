// (right, left)
// right是满足条件的最后一个
// left是满足条件的第一个
public class Solution {
    /**
     * @param L: Given n pieces of wood with length L[i]
     * @param k: An integer
     * @return: The maximum length of the small pieces
     */
    public int woodCut(int[] L, int k) {
        // 从小切到大，找到最后一个len，满足比他大的都要小于k段
        int left = 1, right = 0;
        int sum = 0;
        for (int l : L) {
            right = Math.max(right, l);
            sum += l;
        }

        while (left <= right) {
            int mid = (right - left) / 2 + left;
            if (numCut(mid, L) < k) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return right;
    }

    private int numCut(int len, int[] L) {
        int cnt = 0;
        for (int l : L) {
            cnt += l / len;
        }

        return cnt;
    }
}
