class Solution {
    public void rotate(int[] nums, int k) {
        int b=nums.length;
        int d,c;
        k%=b;
        if(k==0){
            return;
        }
        HashMap<Integer,Integer> a=new HashMap<Integer,Integer>();
        for(int i=0;i<nums.length;i++){
            a.put(i,nums[i]);
        }
        for(int i=0;i<nums.length;i++){
            d=(i+k)%b;
            nums[d]=a.get(i);
            a.remove(i);
        }
    }
}