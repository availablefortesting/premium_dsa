class Solution:
    def sumOfDistancesInTree(self, n: int, edges: List[List[int]]) -> List[int]:
        # Logic
        '''
             y
           /   \
          x     z
         / \   / \
        a   b c   d
        Let's say we know, ans[y] = T
         now to find ans[x] we're moving out root from y -> x.
          -> So, new distance for all subtree of 'y' will have extra one edge to travel
          -> and all subtree of 'x' will have less one edge to travel
          
          ans[x] = ans[y] + nodes[y] - nodes[x]
                 = ans[y] + N - 2 * nodes[x]
        '''
        def count_nodes_and_build_one_ans(node, parent):
            for child in g[node]:
                if child != parent:     # to avoid loop
                    count_nodes_and_build_one_ans(child, node)
                    nodes[node] += nodes[child]
                    res[0] += nodes[child]
                    
        def build_ans_for_others(node, parent):
            for child in g[node]:
                if child != parent:
                    res[child] = res[node] + (n - 2 * nodes[child])
                    build_ans_for_others(child, node)
                    
        g = defaultdict(set)
        for a,b in edges:
            g[a].add(b)
            g[b].add(a)
            
        # phase 1
        nodes, res = [1] * n, [0] * n
        count_nodes_and_build_one_ans(0, -1)
        
        # phase 2
        build_ans_for_others(0, -1)
        # print(nodes, res)       # [6, 1, 4, 1, 1, 1] [8, 12, 6, 10, 10, 10]
        return res