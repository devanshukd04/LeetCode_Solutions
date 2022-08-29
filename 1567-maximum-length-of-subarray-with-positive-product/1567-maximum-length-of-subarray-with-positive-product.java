class Solution {
    public int getMaxLen(int[] nums) {
        int res=0;
        int ans=0;
        int negIndex=-1;
        int[] a=new int[nums.length];
        if(nums.length==0){
            return 0;
        }
        a[0]=nums[0];
        if(nums.length==1){
            return nums[0]<=0?0:1;
        }
        if(nums[0]==0){
            a[0]=1;
            ans=0;
            negIndex=-1;
        }
        else{
            ans++;
        }
        if(nums[0]<0){
            negIndex=1;
            a[0]=-1;
        }
        if(a[0]>0){
            a[0]=1;
            res=Math.max(res,ans);
        }
        for(int i=1;i<nums.length;i++){
            int cur=nums[i]<0?-1:1;
            if(nums[i]==0){
                cur=0;
            }
            a[i]=cur*a[i-1];
            ans++;
            if(a[i]>0){
                res=Math.max(res,ans);
            }
            if(a[i]<0){
                if(negIndex==-1){
                    negIndex=ans;
                }
                else{
                    res=Math.max(res,ans-negIndex);
                }
            }
            if(a[i]==0){
                ans=0;
                negIndex=-1;
                a[i]=1;
            }
        }
        return res;
    }
}