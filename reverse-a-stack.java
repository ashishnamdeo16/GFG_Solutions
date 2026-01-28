class Solution {
    public static void reverseStack(Stack<Integer> st) {
            revForMe(st);
    }
    
    public static void revForMe(Stack<Integer> st){
        if(st.isEmpty()){
            return;
        }
        int x = st.pop();
        revForMe(st);
        insertAtBottom(st, x);
    }
    public static void insertAtBottom(Stack<Integer> st,int x){
        if(st.isEmpty()){
            st.push(x);
            return;
        }
        int val = st.pop();
        insertAtBottom(st,x);
        st.push(val);
    }
    
}
