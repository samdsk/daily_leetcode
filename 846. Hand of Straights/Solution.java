class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0)
            return false;

        Map<Integer, Integer> map = new TreeMap<>();

        for (int n : hand) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        while (map.size() > 0) {
            int count = 0;
            int cur = map.entrySet().iterator().next().getKey();

            while (count < groupSize) {
                int temp = cur + count;
                if (!map.containsKey(temp))
                    return false;

                map.put(temp, map.get(temp) - 1);

                if (map.get(temp) < 1)
                    map.remove(temp);

                count++;
            }
        }

        return true;
    }
}