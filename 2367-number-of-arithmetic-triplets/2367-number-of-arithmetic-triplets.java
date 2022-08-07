class Solution {
    public int arithmeticTriplets(int[] nums, int diff) {
        int ans=0;
        HashSet<Integer> set=new HashSet<Integer>();
        for(int num:nums){
            set.add(num);
        }
        for(int num:nums){
            if(set.contains(num+diff) && set.contains(num+2*diff)){
                ans++;
            }
        }
        return ans;
    }
}