// leetcode 253
// https://leetcode.com/problems/meeting-rooms-ii/

class Solution {
    class Boundary {
        int num, type;
        public Boundary(int num, int type) {
            this.num = num;
            this.type = type;
        }
    }
    
    public int minMeetingRooms(int[][] intervals) {
        List<Boundary> dots = new ArrayList<>();
        for (int[] interval: intervals) {
            dots.add(new Boundary(interval[0], 1));
            dots.add(new Boundary(interval[1], -1));
        }
        Collections.sort(dots, new Comparator<Boundary>() {
            public int compare(Boundary a, Boundary b) {
                if (a.num == b.num) {
                    return a.type - b.type;
                }
                return a.num - b.num;
            }
        });
        int cnt = 0, ans = 0;
        for (Boundary curr : dots) {
            cnt += curr.type;
            ans = Math.max(ans, cnt);
        }
        
        return ans;
    }
}
