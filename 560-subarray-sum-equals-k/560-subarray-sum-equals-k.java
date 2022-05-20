class Solution {
    public int subarraySum(int[] nums, int k) {
        int a=0;
        int count=0;
        int [] num=new int[nums.length];
        num[0]=nums[0];
        for(int i=1;i<nums.length;i++){
            num[i]=nums[i]+num[i-1];
        }
        for(int i=0;i<nums.length;i++){
            if(k==num[i]){
                count++;
                }
            for(int j=i-1;j>=0;j--){
                a=num[i]-num[j];
                if(a==k){
                    count++;
                }
            }
        }
        return count;
    }
}