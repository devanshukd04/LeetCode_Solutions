class Solution {
    public int calculate(String s) {
        Stack<Integer> stack=new Stack<Integer>();
        int curr=0;
        char op='+';
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(Character.isDigit(ch)){
                curr=(curr*10)+(ch-'0');
            }
            if(!Character.isDigit(ch) && ch!=' ' || i==s.length()-1){
                if(op=='+'){
                    stack.push(curr);
                }
                else if(op=='-'){
                    stack.push(-curr);
                }
                else if(op=='*'){
                    stack.push(stack.pop()*curr);
                }
                else if(op=='/'){
                    stack.push(stack.pop()/curr);
                }
                curr=0;
                op=ch;
            }
        }
        int sum=0;
        while(!stack.isEmpty()){
            sum+=stack.pop();
        }
        return sum;
    }
}