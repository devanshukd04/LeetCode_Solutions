class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        int count=0;
        HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
        int currsum=0;
        if(nums.length==1){
            return false;
        }
        for(int i=0;i<nums.length;i++){
            currsum+=nums[i];
            int removesum=currsum%k;
            if(map.containsKey(removesum) && map.get(removesum)!=i-1){
                return true;
            }
            else if(removesum==0 && nums[1]!=0 && map.containsKey(removesum) && map.get(removesum)==i-1){
                return true;
            }
            if(!map.containsKey(currsum%k)){
                map.put(currsum%k,i);   
            }
            else if(currsum==0 && map.get(0)==1 && nums[0]!=0){
                map.put(0,i);
            }
            if(i==0){
                map.put(0,1);
            }
        }
        return false;
    }
}