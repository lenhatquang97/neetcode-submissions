class Solution {
    public String delimeter = "@$2f";
    public String specialFlag = "@flag";
    public String encode(List<String> strs) {
        if (strs.size() == 0) return "";
        String str = "";
        for (int i = 0; i < strs.size(); i++) {
            String newStr = strs.get(i).length() == 0 ? specialFlag : strs.get(i); 
            str += delimeter + newStr;
        }
        return str;
    }

    public boolean isTheDelimeter(String str, int start) {
        int end = start + delimeter.length() - 1;
        int idx = 0;
        for (int i = start; i <= end; i++) {
            if (str.charAt(i) != delimeter.charAt(idx)) return false;
            idx++;
        }
        return true;
    }

    public int findFirstDelimeterIdx(String str, int start) {
        for (int i = start; i < str.length(); i++) {
            if (isTheDelimeter(str, i)) {
                return i;
            }
        }
        return -1;
    }
    public List<String> decode(String str) {
        if (str.length() == 0) {
            List<String> ans = new ArrayList<>();
            return ans;
        }
        if (str.equals(delimeter)) {
            List<String> ans = new ArrayList<>();
            ans.add("");
            return ans;
        }

        List<String> res = new ArrayList<>();
        List<Integer> prs = new ArrayList<>();
        int i = 0;
        while (i < str.length()) {
            int idx = findFirstDelimeterIdx(str, i);
            if (idx != -1) {
                prs.add(idx + delimeter.length());
                i = idx + delimeter.length() + 1;
            } else {
                i++;
            }  
        }
        for (int j = 1; j < prs.size(); j++) {
            int right = prs.get(j) - delimeter.length() - 1;
            int left = prs.get(j-1);
            String part = "";
            while(left <= right) {
                part += str.charAt(left);
                left++;
            }
            if (part.length() != 0) {
                res.add(part);
            }
        }

        int right = str.length() - 1;
        int left = prs.get(prs.size() - 1);
        String part = "";
        while(left <= right) {
            part += str.charAt(left);
            left++;
        }
        if (part.length() != 0) {
            res.add(part);
        }

        for (int k = 0; k < res.size(); k++) {
            if (res.get(k).equals(specialFlag)) {
                res.set(k, "");
            }
        }

        return res;
    }
}
