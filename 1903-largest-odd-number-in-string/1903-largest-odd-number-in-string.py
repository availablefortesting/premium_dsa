class Solution:
    def largestOddNumber(self, num: str) -> str:
        
        for i in range(len(num)-1, -1, -1):
            cur_last_num = int(num[i])
            
            if cur_last_num % 2 == 1:
                return num[:i+1]
            
        return ""