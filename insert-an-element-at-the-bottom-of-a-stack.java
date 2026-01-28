class Solution {
    public Stack<Integer> insertAtBottom(Stack<Integer> st, int x) {
        insertInBottom(st,x);
        return st;
    }
    
    public static void insertInBottom(Stack<Integer> st, int x){
        if(st.isEmpty()){
            st.push(x);
            return;
        }
        int val = st.pop();
        insertInBottom(st,x);
        st.push(val);
    }
}
