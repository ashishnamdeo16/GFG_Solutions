class Solution {
    public ArrayList<Integer> topoSort(int V, int[][] edges) {
        // code here
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0;i<V;i++){
            graph.add(new ArrayList<>());
        }
        
        for(int[] x : edges){
            int u = x[0];
            int v = x[1];
            graph.get(u).add(v);
        }
        
        // int[] indegree = new int[V];
        // for(int j=0;j<V;j++){
        //     for(int x : graph.get(j)){
        //         indegree[x]++;
        //     }
        // }
        
        ArrayList<Integer> ans = new ArrayList<>();
        
        //Using DFS
        boolean[] visited = new boolean[V];
        for(int i=0;i<V;i++){
            if(!visited[i]){
                 dfs(i,graph,ans,visited);
            }
        }
        
        //Using BFS
        // Queue<Integer> que = new ArrayDeque<>();
        // for(int k = 0;k<indegree.length;k++){
        //     if(indegree[k] == 0){
        //         que.offer(k);
        //     }
        // }
        
        // while(!que.isEmpty()){
        //     int node = que.poll();
        //      ans.add(node);
        //     for(int q : graph.get(node)){
        //         indegree[q]--;
        //         if(indegree[q] == 0){
        //             que.offer(q);
        //         }
        //     }
        // }

        return ans;
    }
    
    public static void dfs(int node, List<List<Integer>> graph,List<Integer> ans,boolean[] visited){
        visited[node] = true;
        for(int x : graph.get(node)){
            if(!visited[x]){
                 dfs(x,graph,ans,visited);    
            }
        }
        ans.add(0,node); 
    }
    
}
