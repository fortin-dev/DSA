// 981. Time Based Key-Value Store
// Medium
// Topics
// Companies
// Design a time-based key-value data structure that can store multiple values for the same key at different time stamps and retrieve the key's value at a certain timestamp.

// Implement the TimeMap class:

// TimeMap() Initializes the object of the data structure.
// void set(String key, String value, int timestamp) Stores the key key with the value value at the given time timestamp.
// String get(String key, int timestamp) Returns a value such that set was called previously, with timestamp_prev <= timestamp. If there are multiple such values, it returns the value associated with the largest timestamp_prev. If there are no values, it returns "".
class TimeMap {
    
    private Map<String , List<Pair<Integer, String>>> keyStore;

    public TimeMap() {
        keyStore = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        keyStore.computeIfAbsent(key , k -> new ArrayList<>()).add(new Pair<>(timestamp, value));
    }
    
    public String get(String key, int timestamp) {
        List<Pair<Integer , String>> values = keyStore.getOrDefault(key, new ArrayList<>());
        int l =0, r = values.size()-1;
        String result = "";

        while(l <= r){
            int m = l+(r-l)/2;
            if(values.get(m).getKey() <= timestamp){
                result = values.get(m).getValue();
                l = m+1;
            }else{
                r= m-1;
            }
        }
        return result;
    }
    private static class Pair<K,V>{
        private final K key;
        private final V value;
        public Pair(K key , V value){
            this.key = key;
            this.value = value;
        }

        public K getKey(){
            return key;
        }
        public V getValue(){
            return value;
        }
    }
}
