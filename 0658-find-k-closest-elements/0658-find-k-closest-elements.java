class Solution {
    private int bin_left(int[] arr, int target) {
        int l = 0, r = arr.length;
        
        while (l < r) {
            int mid = l + (r-l) / 2;
            
            if (arr[mid] >= target) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        
        return l;
    }
    
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int n = arr.length;
        
        if (x < arr[0]) {
            int[] res = Arrays.copyOfRange(arr, 0, k);
            return Arrays.stream(res).boxed().collect(Collectors.toList());
        } else if (arr[n-1] < x) {
            int[] res = Arrays.copyOfRange(arr, n - k, n);
            return Arrays.stream(res).boxed().collect(Collectors.toList());
        } else {
            LinkedList<Integer> result = new LinkedList<>();
            
            int pos = bin_left(arr, x);
            int l = pos - 1, r = pos;
            
            while (k != 0) {
                int left = (l >= 0) ? (x - arr[l]) : Integer.MAX_VALUE;
                int right = (r < n) ? (arr[r] - x) : Integer.MAX_VALUE;
                
                if (left <= right) {
                    result.addFirst(arr[l]);
                    l--;
                } else {
                    result.add(arr[r]);
                    r++;
                }
                
                k--;
            }
            return result;
        }
        
    }
}