class Solution {
    public int search(int[] nums, int target) {
        int i=0;
        int j=nums.length-1;
        while(i<=j){
            if(nums[(i+j)/2]>target){
                j=(i+j)/2-1;
            }
            else if(nums[(i+j)/2]<target){
                i=(i+j)/2+1;
            }
            else{
                return (i+j)/2;
            }
        }
        return -1;
    }
}