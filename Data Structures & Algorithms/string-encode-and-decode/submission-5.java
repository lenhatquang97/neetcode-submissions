class Solution {
    static final char divider = 0xC0;

    public String encode(List<String> strs) {
        String encodedString = "";
        for (int i = 0; i < strs.size(); i++) {
            encodedString += strs.get(i) + divider;
        }

        return encodedString; 
    }

    public List<String> decode(String str) {
        List<String> decodedStrings = new ArrayList<String>();
        String tempString = "";

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == divider) {
                decodedStrings.add(tempString);
                tempString = "";
            } else {
                tempString += str.charAt(i);
            }
        }

        return decodedStrings;
    }
}
