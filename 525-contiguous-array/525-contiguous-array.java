class Solution {
    public int findMaxLength(int[] nums) {
        HashMap<Integer,Integer> a=new HashMap<Integer,Integer>();
        a.put(0,-1);
        int maxsum=0;
        int sum=0;
        for(int i=0;i<nums.length;i++){
            sum=sum+(nums[i]==1?1:-1);
            if(a.containsKey(sum)){
                maxsum=Math.max(maxsum,i-a.get(sum));
            }
            else{
                a.put(sum,i);
            }
        }
        return maxsum;
    }
}