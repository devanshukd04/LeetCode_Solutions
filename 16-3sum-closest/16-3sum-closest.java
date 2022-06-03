class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int min=Integer.MAX_VALUE;
        int target1=0;
        for(int i=0;i<nums.length;i++){
            int a=nums[i];
            int j,l;
            j=i+1;
            l=nums.length-1;
            while(j<l && l>0 && j<nums.length){
                int b;
                a=nums[i]+nums[j]+nums[l];
                b=a;
                a=Math.abs(target-a);
                if(a<min){
                    min=a;
                    target1=b;
                }
                if(target<nums[i]+nums[j]+nums[l]){
                    l--;
                }
                else if(target>nums[i]+nums[j]+nums[l]){
                    j++;
                }
                else{
                    return target;
                }
            }
        }
        return target1;
    }
}