class Solution {
    String pat,res="";
    boolean[] vis=new boolean[10];
    public String smallestNumber(String pattern) {
        this.pat=pattern;
        for(int i=1;i<10;i++){
            if(helper(i,0,i+"")){
                break;
            }
            vis[i]=false;
        }
        return res;
    }
    public boolean helper(int last, int id, String s){
        if(id==pat.length()){
            res=s;
            return true;
        }
        vis[last]=true;
        boolean flag=pat.charAt(id)=='I';
        for(int i=flag?last+1:1;(flag && i<=9) || (!flag && i<=last-1);i++){
            if(vis[i]){
                continue;
            }
            if(helper(i,id+1,s+i)){
                return true;
            }
            vis[i]=false;
        }
        return false;
    }
}