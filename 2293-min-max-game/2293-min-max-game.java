class Solution {
    public int minMaxGame(int[] nums) {
        if(nums.length==1){
            return nums[0];
        }
        List<Integer> a=new ArrayList<Integer>();
        boolean flag=true;
        for(int i=0;i<nums.length;i+=2){
            int a1=nums[i];
            int b1=nums[i+1];
            if(flag){
                a.add(Math.min(a1,b1));
                flag=!flag;
            }
            else{
                a.add(Math.max(a1,b1));
                flag=!flag;
            }
        }
        int[] nums1=new int[a.size()];
        for(int i=0;i<a.size();i++){
            nums1[i]=a.get(i);
        }
        return minMaxGame(nums1);
    }
}