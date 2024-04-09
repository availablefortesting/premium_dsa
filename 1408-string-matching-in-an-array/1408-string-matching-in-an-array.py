class Solution:
    def stringMatching(self, words: List[str]) -> List[str]:
        
        def prepare_lps(pattern):
            n = len(pattern)
            lps = [0] * n
            
            for i in range(1, n):
                j = lps[i-1]
                
                while j > 0 and pattern[i] != pattern[j]:
                    j = lps[j - 1]
                    
                if pattern[i] == pattern[j]:
                    lps[i] = j + 1
            return lps
                    
        def perform_KMP(text, pattern):
            m,n = len(text), len(pattern)
            lps = prepare_lps(pattern)
            
            i, j = 0, 0
            while i < m:
                if text[i] == pattern[j]:
                    i, j = i+1, j+1
                else:
                    if j == 0:
                        i += 1
                    else:
                        j = lps[j-1]
                if j == n:
                    return True
            return False
        
        words.sort(key = lambda s : len(s))
        res = set()
        for i in range(len(words)):
            for j in range(i+1, len(words)):
                if perform_KMP(words[j], words[i]):
                    res.add(words[i])
                    break
        
        return list(res)