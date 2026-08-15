class Pair {
    public int value;
    public int index;
    public Pair (int v, int i) {
        value = v;
        index = i;
    }
}

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] res = new int[temperatures.length];

        Stack<Pair> st = new Stack<>();
        st.add(new Pair(temperatures[0], 0));
        for (int i = 1; i < temperatures.length; i++) {
            while (!st.empty() && st.peek().value < temperatures[i]) {
                Pair popVal = st.pop();
                res[popVal.index] = i - popVal.index;
            }
            st.push(new Pair(temperatures[i], i));
        }

        while (!st.empty()) {
            Pair popVal = st.pop();
            res[popVal.index] = 0;
        }
        return res;
    }
}
