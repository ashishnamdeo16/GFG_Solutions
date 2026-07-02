class Solution {
    public int[] bellmanFord(int V, int[][] edges, int src) {
        int[] ans = new int[V];
        Arrays.fill(ans,Integer.MAX_VALUE);
        ans[src] = 0;
 
        
       for(int i=0;i<V-1;i++){
           for(int j=0;j<edges.length;j++){
               int sr = edges[j][0];
               int d = edges[j][1];
               int wt = edges[j][2];
               
               if(ans[sr] != Integer.MAX_VALUE && ans[d] > ans[sr] + wt){
                  ans[d] = ans[sr] + wt;
               }
           }
       }
       
       for(int j=0;j<edges.length;j++){
             int sr = edges[j][0];
               int d = edges[j][1];
               int wt = edges[j][2];
               
               if(ans[sr] != Integer.MAX_VALUE && ans[d] > ans[sr] + wt){
                  return new int[]{-1};
               }
       }
       
       // Convert unreachable vertices
        for (int i = 0; i < V; i++) {
            if (ans[i] == Integer.MAX_VALUE) {
                ans[i] = 100000000;
            }
        }
       
       return ans;
    }
}
