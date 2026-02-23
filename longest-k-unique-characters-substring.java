class Solution {
    public int longestKSubstr(String s, int k) {
        // code here
        int low = 0;
        int high = 0;
        int max = Integer.MIN_VALUE;
        char[] ch = s.toCharArray();
        HashMap<Character,Integer> map = new HashMap<>();
        
        while(high<ch.length){
            map.put(ch[high], map.getOrDefault(ch[high],0)+1);
            
            while(map.size() > k){
                map.put(ch[low], map.get(ch[low])-1);
                if(map.get(ch[low]) == 0 ) {
                    map.remove(ch[low]);
                }
                low++;
            }
            
            if(map.size() == k){
                int len = high - low + 1;
                max = Math.max(len,max);
            }
            high++;
        }
        return max == Integer.MIN_VALUE ? -1 : max;
    }
}
