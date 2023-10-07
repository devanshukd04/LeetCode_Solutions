class Solution {
    int mod=(int)1e9+7;
    public int numOfArrays(int n, int m, int k) {
        int[][][] dp=new int[n+1][k+1][m+1];
        for(int[][] arr1:dp){
            for(int[] arr2:arr1){
                Arrays.fill(arr2,-1);
            }
        }
        return helper(dp,n,k,m,0,0,0);
    }
    public int helper(int[][][] dp, int maxSize, int cost, int maxAllowed, int size, int currCost, int max){
        if(size>maxSize || currCost>cost){
            return 0;
        }
        if(size==maxSize){
            if(currCost==cost){
                return 1;
            }
            return 0;
        }
        if(dp[size][currCost][max]!=-1){
            return dp[size][currCost][max];
        }
        
        int ans=0;
        for(int i=1;i<=maxAllowed;i++){
            if(i<=max){
                ans=(ans+helper(dp,maxSize,cost,maxAllowed,size+1,currCost,max))%this.mod;
            }
            else{
                ans=(ans+helper(dp,maxSize,cost,maxAllowed,size+1,currCost+1,i))%this.mod;
            }
        }
        return dp[size][currCost][max]=ans;
    }
}