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
        int i=0;
        while (i!=k) {
            int t = mx.poll();
            for (int key : hm.keySet()) {
                if (hm.get(key) == t) {
                    r[i++] = key;
                    hm.remove(key);
                    break;
                }
            }
        }
        return r;
    }
}