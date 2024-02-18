class Solution:
    def mostBooked(self, n: int, meetings: List[List[int]]) -> int:
        meetings.sort()
        
        rooms_q = [room for room in range(n)]
        heapq.heapify(rooms_q)
        
        cur_meetings = []
        freq = [0] * n
        
        for st,et in meetings:
            # release finished meetings rooms
            while cur_meetings and cur_meetings[0][0] <= st:
                heapq.heappush(rooms_q, heapq.heappop(cur_meetings)[1])

            room_id = None
            # schedule a meeting in new room if there is
            if rooms_q:
                room_id = heapq.heappop(rooms_q)
                heapq.heappush(cur_meetings, [et, room_id])
                
            # else schedule in a room which is earliest free
            else:
                earliest_et, room_id = heapq.heappop(cur_meetings)
                heapq.heappush(cur_meetings, [earliest_et + (et - st), room_id])
            
            freq[room_id] += 1

        # find max-used room among all rooms
        max_used, max_used_room = 0, 0
        for room, f in enumerate(freq):
            if max_used < f:
                max_used, max_used_room = f, room
                
        return max_used_room
                
        
        