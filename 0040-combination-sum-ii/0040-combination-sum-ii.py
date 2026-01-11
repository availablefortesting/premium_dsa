class Solution:
    def combinationSum2(self, candidates: List[int], target: int) -> List[List[int]]:
        def helper(cur_list, idx, target):
            if target == 0:
                res.append(list(cur_list))
            else:
                for i in range(idx, len(candidates)):
                    if i > idx and candidates[i] == candidates[i-1]:
                        continue
                    if target >= candidates[i]:
                        helper(cur_list + [candidates[i]], i+1, target - candidates[i])
                    else:
                        break
                
        res = []
        candidates.sort()
        print(candidates)
        helper([], 0, target)
        return res