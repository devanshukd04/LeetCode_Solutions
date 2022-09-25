class Solution {
    public int longestSubarray(int[] nums) {
        int length=0;
        int ans=0;
        int max=0;
        for(int i=0;i<nums.length;i++){
            max=Math.max(max,nums[i]);
        }
        boolean prev=false;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==max){
                if(prev){
                    length++;
                }
                else{
                    length=1;
                }
                prev=true;
            }
            else{
                length=0;
            }
            ans=Math.max(ans,length);
        }
        return ans;
    }
}