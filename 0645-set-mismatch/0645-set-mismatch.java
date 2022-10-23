class Solution {
    public int[] findErrorNums(int[] nums) {
        int i=0;
        int[] ans=new int[2];
        while(i<nums.length){
            if(nums[i]==i+1){
                i++;
            }
            else{
                int temp=nums[i];
                nums[i]=nums[temp-1];
                nums[temp-1]=temp;
                if(temp==nums[i]){
                    ans[0]=temp;
                    i++;
                }
            }
        }
        for(int j=0;j<nums.length;j++){
            if(j+1!=nums[j]){
                ans[1]=j+1;
                return ans;
            }
        }
        return ans;
    }
}