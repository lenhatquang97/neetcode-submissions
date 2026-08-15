class Solution {
    public boolean isValid(String s) {
        if (s.length() == 0) return true;
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[') {
                st.push(s.charAt(i));
            } else if (s.charAt(i) == ')' || s.charAt(i) == '}' || s.charAt(i) == ']') {
                if (st.empty()) return false;
                Character c = st.pop();
                boolean isA = c == '(' && s.charAt(i) == ')';
                boolean isB = c == '{' && s.charAt(i) == '}';
                boolean isC = c == '[' && s.charAt(i) == ']';
                if (!(isA || isB || isC)) return false;
            }
        }
        return st.empty();
    }
}
