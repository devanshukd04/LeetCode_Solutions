class Solution {
    public int longestValidParentheses(String s) {
        int a,n,b,c;
        n=0;
        a=0;
        b=0;
        c=0;
        Stack<Character> st=new Stack<>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                a++;
            }
            if(s.charAt(i)==')' && b<a){
                b++;
            }
            else if(s.charAt(i)==')' && b>=a){
                a=0;
                b=0;
            }
            if(a==b){
                c=2*a;
            }
            if(c>n){
                n=c;
            }
        }
        a=0;
        b=0;
        for(int i=s.length()-1;i>=0;i--){
            if(s.charAt(i)==')'){
                b++;
            }
            if(s.charAt(i)=='(' && a<b){
                a++;
            }
            else if(s.charAt(i)=='(' && a>=b){
                c=2*b;
                a=0;
                b=0;
            }
            if(a==b){
                c=2*a;
            }
            if(c>n){
                n=c;
            }
        }
        return n;
    }
}