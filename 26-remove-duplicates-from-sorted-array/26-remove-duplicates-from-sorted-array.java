class Solution {
    public int removeDuplicates(int[] nums) {
        int i=0;
        int b=0;
        int k=nums.length;
        HashSet<Integer> c=new HashSet<Integer>();
        while(i<k){
            if(!c.contains(nums[i])){
                nums[b]=nums[i];
                ++b;
                c.add(nums[i]);
            }
            else{
                i++;
            }
        }
        return b;
    }
}