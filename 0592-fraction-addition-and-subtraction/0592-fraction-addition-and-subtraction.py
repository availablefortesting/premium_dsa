class Solution:
    def fractionAddition(self, exp: str) -> str:
        fractions = []
        cur_frc, cur_num = [], ""
        
        for c in (exp + "+"):
            if c in ["+","-"]:
                if cur_frc and cur_num:     # for -1/-2
                    cur_frc.append(int(cur_num))
                    fractions.append(cur_frc)
                
                    cur_frc = []
                cur_num = c
            elif c == "/":
                cur_frc.append(int(cur_num))
                cur_num = ""
            else:
                cur_num += c
        
        if not fractions:
            return ""
        
        A,B = fractions[0]
        
        for frac in fractions[1:]:
            n1,n2 = frac
            
            A = (B * n1) + (A * n2)
            B = B * n2
            
            gcd = math.gcd(A, B)
            A, B = (A // gcd), (B // gcd)
            
        
        return "%d/%d" % (A, B)
            