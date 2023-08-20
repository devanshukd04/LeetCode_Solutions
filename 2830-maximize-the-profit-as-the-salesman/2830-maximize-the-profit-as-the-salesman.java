class Solution {
    public int maximizeTheProfit(int n, List<List<Integer>> offers) {
        Collections.sort(offers,(a,b)->a.get(0)-b.get(0));
        int[] dp=new int[offers.size()+2];
        Arrays.fill(dp,-1);
        return helper(offers,dp,0);
    }
    public int helper(List<List<Integer>> offers, int[] dp, int index){
        if(index>=offers.size()){
            return 0;
        }
        if(dp[index]!=-1){
            return dp[index];
        }
        int take=offers.get(index).get(2);
        int notTake=helper(offers,dp,index+1);
        int endIndex=nextIndex(offers,offers.get(index).get(1));
        if(endIndex!=-1){
            take+=helper(offers,dp,endIndex);
        }
        return dp[index]=Math.max(take,notTake);
    }
    public int nextIndex(List<List<Integer>> offers,int endIndex){
        int start=0;
        int end=offers.size()-1;
        int ans=-1;
        while(start<=end){
            int mid=start+(end-start)/2;
            if(offers.get(mid).get(0)>endIndex){
                ans=mid;
                end=mid-1;
            }
            else{
                start=mid+1;
            }
        }
        return ans;
    }
}