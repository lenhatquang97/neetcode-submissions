/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public boolean canAttendMeetings(List<Interval> intervals) {
        if (intervals.size() <= 1) return true;
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval s1, Interval s2) {
                if (s1.start < s2.start) return -1;
                if (s1.start > s2.start) return 1;
                return 0;
            }
        });
        for (int i = 0; i < intervals.size() - 1; i++) {
            int a = i;
            int b = i + 1;
            if (intervals.get(a).end > intervals.get(b).start) return false;
        }
        return true;
    }
}
