class Solution {
    public int maxOperations(int[] nums, int k) {
        HashMap<Integer,Integer> b=new HashMap<Integer,Integer>();
        int c,d,f;
        int e=0;
        for(int i=0;i<nums.length;i++){
            d=k-nums[i];
            f=nums[i];
            if(b.containsKey(d)){
                c=b.get(d);
                if(c==1){
                    b.remove(d);   
                }
                else{
                    b.put(d,c-1);
                }
                ++e;
            }
            else{
                if(b.containsKey(f)){
                    c=b.get(f);
                    b.put(f,c+1);
                }
                else{
                    b.put(f,1);   
                }
            }
        }
        return e;
    }
}