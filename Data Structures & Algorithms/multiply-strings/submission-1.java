class Solution {
    public String sumOfTables(int[][] tables) {
        int[] finalAns = new int[tables[0].length];
        int remember = 0;
        for (int j = tables[0].length - 1; j >= 0; j--) {
            int digit = 0;
            for (int i = 0; i < tables.length; i++) {
                digit += tables[i][j];
            }
            int tmp = digit;
            digit = (tmp + remember) % 10;
            remember = (tmp + remember) / 10;
            finalAns[j] = digit;
        }
        if (remember != 0) {
            finalAns[0] = remember;
        }

        int firstIndexWithoutZero = -1;
        for (int i = 0; i < finalAns.length; i++) {
            if (finalAns[i] != 0) {
                firstIndexWithoutZero = i;
                break;
            }
        }

        if (firstIndexWithoutZero == -1) return "0";

        StringBuilder res = new StringBuilder();
        for (int i = firstIndexWithoutZero; i < finalAns.length; i++) {
            res.append((char)(finalAns[i] + '0'));        
        }
        return res.toString();
    }
    public String multiplyWithSmallNumber(String bigNum, String smallNum) {
        int maxNumbers = bigNum.length() + smallNum.length();
        int[][] tables = new int[smallNum.length()][maxNumbers];

        for (int i = smallNum.length() - 1; i >= 0; i--) {
            int pointer = maxNumbers - 1 - (smallNum.length() - 1 - i);
            int remember = 0;
            for (int j = bigNum.length() - 1; j >= 0; j--) {
                int a = bigNum.charAt(j) - '0';
                int b = smallNum.charAt(i) - '0';
                int digit = (a * b + remember) % 10;
                remember = (a * b + remember) / 10;
                tables[smallNum.length() - 1 - i][pointer] = digit;
                pointer--;
            }
            if (remember != 0) {
                tables[smallNum.length() - 1 - i][pointer] = remember;
            }
        }
        return sumOfTables(tables);
    }
    public String multiply(String num1, String num2) {
        String s1 = num1.length() > num2.length() ? num1 : num2;
        String s2 = num1.length() <= num2.length() ? num1 : num2;

        return multiplyWithSmallNumber(s1, s2);
    }
}
