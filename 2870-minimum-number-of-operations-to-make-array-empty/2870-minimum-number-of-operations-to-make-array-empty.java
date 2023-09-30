class Solution {
    public int minOperations(int[] nums) {
        int ans=0;
        Map<Integer,Integer> map=new HashMap<Integer,Integer>();
        
        for(int num:nums){
            map.put(num,map.getOrDefault(num,0)+1);    
        }
        System.out.println(map);
        for(int key:map.keySet()){
            int freq=map.get(key);
            if(freq==1){
                return -1;
            }
            else if(freq%3==0){
                ans+=freq/3;
            }
            else if(freq%3==2){
                ans+=(freq/3)+1;
            }
            else{
                ans+=((freq-4)/3)+2;
            }
        }
        return ans;
    }
}