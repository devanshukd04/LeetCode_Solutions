class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        int count=0;
        HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
        int currsum=0;
        for(int i=0;i<nums.length;i++){
            currsum+=nums[i];
            int removesum=currsum%k;
            if(map.containsKey(removesum) && map.get(removesum)!=i-1){
                return true;
            }
            else if(removesum==0 && i>0){
                return true;
            }
            if(!map.containsKey(currsum%k)){
                map.put(currsum%k,i);   
            }
        }
        return false;
    }
}