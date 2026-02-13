class Solution {
    public boolean isCycle(int V, int[][] edges) {
        // Code here
       List<List<Integer>> graph = new ArrayList<>();
       
       for(int i=0;i<V;i++){
           graph.add(new ArrayList<>());
       }
       
       for(int[] x : edges ){
           int u = x[0];
           int v = x[1];
           
           graph.get(u).add(v);
           graph.get(v).add(u); 
       }
       
       boolean[] visited = new boolean[V];
       int[] parent = new int[V];
       
       Arrays.fill(parent, -1);
       
    //   for(int j = 0;j<V;j++){
    //       if(!visited[j]){
    //           if (dfs(j, visited, graph, -1)) return true;
    //       }
    //   }
    
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                if (bfs(i, visited, graph, parent)) return true;
            }
        }
        return false;
    }
    
    public boolean bfs(int node,boolean[] visited, List<List<Integer>> graph,int[] parent){
        Queue<Integer> que = new ArrayDeque<>();
        
        que.offer(node);
        visited[node] = true;
        
        while(!que.isEmpty()){
            int city = que.poll();
            visited[city] = true;
            
            for(int x : graph.get(city)){
                if(!visited[x]){
                    visited[x] = true;  
                    parent[x] = city;
                    que.offer(x);
                }else if (x != parent[city]) {
                    // visited neighbor that's not the parent => cycle
                    return true;
                }
            }
        }
        return false;
    }
    
    
    public boolean dfs(int node,boolean[] visited, List<List<Integer>> graph, int parent){
        visited[node] = true;
        for(int x : graph.get(node)){
            // Case 1: not visited → go deeper
        if(!visited[x]){
            if(dfs(x, visited, graph, node)){
                return true;
            }
        }

        // Case 2: visited and not parent → cycle
        else if(x != parent){
            return true;
        }
        }
        return false;
    }
    
    
}
