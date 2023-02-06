class Solution {
    public int[] shuffle(int[] nums, int n) {
        int i=0;
        int j=nums.length/2;
        while(i<j && j<nums.length){
            int temp=j-1;
            int temp1=nums[j];
            while(temp>i){
                nums[temp+1]=nums[temp];
                temp--;
            }
            nums[i+1]=temp1;
            i+=2;
            j++;
        }
        return nums;
    }
}