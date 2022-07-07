class Solution {
    public void rotate(int[] nums, int k) {
        int b=nums.length;
        int d;
        k%=b;
        if(k==0){
            return;
        }
        List<Integer> a=new ArrayList<Integer>();
        int c=b-k;
        d=c;
        
        a.add(nums[c]);
        c=++c%b;
        while(c!=d){
            a.add(nums[c]);
            c=++c%b;
        }
        for(int i=0;i<a.size();i++){
            nums[i]=a.get(i);
        }
    }
}