class Solution {
    static int smallestSumSubarray(int a[], int size) {
        // your code here
        int bestEnding = 0;
        int ans = Integer.MAX_VALUE;
        for(int i=0;i<a.length;i++){
            int v1 = a[i];
            int v2 = bestEnding + a[i];
            bestEnding = Math.min(v1,v2);
            ans = Math.min(bestEnding,ans);
        }
        return ans;
    }
}
