class Solution {
    public int findSpecialInteger(int[] arr) {
        int n = arr.length;
        int[] candidates = {arr[n / 4], arr[n / 2], arr[3 * n / 4]};
        int target = n / 4;
        
        for (int candidate : candidates) {
            int left = bisect_left(arr, candidate, true);
            int right = bisect_left(arr, candidate, false) - 1;
            if (right - left + 1 > target) {
                return candidate;
            }
        }
        
        return -1;
    }
    
    public int bisect_left(int[] arr, int target, boolean isBisectLeft) {
        int left = 0;
        int right = arr.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            
            if (arr[mid] > target || (isBisectLeft && arr[mid] == target)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }
    
    public int bisect_right(int[] arr, int target) {
        int left = 0;
        int right = arr.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] > target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }
}