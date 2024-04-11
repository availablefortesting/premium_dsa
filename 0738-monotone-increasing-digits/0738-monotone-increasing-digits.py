class Solution:
    def monotoneIncreasingDigits(self, n: int) -> int:
        st = []
        
        for d in str(n)[::-1]:
            d = int(d)
            
            decrease_cnt = 0
            if st and st[-1] < d:
                while st and st[-1] < 9:
                    st.pop()
                    decrease_cnt += 1

                while decrease_cnt:
                    st.append(9)
                    decrease_cnt -= 1
                    
                st.append(d - 1)
            else:
                st.append(d)
                
        return int("".join(map(str, st[::-1])))