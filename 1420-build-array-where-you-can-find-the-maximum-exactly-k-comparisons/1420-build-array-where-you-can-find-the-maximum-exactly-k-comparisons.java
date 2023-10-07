class Solution {
    int mod=(int)1e9+7;
    int maxSize;
    int cost;
    int maxAllowed;
    public int numOfArrays(int n, int m, int k) {
        int[][][] dp=new int[n+1][m+1][k+1];
        for(int[][] arr1:dp){
            for(int[] arr2:arr1){
                Arrays.fill(arr2,-1);
            }
        }
        this.maxSize=n;
        this.maxAllowed=m;
        this.cost=k;
        return helper(dp,0,0,0);
    }
    public int helper(int[][][] dp, int size, int max, int currCost){
        if(size>maxSize || currCost>cost){
            return 0;
        }
        if(size==maxSize){
            if(currCost==cost){
                return 1;
            }
            return 0;
        }
        if(dp[size][max][currCost]!=-1){
            return dp[size][max][currCost];
        }
        
        int ans=0;
        for(int i=1;i<=maxAllowed;i++){
            if(i<=max){
                ans=(ans+helper(dp,size+1,max,currCost))%mod;
            }
            else{
                ans=(ans+helper(dp,size+1,i,currCost+1))%mod;
            }
        }
        return dp[size][max][currCost]=ans;
    }
}