class Solution:
    def timeRequiredToBuy(self, tickets: List[int], k: int) -> int:
        time = 0
        
        for i in range(k):
            time += min(tickets[k], tickets[i])
        time += tickets[k]
        
        for i in range(k+1, len(tickets)):
            time += min(tickets[k] - 1, tickets[i])
    
        return time