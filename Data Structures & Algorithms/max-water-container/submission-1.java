class Solution {
    public int maxArea(int[] heights) {
        int area = 0;
        //max(min(h[i], h[j])) * max((j - i))
        int i = 0;
        int j = heights.length - 1;
        while (i < j) {
            area = Math.max(area, (j - i) * Math.min(heights[i], heights[j]));
            if (heights[i] > heights[j]) {
                j--;
            } else {
                i++;
            }
        }
        return area;
    }
}
