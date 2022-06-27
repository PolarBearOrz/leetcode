// lintcode 285
// https://www.lintcode.com/problem/285/

public class Solution {
    /**
     * @param arr: the height of all buildings
     * @return: how many buildings can he see at the location of each building
     */
    public int[] tallBuilding(int[] arr) {
        int[] ans = new int[arr.length];
        Arrays.fill(ans, 1);
        getNum(arr, 0, arr.length, 1, ans);
        getNum(arr, arr.length - 1, -1, -1, ans);

        return ans;
    }

    public void getNum(int[] arr, int start, int end, int step, int[] ans) {
        Stack<Integer> stack = new Stack<>();
        for (int i = start; i != end; i += step) {
            ans[i] += stack.size();
            while (!stack.isEmpty() && arr[i] >= arr[stack.peek()]) {
                stack.pop();
            }
            stack.push(i);
        }
    }
}
