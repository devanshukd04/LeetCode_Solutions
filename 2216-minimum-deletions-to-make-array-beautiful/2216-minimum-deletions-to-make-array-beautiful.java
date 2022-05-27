class Solution {
    public int minDeletion(int[] nums) {
        int count=0;
        int i=0;
        while(i<nums.length){
            if((i-count)%2==0){
                if(i+1<nums.length){
                    if(nums[i]==nums[i+1]){
                        ++count;
                    }
                }
                else{
                    break;
                }
            }
            ++i;
        }
        if(!((nums.length-count)%2==0)){
            ++count;
        }
        return count;
    }
}