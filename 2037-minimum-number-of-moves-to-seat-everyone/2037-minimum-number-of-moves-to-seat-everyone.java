class Solution {
    public int minMovesToSeat(int[] seats, int[] students) {
        Arrays.sort(seats);
        Arrays.sort(students);
        
        int min_moves = 0;
        for (int i = 0; i < seats.length; i++)
            min_moves += Math.abs(seats[i] - students[i]);
        
        return min_moves;
    }
}