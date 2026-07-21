class Solution {
    public int evalRPN(String[] ts) {
        Stack<Integer> stack = new Stack<>();

        for(String t : ts){
            if(t.equals("+")){
                int b = stack.pop();
                int a = stack.pop();
                stack.push(a+b);
            }else if(t.equals("-")){
                int b = stack.pop();
                int a = stack.pop();
                stack.push(a-b);
            }else if(t.equals("*")){
                int b = stack.pop();
                int a = stack.pop();
                stack.push(a*b);
            }else if(t.equals("/")){
                int b = stack.pop();
                int a = stack.pop();
                stack.push(a/b);
            }else{
                stack.push(Integer.parseInt(t));
            }
        }
        return stack.pop();
    }
}
