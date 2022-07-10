class Solution {
    List<String> b=new ArrayList<String>();
    public List<String> generateParenthesis(int n) {
        StringBuilder a=new StringBuilder();
        genParenthesis(n,0,0,a);
        return b;
    }
    public void genParenthesis(int n, int i,int j,StringBuilder a){
        if(i==n && j==n){
            String c=a.toString();
            if(!b.contains(c)){
                b.add(c);
            }
            return;
        }
        else if(i==n){
            genParenthesis(n,i,j+1,a.append(")"));
            a.deleteCharAt(a.length()-1);
        }
        else if(i>j){
            genParenthesis(n,i+1,j,a.append("("));
            a.deleteCharAt(a.length()-1);
            genParenthesis(n,i,j+1,a.append(")"));
            a.deleteCharAt(a.length()-1);
        }
        else if(i==j){
            genParenthesis(n,i+1,j,a.append("("));
            a.deleteCharAt(a.length()-1);
        }
    }
}