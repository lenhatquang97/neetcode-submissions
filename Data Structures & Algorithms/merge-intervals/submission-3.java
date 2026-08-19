class Solution {
    public boolean isOverlapping(int[] arr1, int[] arr2) {
        boolean sameVertex = arr1[1] == arr2[0];
        boolean inside = arr1[1] > arr2[0];
        return sameVertex || inside;
    }
    public int[][] convertTo2dArray(List<int[]> inp) {
        int[][] res = new int[inp.size()][2];
        for (int i = 0; i < inp.size(); i++) {
            res[i][0] = inp.get(i)[0];
            res[i][1] = inp.get(i)[1];
        }
        return res;
    }
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 1) return intervals;
        Comparator<int[]> comparator = new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return a[0] != b[0] ? Integer.compare(a[0], b[0]): Integer.compare(a[1], b[1]);
            }
        };
        Arrays.sort(intervals, comparator);
        List<int[]> res = new ArrayList<>();
        int[] newInterval = new int[2];
        newInterval[0] = -1;
        newInterval[1] = -1;
        int i = 0;
        while (i < intervals.length) {
            if (newInterval[0] != -1 && isOverlapping(newInterval, intervals[i])) {
                System.out.println("Compare with " + i);
                newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
                newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
                i++;
            } else if (newInterval[0] != -1) {
                res.add(new int[]{newInterval[0], newInterval[1]});
                newInterval[0] = -1;
                newInterval[1] = -1;
            } else if (i + 1 < intervals.length && isOverlapping(intervals[i], intervals[i+1])){
                System.out.println("Compare too " + i + " and " + (i + 1));
                newInterval[0] = Math.min(intervals[i][0], intervals[i+1][0]);
                newInterval[1] = Math.max(intervals[i][1], intervals[i+1][1]);
                i += 2;
            } else {
                res.add(intervals[i]);
                i++;
            }
        } 
        if (newInterval[0] != -1)
            res.add(newInterval);
        return convertTo2dArray(res);
    }
}
