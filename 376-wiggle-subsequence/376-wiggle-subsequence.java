class Solution {
    public int wiggleMaxLength(int[] nums) {
        int i=1;
        int a=-1;
        int sum=1;
        boolean flag=true;
        boolean flag1=true;
        while(i<nums.length){
            if(a==-1){
                if(nums[i]-nums[i-1]!=0){
                    if(nums[i]-nums[i-1]<0){
                        flag=true;
                    }
                    else if(nums[i]-nums[i-1]>0){
                        flag=false;
                    }
                    sum=2;
                    a=0;
                }
                i++;
            }
            else{
                if(flag && (nums[i]-nums[i-1])>0){
                    flag=!flag;
                    sum++;
                }
                else if(!flag && (nums[i]-nums[i-1])<0){
                    flag=!flag;
                    sum++;
                }
                i++;   
            }
        }
        return sum;
    }
}