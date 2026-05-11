class Solution {
    public int[] separateDigits(int[] nums) {
        return Arrays.stream(nums)
            .mapToObj(String::valueOf)
            .flatMapToInt(str -> str.chars().map(c -> c - '0'))
            .toArray();
    }
}