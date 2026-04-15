class Solution {
    public int closestTarget(String[] words, String target, int startIndex) {
        int n = words.length;

        for (int d = 0; d < n; d++) {
            int left = (startIndex - d + n) % n;
            int right = (startIndex + d) % n;

            if (words[left].equals(target) || words[right].equals(target))  return d;
        }
        return -1;
    }
}