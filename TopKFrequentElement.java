class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        PriorityQueue<Integer> mx = new PriorityQueue<>(Collections.reverseOrder());
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int nm : nums) {
            hm.put(nm, hm.getOrDefault(nm, 0) + 1);
        }
        for (Integer value : hm.values()) {
            mx.offer(value);
        }
        int[] r = new int[k];
        Integer firstKey = null;
        for (Map.Entry<Integer, Integer> entry : hm.entrySet()) {
            if (k != 0) {
                int t = mx.poll();
                if (Objects.equals(entry.getValue(), t)) {
                    firstKey = entry.getKey();
                    r[k - 1] = firstKey;
                    k--;
                }
            }
        }
        return r;
    }
}