class Solution {
    List<String> b=new ArrayList<String>();
    public List<String> generateParenthesis(int n) {
        genParenthesis(n,0,0,"");
        return b;
    }
    public void genParenthesis(int n, int i,int j,String a){
        if(i==n && j==n){
            if(!b.contains(a)){
                b.add(a);
            }
            return;
        }
        else if(i==n){
            genParenthesis(n,i,j+1,a+")");
        }
        else if(i>j){
            genParenthesis(n,i+1,j,a+"(");
            genParenthesis(n,i,j+1,a+")");
        }
        else if(i==j){
            genParenthesis(n,i+1,j,a+"(");
        }
    }
}