class Solution {
    public int singleNonDuplicate(int[] nums) {
        int start=0;
        int end=nums.length-1;
        if(nums.length==1){
            return nums[0];
        }
        while(start<=end){
            int mid=end+(start-end)/2;
            if(mid==0 && nums[mid]!=nums[mid+1]){
                return nums[mid];
            }
            else if(mid==nums.length-1 && nums[mid]!=nums[mid-1]){
                return nums[mid];
            }
            else if(nums[mid]!=nums[mid-1] && nums[mid]!=nums[mid+1]){
                return nums[mid];
            }
            if(mid%2==0){
                if((mid+1)<nums.length && nums[mid]!=nums[mid+1]){
                    end=mid-1;
                }
                else{
                    start=mid+1;
                }
            }
            else{
                if((mid-1)>=0 && nums[mid]==nums[mid-1]){
                    start=mid+1;
                }
                else{
                    end=mid-1;
                }
            }
        }
        return -1;
    }
}