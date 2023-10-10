class Solution {
    public int minOperations(int[] nums) {
        int ans=nums.length;
        
        Set<Integer> set=new HashSet<>();
        for(int num:nums){
            set.add(num);
        }
        
        int[] dp=new int[set.size()];
        int index=0;
        
        for(int num:set){
            dp[index++]=num;
        }
        
        Arrays.sort(dp);
        
        for(int i=0;i<dp.length;i++){
            int left=dp[i];
            int right=left+nums.length-1;
            int j=binarySearch(dp,right);
            int count=j-i;
            ans=Math.min(ans,nums.length-count);
        }
        
        return ans;
        
    }
    public int binarySearch(int[] nums, int target){
        int start=0;
        int end=nums.length-1;
        int index=nums.length;
        while(start<=end){
            int mid=start+(end-start)/2;
            if(nums[mid]>target){
                index=mid;
                end=mid-1;
            }
            else{
                start=mid+1;
            }
        }
        return index;
    }
}