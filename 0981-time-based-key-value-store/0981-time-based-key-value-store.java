class TimeMap {
    private HashMap<String, TreeMap<Integer, String>> hashMap;

    public TimeMap() {
        hashMap = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        hashMap.computeIfAbsent(key, k -> new TreeMap<>()).put(timestamp, value);
    }
    
    public String get(String key, int timestamp) {
        if (!hashMap.containsKey(key)) return "";

        Map.Entry<Integer, String> floorTimestampEntry = hashMap.get(key).floorEntry(timestamp);
        return (floorTimestampEntry == null) ? "" : floorTimestampEntry.getValue();
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */