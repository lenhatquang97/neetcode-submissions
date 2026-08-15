class Solution {
    public ArrayList<String> res = new ArrayList<>();
    public Stack<Character> st = new Stack<>();
    public void backtrack(String str, char ch, int left, int right, int n) {
        if ((left + right > 2*n) || (left + right < 2*n && right > left)) return;
        if (left + right == 2*n && left == right && st.empty()) {
            res.add(str);
            return;
        }

        st.push('(');
        backtrack(str + '(', '(', left + 1, right, n);
        if (!st.empty()) {st.pop();}
        if (!st.empty()) {st.pop();}
        backtrack(str + ')', ')', left, right + 1, n);
    }
    public List<String> generateParenthesis(int n) {
        if (n == 1) return Arrays.asList("()");
        
        int open = 0;
        int close = 0;
        backtrack("", ';', open, close, n);
        return res;
    }
}
