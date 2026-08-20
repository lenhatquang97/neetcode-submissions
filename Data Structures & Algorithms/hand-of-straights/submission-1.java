class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0) return false;
        Arrays.sort(hand);
        TreeMap<Integer, Integer> mp = new TreeMap<>();
        for (int i = 0; i < hand.length; i++) {
            mp.put(hand[i], mp.getOrDefault(hand[i], 0) + 1);
        }
        int currentSize = 1;
        int groupNumber = hand.length / groupSize;
        while (currentSize <= groupNumber) {
            Integer tmp = mp.firstKey();
            for (int i = 0; i < groupSize; i++) {
                int key = tmp + i;
                if (!mp.containsKey(key)) {
                    return false;
                } else {
                    mp.put(key, mp.getOrDefault(key, 0) - 1);
                    if (mp.getOrDefault(key, 0) <= 0) {
                        mp.remove(key);
                    }
                }
            } 
            currentSize++;
        }
        return true;
    }
}
