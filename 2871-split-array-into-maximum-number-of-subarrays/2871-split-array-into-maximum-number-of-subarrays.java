class Solution {
    class Node{
        int val;
        int subArr;
        Node(int val,int subArr){
            this.val=val;
            this.subArr=subArr;
        }
    }
    public int maxSubarrays(int[] nums) {
        int min=nums[0];
        int max=min;
        for(int num:nums){
            min&=num;
            max=Math.max(max,num);
        }
        if(min!=0){
            return 1;
        }
        
        int and=-1;
        int ans=0;
        
        for(int num:nums){
            if(and==-1){
                ans++;
                and=num;
            }
            
            if((and & num)==min){
                and=-1;
            }
            else{
                and&=num;
            }
        }
        
        if(and!=-1){
            ans--;
        }
        return ans;
        
    }
    public int[] helper(int[] nums, int[][] dp, int index){
        if(index>=nums.length){
            return new int[]{0,0};
        }
        if(dp[index][0]!=-1){
            return dp[index];
        }
        int min=nums[index];
        int ans=Integer.MAX_VALUE;
        int subArr=Integer.MIN_VALUE;
        for(int i=index;i<nums.length;i++){
            min&=nums[i];
            int[] node=helper(nums,dp,i+1);
            if((node[0]+min)<(ans)){
                ans=node[0]+min;
                subArr=1+node[1];
            }
            else if((node[0]+min)==(ans)){
                subArr=Math.max(subArr,1+node[1]);
            }
        }
        dp[index][0]=ans;
        dp[index][1]=subArr;
        return dp[index];
    }
    
}