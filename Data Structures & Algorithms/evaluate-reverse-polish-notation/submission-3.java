class Solution {
    public int convertNumber(String str) {
        int num = 0;
        for (int i = str.length() - 1; i >= 0; i--) {
            if (str.charAt(i) == '-') {
                num = -num;
            } else {
                num += (str.charAt(i) - '0') * Math.pow(10, (str.length() - 1) - i);
            }
        }
        return num;
    }

    public int eval(int a, int b, String ops) {
        if (ops.equals("+")) {
            return a + b;
        } else if (ops.equals("-")) {
            return a - b;
        } else if (ops.equals("*")) {
            return a * b;
        }
        return (int) a / b;
    }
    public boolean isOperator(String str) {
        if (str.length() == 0 && str.length() > 1) return false;
        return str.equals("+") || str.equals("-") || str.equals("*") || str.equals("/");
    }
    public int evalRPN(String[] tokens) {
        Stack<String> st = new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
            if (!isOperator(tokens[i])) {
                st.add(tokens[i]);
            } else {
                int rightNum = convertNumber(st.pop());
                int leftNum = convertNumber(st.pop());
                st.push(String.valueOf(eval(leftNum, rightNum, tokens[i])));
            }
        }
        return convertNumber(st.pop());
    }
}
