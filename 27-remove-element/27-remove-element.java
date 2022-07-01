class Solution {
    public int removeElement(int[] nums, int val) {
        int i=0;
        int k=nums.length;
        while(i<k){
            if(nums[i]==val){
                int temp=nums[i];
                nums[i]=nums[k-1];
                nums[k-1]=temp;
                k--;
            }
            else{
                i++;
            }
        }
        return k;
    }
}