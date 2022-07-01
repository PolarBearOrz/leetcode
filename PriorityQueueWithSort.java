// leetcode 759
// https://leetcode.com/problems/employee-free-time/submissions/

/*
// Definition for an Interval.
class Interval {
    public int start;
    public int end;

    public Interval() {}

    public Interval(int _start, int _end) {
        start = _start;
        end = _end;
    }
};
*/

class Solution {
    class Boundary {
        int num, type;
        public Boundary(int num, int type) {
            this.num = num;
            this.type = type;
        }
    }
    
    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        PriorityQueue<Boundary> pq = new PriorityQueue<>(new Comparator<Boundary>() {
            public int compare(Boundary a, Boundary b) {
                if (a.num == b.num) {
                    return a.type - b.type;
                }
                return a.num - b.num;
            }
        });
        for (List<Interval> employee : schedule) {
            for (Interval interval : employee) {
                pq.add(new Boundary(interval.start, -1));
                pq.add(new Boundary(interval.end, 1));
            }
        }
        
        int cnt = 0;
        List<Interval> ans = new ArrayList<>();
        while (pq.size() > 1) {
            Boundary curr = pq.poll();
            Boundary next = pq.peek();
            cnt += curr.type;
            if (cnt == 0) {
                int left = curr.num;
                int right = next.num;
                ans.add(new Interval(left, right));
            }
        }
        
        return ans;
    }
}
