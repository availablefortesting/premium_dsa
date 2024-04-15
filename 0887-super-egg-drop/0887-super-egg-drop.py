class Solution:
    def superEggDrop(self, k: int, n: int) -> int:
        # approach this problem as with M moves, for how much floor
        # we can give certainty, with given eggs
        
        m = 300 # assume max
        dp = [[0 for _ in range(k + 1)] for _ in range(m + 1)]
        
        for moves in range(1, m + 1):
            for eggs in range(1, k + 1):
                dp[moves][eggs] = 1 + (dp[moves-1][eggs-1] + dp[moves-1][eggs])
                if dp[moves][eggs] >= n:
                    return moves
        