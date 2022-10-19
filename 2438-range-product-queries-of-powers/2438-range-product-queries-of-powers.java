class Solution {
    public int[] productQueries(int n, int[][] queries) {
        int[] ans=new int[queries.length];
        List<Integer> power=new ArrayList<Integer>();
        int bit=1;
        while(n>0){
            if((n&1)==1){
                power.add(bit);
            }
            bit*=2;
            n>>=1;
        }
        int[] degree=new int[power.size()];
        degree[0]=power.get(0);
        for(int i=1;i<degree.length;i++){
            degree[i]=(degree[i-1]*power.get(i))%((int)1e9+7);
        }
        for(int i=0;i<queries.length;i++){
            long res=1;
            for(int j=queries[i][0];j<=queries[i][1];j++){
                res=(res*power.get(j))%((int)1e9+7);
            }
            ans[i]=(int)res%((int)1e9+7);
        }
        return ans;
    }
}