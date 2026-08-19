class Solution {
    public int[][] convertTo2dArray(List<int[]> inp) {
        int[][] res = new int[inp.size()][2];
        for (int i = 0; i < inp.size(); i++) {
            res[i][0] = inp.get(i)[0];
            res[i][1] = inp.get(i)[1];
        }
        return res;
    }
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> res = new ArrayList<>();
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        for (int i = 0; i < intervals.length; i++) {
            if (newInterval[1] < intervals[i][0]) {
                res.add(newInterval);
                for (int j = i; j < intervals.length; j++) {
                    res.add(intervals[j]);
                }
                return convertTo2dArray(res);
            } else if (newInterval[0] > intervals[i][1]) {
                res.add(intervals[i]);
            } else {
                newInterval = new int[]{
                    Math.min(newInterval[0], intervals[i][0]),
                    Math.max(newInterval[1], intervals[i][1])
                };
            }
        }
        res.add(newInterval);
        return convertTo2dArray(res);
    }
}
