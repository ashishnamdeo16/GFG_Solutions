class Solution {
    public boolean isCyclic(int V, int[][] edges) {
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
        
        boolean[] visited = new boolean[V];
        boolean[] inStack = new boolean[V];

        
        
        for(int i=0;i<V;i++){
            if(!visited[i]){
                if(dfs(i,graph,visited,inStack)) return true;
            }
        }
        return false;
    }
    
    public boolean dfs(int node,List<List<Integer>> graph,boolean[] visited,boolean[] inStack){
        inStack[node] = true;
        visited[node] = true;
        
        for(int x: graph.get(node)){
            if(inStack[x]){
                return true;
            }
            
            if(!visited[x]){
                if(dfs(x,graph,visited,inStack)) return true;
            }
        }
        inStack[node] = false;
        return false;
    }
    
    
    
    
    
    
    
    
    
    
    
}
