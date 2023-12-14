class Solution {
    public int minimumSwaps(int[] nums) {
        int indexMax = 0, indexMin = 0;
        int min = nums[0], max = nums[0];
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < min) {
                min = nums[i];
                indexMin = i;
            }
            if (nums[i] >= max) {
                max = nums[i];
                indexMax = i;
            }
        }
        
        boolean isOverlap = indexMin > indexMax;
        int swapsForMin = indexMin;
        int swapsForMax = (nums.length - 1) - indexMax;
        
        // -1 because swapping one will swap other to its side.
        return isOverlap? swapsForMin + swapsForMax - 1 : swapsForMin + swapsForMax;
    }
}