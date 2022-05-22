class Solution {
    public int findUnsortedSubarray(int[] nums) {
        boolean stat=false;
        int a=-1;
        int b=0;
        int d;
        int[] c=new int[nums.length];
        for(int i=0;i<nums.length;i++){
            c[i]=nums[i];
        }
        for(int i=0;i<nums.length-1;i++){
            stat=false;
            for(int j=1;j<nums.length;j++){
                if(nums[j]<nums[j-1]){
                    d=nums[j];
                    nums[j]=nums[j-1];
                    nums[j-1]=d;
                    stat=true;
                }
            }
            if(!stat){
                break;
            }
        }
        stat=false;
        for(int i=0;i<nums.length;i++){
            if(!stat && nums[i]!=c[i]){
                a=i;
                stat=true;
            }
            else if(stat && nums[i]!=c[i]){
                b=i;
            }
        }
        if(a==-1){
            return 0;
        }
        b=b-a+1;
        return b;
    }
}