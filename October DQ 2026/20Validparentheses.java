class Solution {
    public boolean isValid(String s) {
        if(s.length()==0){
            return false;
        }
        Stack<Character> st = new Stack<>();
        for(int i = 0; i< s.length(); i++){
            char c = s.charAt(i);
            if(c=='(' || c=='[' || c=='{'){
                st.push(c);
            }
            else if (!st.isEmpty() && c==')' && st.peek()=='(') st.pop();
            else if (!st.isEmpty() && c=='}' && st.peek()=='{') st.pop();
            else if (!st.isEmpty() && c==']' && st.peek()=='[') st.pop();
            else return false;
        }
        return st.isEmpty();
    }
}