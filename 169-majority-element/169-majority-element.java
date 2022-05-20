class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i])){
                int b=map.get(nums[i]);
                b++;
                if(b>nums.length/2){
                    return nums[i];
                }
                map.put(nums[i],b);
            }
            else{
                if(1>nums.length/2){
                    return nums[i];
                }
                map.put(nums[i],1);
            }
        }
        return -1;
    }
}