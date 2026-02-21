class Solution {
    public int countPrimeSetBits(int left, int right) {
        int cnt = 0;
        Set<Integer> primes = Set.of(2, 3, 5, 7, 11, 13, 17, 19);

        for (int i = left; i <= right; i++) {
            int setBits = 0;
            for (char c : Integer.toBinaryString(i).toCharArray()) {
                if (c == '1') ++setBits;
            }
            if (primes.contains(setBits)) ++cnt;
        }

        return cnt;
    }
}