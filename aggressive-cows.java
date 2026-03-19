class Solution {
    public int aggressiveCows(int[] stalls, int k) {
        Arrays.sort(stalls);
        if( k > stalls.length) return -1;
        int low = 1;
        int high = stalls[stalls.length-1] - stalls[0];
        int res = -1;
        
        while(low <= high){
            int mid = low + (high - low)/2;
            boolean dist = isGood(stalls,mid,k);
            if(dist){
                res = mid;
                low = mid+ 1;
            }else{
                high = mid - 1; 
            }
        }
        return res;
    }
    public static boolean isGood(int[] stalls,int mid,int k){
        int cows = 1;
        int pos = stalls[0];
        for(int i=1;i<stalls.length;i++){
            int dis = stalls[i] - pos;
            if(dis < mid){
                continue;
            }else{
                pos = stalls[i];
                cows++;
            }
            if(cows >= k){
                return true;
            }
        }
        return false;
    }
}
