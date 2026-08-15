class Solution {
    public boolean isSpecial(char ch) {
        int num = (int) ch;
        boolean isNumber = (num >= 48 && num <= 57);
        boolean isUpper = (num >= 65 && num <= 90);
        boolean isLower = (num >= 97 && num <= 122);
        return !isNumber && !isUpper && !isLower;        
    }
    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left <= right) {
            while (left <= right && isSpecial(s.charAt(left))) {
                left++;
            }

            while (left <= right && isSpecial(s.charAt(right))) {
                right--;
            }

            if (left <= right) {
                if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                    return false;
                }
            } else {
                break;
            }
            left++;
            right--;
        }
        return true;
    }
}
