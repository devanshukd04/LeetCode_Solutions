class Solution {
    public int firstMissingPositive(int[] nums) {
        HashSet<Integer> set=new HashSet<Integer>();
        int max=0;
        for(int num:nums){
            max=max<num?num:max;
            set.add(num);
        }
        for(int i=1;i<=max;i++){
            if(!set.contains(i)){
                return i;
            }
        }
        return max+1;
    }
}