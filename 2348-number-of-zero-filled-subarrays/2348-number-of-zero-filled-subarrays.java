class Solution {
    public long zeroFilledSubarray(int[] nums) {
        long answer=0;
        int freq=0;
        boolean flag=false;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                answer+=freq++ + 1;
            }
            else{
                freq=0;
            }
        }
        return answer;
    }
}