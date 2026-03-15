class Solution:
    def getHappyString(self, n: int, k: int) -> str:
        def helper(s):
            nonlocal n,k
            if len(s) == n:
                k -= 1
                if not k: raise ValueError("".join(s))
                return None

            for c in ["a","b","c"]:
                if not s or s[-1] != c:
                    helper(s + [c])
        try:
            helper([])
            return ""
        except ValueError as e:
            return str(e)