class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        TreeMap<Integer, HashSet<Integer>> freqToEleMap = new TreeMap<>(Collections.reverseOrder());
        HashMap<Integer, Integer> eleToFreqMap = new HashMap<>();

        for (int num : nums) {
            if (!eleToFreqMap.containsKey(num)) {
                eleToFreqMap.merge(num, 1, Integer::sum);
                freqToEleMap.computeIfAbsent(1, t -> new HashSet<Integer>()).add(num);
            } else {
                var cFreq = eleToFreqMap.get(num);
                eleToFreqMap.merge(num, 1, Integer::sum);

                freqToEleMap.get(cFreq).remove(num);

                freqToEleMap.computeIfAbsent(cFreq + 1, t -> new HashSet<Integer>()).add(num);              
            }
        }
        return freqToEleMap.values().stream().flatMap(Set::stream).limit(k).mapToInt(Integer::intValue).toArray();
    }
}