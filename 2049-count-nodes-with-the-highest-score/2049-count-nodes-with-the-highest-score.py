class Solution:
    def countHighestScoreNodes(self, parents: List[int]) -> int:
        g, n = defaultdict(set), len(parents)
        for a,b in enumerate(parents[1:]):
            g[b].add(a + 1)
         
        def dfs(node):
            score = 1
            nodes = 1
            for child in g[node]:
                subtree = dfs(child)
                nodes += subtree
                score *= subtree
                
            score *= max(1, n - nodes)
            # print(node, " : ", score)
            nonlocal max_score, m_s_cnt
            if score >= max_score:
                m_s_cnt += 1 if score == max_score else -m_s_cnt + 1
                max_score = score
                
            return nodes
        
        max_score, m_s_cnt = 0, 0
        dfs(0)
        return m_s_cnt