class Solution:
    def timeRequiredToBuy(self, tickets: List[int], k: int) -> int:
        n = len(tickets)
        q = deque([(t, i) for i, t in enumerate(tickets)])
        time, prev_min = 0, min(tickets)
        tickets = [-1] * len(tickets)
        
        while tickets[k] == -1:
            cur_min = 101
            l, i = len(q), 0
            time += prev_min * l
            
            for _ in range(len(q)):
                i += 1
                t, idx = q.popleft()
                t -= prev_min
                
                cur_min = min(cur_min, t)
                if not t:  tickets[idx] = time - (l - i)
                else:       q.append((t,idx))
                    
            # print(q, tickets)
            prev_min = cur_min
            
        # print(tickets)    
        return tickets[k]