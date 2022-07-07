class Solution {
    public void rotate(int[] nums, int k) {
        int b=nums.length;
        int d,c;
        k%=b;
        k=b-k;
        reverse(nums,0,k-1);
        reverse(nums,k,b-1);
        reverse(nums,0,b-1);
    }
    public void reverse(int[] nums, int a, int b){
        while(a<b){
            int temp=nums[a];
            nums[a]=nums[b];
            nums[b]=temp;
            a++;
            b--;
        }
    }
}