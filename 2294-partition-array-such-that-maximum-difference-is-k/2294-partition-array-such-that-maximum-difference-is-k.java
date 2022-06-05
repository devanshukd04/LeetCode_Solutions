class Solution {
    public int partitionArray(int[] nums, int k) {
        int count=0;
        Arrays.sort(nums);
        boolean flag=false;
        int b;
        b=nums[0];
        System.out.println(Arrays.toString(nums));
        for(int i=0;i<nums.length;i++){
            if(!flag){
                ++count;
                b=nums[i];
                flag=true;
            }
            else{
                if(!((nums[i]-b)<=k)){
                    flag=true;
                    ++count;
                    b=nums[i];
                }
            }
        }
        return count;
    }
}