class Solution {
    public int minCost(int[] nums, int k) {
        int[] dp=new int[nums.length];
        Arrays.fill(dp,-1);
        return helper(nums,dp,0,k);
    }
    public int helper(int[] nums,int[] dp,int index,int k){
        if(index==nums.length){
            return 0;
        }
        if(dp[index]!=-1){
            return dp[index];
        }
        int sum=0;
        int ans=Integer.MAX_VALUE;
        HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
        for(int i=index;i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
            if(map.get(nums[i])==2){
                sum+=2;
            }
            else if(map.get(nums[i])>2){
                sum+=1;
            }
            ans=Math.min(ans,sum+k+helper(nums,dp,i+1,k));
        }
        return dp[index]=ans;
    }
}