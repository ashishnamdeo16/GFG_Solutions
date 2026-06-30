class Solution {
    public int[] dijkstra(int V, int[][] edges, int src) {
        List<List<int[]>> graph = new ArrayList<>();
        
        for(int i=0;i<V;i++){
            graph.add(new ArrayList<>());
        }
        
        for(int[] x : edges){
            int u = x[0];
            int v = x[1];
            int wt = x[2];
            
            graph.get(u).add(new int[]{v,wt});
            graph.get(v).add(new int[]{u,wt});
        }
        
        int[] distance = new int[V];
        Arrays.fill(distance,Integer.MAX_VALUE);
        
        PriorityQueue<Pair> heap = new PriorityQueue<>((a,b) -> a.dis - b.dis);
        distance[src] = 0;
        heap.offer(new Pair(0,src));
      
      
        while(!heap.isEmpty()){
            Pair p = heap.poll();
            int d = p.dis;
            int node = p.src;
            
            if(d > distance[node]){
                continue;
            }
            
            for(int[] x : graph.get(node)){
               int neigh = x[0];
               int wt = x[1];
               
               if(d + wt < distance[neigh]){
                   distance[neigh] = d+wt;
                   heap.offer(new Pair(d+wt,neigh));
               }
            }
        }
        
        return distance;
    }
    
    class Pair{
        int dis;
        int src;
        public Pair(int dis,int src){
            this.dis = dis;
            this.src = src;
        }
    }
}
