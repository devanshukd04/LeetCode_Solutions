class Solution {
    public long maxBalancedSubsequenceSum(int[] nums) {
        
        long ans=Integer.MIN_VALUE;
        
        for(int i=0;i<nums.length;i++){
            ans=Math.max(ans,nums[i]);
        }
        
        int[] updatedNums=new int[nums.length];
        
        for(int i=0;i<nums.length;i++){
            updatedNums[i]=nums[i]-i;
        }
        
        
        TreeMap<Integer,Long> map=new TreeMap<Integer,Long>();
        
        for(int i=0;i<updatedNums.length;i++){
            
            int num=updatedNums[i];
            Integer firstSmallerKey=map.floorKey(num);
            
            map.put(num,Math.max(map.getOrDefault(firstSmallerKey!=null?firstSmallerKey:num,(long)0),0)+nums[i]);
            
            while(map.ceilingKey(num+1)!=null){
                Integer firstBiggerKey=map.ceilingKey(num+1);
                if(map.get(firstBiggerKey)<map.get(num)){
                    map.remove(firstBiggerKey);
                }
                else{
                    break;
                }
            }
        
            ans=Math.max(ans,map.get(num));
        }
        
        return ans;
    }
}