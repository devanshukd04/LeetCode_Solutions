class Solution {
    public int findMaxK(int[] nums) {
        HashSet<Integer> set=new HashSet<Integer>();
        for(int num:nums){
            set.add(num);
        }
        int max=0;
        for(int num:nums){
            if(num>max){
                if(set.contains(-num)){
                    max=num;
                }
            }
        }
        return max==0?-1:max;
    }
}