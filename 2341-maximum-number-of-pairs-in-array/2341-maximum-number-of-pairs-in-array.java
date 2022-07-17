class Solution {
    public int[] numberOfPairs(int[] nums) {
        List<Integer> list=new ArrayList<Integer>();
        HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
        int[] ans=new int[2];
        for(int num:nums){
            if(map.containsKey(num)){
                int freq=map.get(num);
                map.put(num,freq+1);
            }
            else{
                map.put(num,1);
                list.add(num);
            }
        }
        for(int num:list){
            int count=map.get(num);
            ans[0]+=count/2;
            ans[1]+=count%2;
        }
        return ans;
    }
}