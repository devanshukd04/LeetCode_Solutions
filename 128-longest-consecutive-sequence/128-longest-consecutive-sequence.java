class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> a=new HashSet<Integer>();
        if(nums.length==0){
            return 0;
        }
        int count=0;
        int maxcount=1;
        for(int num:nums){
            a.add(num);
        }
        for(int num:a){
           if(!a.contains(num-1)){
               count=1;
               while(a.contains(num+1)){
                   num++;
                   count++;
               }
                maxcount=maxcount>count?maxcount:count;
            }
        }
        return maxcount;
    }
}