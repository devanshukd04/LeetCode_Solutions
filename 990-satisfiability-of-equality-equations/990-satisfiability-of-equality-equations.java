class Solution {
    static int[] par;
    public static int findLeaderParent(int u){
        return par[u]==u?u:(par[u]=findLeaderParent(par[u]));
    }
    public boolean equationsPossible(String[] equations) {
        par=new int[26];
        for(int i=0;i<26;i++){
            par[i]=i;
        }
        int[] notArray=new int[26];
        
        for(String str:equations){
            if(str.charAt(1)=='='){
                int p1=findLeaderParent(str.charAt(0)-'a');
                int p2=findLeaderParent(str.charAt(3)-'a');
                if(p1!=p2){
                    par[p2]=p1;
                }
            }
        }
        for(String str:equations){
            if(str.charAt(1)=='!'){
                int p1=findLeaderParent(str.charAt(0)-'a');
                int p2=findLeaderParent(str.charAt(3)-'a');
                if(p1==p2){
                    return false;
                }
            }
        }
        return true;
    }
}
