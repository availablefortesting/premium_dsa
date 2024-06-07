class Solution:
    def replaceWords(self, dictionary: List[str], sentence: str) -> str:
        d = {"" : {}}
        for word in dictionary:
            cur = d
            for i in range(len(word)):
                if "end" in cur: break
                if word[i] not in cur:
                    cur[word[i]] = {}
                cur = cur[word[i]]
            cur["end"] = None
                    
        res = []
        for word in sentence.split(" "):
            added = False
            if word[0] in d:
                cur = d
                for i in range(len(word)):
                    if word[i] in cur:
                        cur = cur[word[i]]
                    else:
                        break
                    
                    if "end" in cur:
                        res.append(word[:i+1])
                        added = True
                        break
                        
            if not added:
                res.append(word)
        
        return " ".join(res)