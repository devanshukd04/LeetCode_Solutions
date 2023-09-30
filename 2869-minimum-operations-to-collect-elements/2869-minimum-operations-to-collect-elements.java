class Solution {
    public int minOperations(List<Integer> nums, int k) {
        Set<Integer> set=new HashSet<Integer>();
        for(int i=nums.size()-1;i>=0;i--){
            if(nums.get(i)<=k){
                set.add(nums.get(i));
            }
            if(set.size()==k){
                return nums.size()-i;
            }
        }
        return -1;
    }
}