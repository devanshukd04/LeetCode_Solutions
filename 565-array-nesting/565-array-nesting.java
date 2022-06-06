class Solution {
    public int arrayNesting(int[] nums) {
        int count=Integer.MIN_VALUE;
        boolean[] b=new boolean[nums.length];
        for(int i=0;i<nums.length;i++){
            b[i]=true;
        }
        for(int i=0;i<nums.length;i++){
            HashSet<Integer> a=new HashSet<Integer>();
            boolean flag=true;
            if(b[i]==false){
                flag=false;
            }
            a.add(nums[i]);
            b[i]=false;
            int c=nums[i];
            while(flag){
                if(!a.contains(nums[c])){
                    a.add(nums[c]);
                    b[c]=false;
                    c=nums[c];
                }
                else{
                    if(count<a.size()){
                        count=a.size();
                    }
                    break;
                }
            }   
        }
        return count;
    }
}