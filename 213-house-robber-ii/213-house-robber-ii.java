class Solution {
    public int rob(int[] nums) {
        if(nums.length==1){
            return nums[0];
        }
        if(nums.length==2){
            return Math.max(nums[0],nums[1]);
        }
        int prev=nums[0];
        int prev2=0;
        for(int i=1;i<nums.length-1;i++){
            int current=Math.max(nums[i]+prev2,prev);
            prev2=prev;
            prev=current;
        }
        int ans1=Math.max(prev,prev2);
        
        prev=nums[1];
        prev2=0;
        for(int i=2;i<nums.length;i++){
            int current=Math.max(nums[i]+prev2,prev);
            prev2=prev;
            prev=current;
        }
        int ans2=Math.max(prev,prev2);
        
        return Math.max(ans1,ans2);
    }
}