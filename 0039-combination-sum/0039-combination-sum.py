class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        def helper(cur_list, idx, target):
            if target == 0:
                res.append(list(cur_list))
            else:
                for i in range(idx, len(candidates)):
                    if target >= candidates[i]:
                        helper(cur_list + [candidates[i]], i, target - candidates[i])
                    else:
                        return
                
        res = []
        candidates.sort()
        helper([], 0, target)
        return res