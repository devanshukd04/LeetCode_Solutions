class Solution {
    public int mostFrequentEven(int[] nums) {
        int max=0;
        int ans=-1;
        HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
        for(int num:nums){
            if(num%2==0){
                map.put(num,map.getOrDefault(num,0)+1);
            }
        }
        for(int num:nums){
            if(num%2==0){
                if(map.get(num)>max){
                    max=map.get(num);
                    ans=num;
                }
                else if(map.get(num)==max){
                    ans=Math.min(ans,num);
                }
            }
        }
        return ans;
    }
}