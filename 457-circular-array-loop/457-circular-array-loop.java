class Solution {
    public boolean circularArrayLoop(int[] nums) {
        int i=0;
        while(i<nums.length){      
            int a;
            int c;
            boolean flag;
            boolean flag1=true;
            if(nums[i]>0){
                a=(i+nums[i])%nums.length;
                flag=true;
            }
            else{
                c=nums[i]/nums.length;
                c=nums.length*(-c)+nums[i];
                a=(nums.length+i+c)%nums.length;
                flag=false;
            }
            int b=1;
            boolean[] stat=new boolean[nums.length];
            stat[i]=true;
            while(a!=i && !stat[a]){
                stat[a]=true;
                if(flag && nums[a]>0){
                    a=(a+nums[a])%nums.length;
                }
                else if(!flag && nums[a]<0){
                    c=nums[a]/nums.length;
                    c=nums.length*(-c)+nums[a];
                    a=(nums.length+a+c)%nums.length;
                }
                else{
                    stat[a]=false;
                    flag1=false;
                    break;
                }
                ++b;
            }
            if(b>1 && flag1){
                if(i==a){
                    return true;   
                }
                else{
                    stat[a]=false;
                }
            }            
            ++i;
        }
        return false;
    }
}