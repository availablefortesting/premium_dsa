class Solution:
    def mostBooked(self, n: int, meetings: List[List[int]]) -> int:
        meetings.sort()
        rooms_q = [room for room in range(n)]
        heapq.heapify(rooms_q)
        
        cur_meetings = []
        freq = defaultdict(int)
        
        for st,et in meetings:
            if not cur_meetings:
                heapq.heappush(cur_meetings, [et, heapq.heappop(rooms_q)])
                freq[0] += 1
            else:
                while cur_meetings and cur_meetings[0][0] <= st:
                    heapq.heappush(rooms_q, heapq.heappop(cur_meetings)[1])
                
                if not cur_meetings:
                    free_room = heapq.heappop(rooms_q)
                    heapq.heappush(cur_meetings, [et, free_room])
                    freq[free_room] += 1
                else:
                    if not rooms_q:
                        end_t, room_id = heapq.heappop(cur_meetings)
                        heapq.heappush(cur_meetings, [end_t + (et - st), room_id])
                        freq[room_id] += 1
                    else:
                        free_room = heapq.heappop(rooms_q)
                        heapq.heappush(cur_meetings, [et, free_room])
                        freq[free_room] += 1
            # print(cur_meetings, rooms_q)
        
        # print(freq)
        max_used, max_used_room = 0, 0
        for room, f in freq.items():
            if max_used < f:
                max_used = f
                max_used_room = room
                
        return max_used_room
                
        
        