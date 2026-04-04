class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;

        List<Integer> tails = new ArrayList<>(); 
        int[] tailsIndex = new int[n];   

        int[] parent = new int[n];  // for reconstruction
        Arrays.fill(parent, -1);

        for (int i = 0; i < n; i++) {
            int pos = Collections.binarySearch(tails, nums[i]); // bisect_left
            if (pos < 0) pos = -(pos + 1);  // insertion point

            if (pos == tails.size()) tails.add(nums[i]);
            else tails.set(pos, nums[i]);

            tailsIndex[pos] = i;

            // if there is prev element
            if (pos > 0)    parent[i] = tailsIndex[pos - 1];
        }

        // Reconstruct LIS
        List<Integer> result = new ArrayList<>();
        int index = tailsIndex[tails.size() - 1];

        while (index != -1) {
            result.add(nums[index]);
            index = parent[index];
        }

        Collections.reverse(result);
        // System.out.println("Longest Icreasing Subsequence : " + result);
        return result.size();   // return tails.size();
    }
}