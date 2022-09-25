// https://leetcode.com/problems/meeting-rooms-ii/discuss/203658/HashMapTreeMap-resolves-Scheduling-Problem
class Solution {   
    public int minMeetingRooms(int[][] intervals) {
        Map<Integer, Integer> timeToCnt = new TreeMap<>();
        for (int[] time: intervals) {
            timeToCnt.put(time[0], timeToCnt.getOrDefault(time[0], 0) + 1);
            timeToCnt.put(time[1], timeToCnt.getOrDefault(time[1], 0) - 1);
        }
        int room = 0, max = 0;
        for (int cnt: timeToCnt.values()) {
            room += cnt;
            max = Math.max(room, max);
        }
        return max;
    }
}
