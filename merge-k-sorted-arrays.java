class Solution {
    public ArrayList<Integer> mergeArrays(int[][] mat) {
       PriorityQueue<Triplet> pq = new PriorityQueue<>((a,b) -> a.value - b.value);
       ArrayList<Integer> arr = new ArrayList<Integer>();
       
       for(int i=0;i<mat.length;i++){
           pq.add(new Triplet(mat[i][0],i,0));
       }
       
       
       while(!pq.isEmpty()){
           Triplet p = pq.poll();
           arr.add(p.value);
           p.col++;
           if(p.col < mat[p.row].length){
                pq.add(new Triplet(mat[p.row][p.col],p.row,p.col));
           }
       }
       return arr;
       
       
    }
    public static class Triplet{
        int value;
        int row;
        int col;
        public Triplet( int value,
        int row,
        int col){
            this.value = value;
            this.row = row;
            this.col = col;
        }
    }
}
