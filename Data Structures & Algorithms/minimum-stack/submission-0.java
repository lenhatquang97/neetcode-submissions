public class Pair {
    int a;
    int minVal;
    public Pair(int a, int b) {
        this.a = a;
        this.minVal = b;
    }
}

class MinStack {
    public ArrayList<Pair> st;

    public MinStack() {
        st = new ArrayList<>();
    }
    
    public void push(int val) {
        if (st.size() == 0) {
            st.add(new Pair(val, val));
        } else {
            int lastMinValue = st.get(st.size() - 1).minVal;
            st.add(new Pair(val, Math.min(val, lastMinValue)));
        }
    }
    
    public void pop() {
        st.remove(st.size() - 1);
    }
    
    public int top() {
        return st.get(st.size() - 1).a;
    }
    
    public int getMin() {
        return st.get(st.size() - 1).minVal;
    }
}
