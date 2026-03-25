class Solution {
    public int kthSmallest(int[] arr, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
         for(int i=0;i<arr.length;i++){
            if(pq.size() < k){
                pq.offer(arr[i]);
            }else if(arr[i] < pq.peek()){
                pq.poll();
                pq.offer(arr[i]);
            }
        }
        return pq.peek();
    }
}
