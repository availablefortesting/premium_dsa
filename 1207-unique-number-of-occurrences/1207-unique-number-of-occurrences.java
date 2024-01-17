class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        
        for (int n : arr)
            freq.put(n, 1 + freq.getOrDefault(n, 0));
        
        HashSet<Integer> unique_freq = new HashSet<>();
        for (int key : freq.keySet()) {
            if (unique_freq.contains(freq.get(key)))
                return false;
            else
                unique_freq.add(freq.get(key));
        }
    
        return true;
    }
}