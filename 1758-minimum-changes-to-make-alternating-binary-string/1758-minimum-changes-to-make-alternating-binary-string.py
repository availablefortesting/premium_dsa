class Solution:
    def minOperations(self, s: str) -> int:
        pos_1,pos_2 = '0','1'
        op_1, op_2 = 0, 0
        
        for c in s:
            if pos_1 != c:  op_1 += 1
            if pos_2 != c:  op_2 += 1
                
            pos_1, pos_2 = pos_2, pos_1
            
        return min(op_1, op_2)