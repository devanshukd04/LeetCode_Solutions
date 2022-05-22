class Solution {
    public boolean search(int[] nums, int target) {
        int a=nums.length-1;
        int b;
        int mid;
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]>nums[i+1]){
              a=i;  
            }
        }
        if(nums[0]>target){
            a=a+1;
            b=nums.length-1;
        }
        else{
            b=a;
            a=0;
        }
        while(a<=b){
            mid=(b-a)/2+a;
            if(nums[mid]==target){
                return true;
            }
            else if(nums[mid]<target){
                while(a<b && a+1<nums.length && nums[a]==nums[a+1]){
                    a++;
                }
                a++;
            }
            else{
                while(a<b && b>=0 && nums[b]==nums[b-1]){
                    b--;
                }
                b--;
            }
        }
        return false;
    }
}