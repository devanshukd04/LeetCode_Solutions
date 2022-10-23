class Solution {
    public int[] findErrorNums(int[] nums) {
        int[] ans=new int[2];
        HashSet<Integer> set=new HashSet<Integer>();
        for(int i=1;i<=nums.length;i++){
            set.add(i);
        }
        for(int num:nums){
            if(set.contains(num)){
                set.remove(num);
            }
            else{
                ans[0]=num;
            }
        }
        for(int num:set){
             ans[1]=num;
        }   
        return ans;
    }
}