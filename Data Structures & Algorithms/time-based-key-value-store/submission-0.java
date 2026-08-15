class CustomPair {
    String key;
    int timestamp;
    CustomPair(String key, int timestamp) {
        this.key = key;
        this.timestamp = timestamp;
    }
}
class TimeMap {
    public Map<String, Map<Integer,String>> hm;

    public TimeMap() {
        hm = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        Map<Integer, String> timestampHm;
        if (!hm.containsKey(key)) {
            timestampHm = new TreeMap<>();
        } else {
            timestampHm = hm.get(key);
        }
        timestampHm.put(timestamp, value);
        hm.put(key, timestampHm);
    }
    
    public String get(String key, int timestamp) {
        if (!hm.containsKey(key)) return "";
        Map<Integer, String> timestampHm = hm.get(key);
        List<Integer> listKeys = new ArrayList<>(timestampHm.keySet());
        int lo = 0;
        int hi = listKeys.size() - 1;
        int resIndex = -1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (listKeys.get(mid) <= timestamp) {
                resIndex = mid;
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return resIndex == -1 ? "" : timestampHm.get(listKeys.get(resIndex));

    }
}
