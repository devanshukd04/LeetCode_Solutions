class Solution {
    public long numberOfPairs(int[] nums1, int[] nums2, int diff) {
        int n=nums1.length;
        long[] nums=new long[n];
        for(int i=0;i<n;i++){
            nums[i]=nums1[i]-nums2[i];
        }
        long[] temp=Arrays.copyOf(nums,n);
        return sort(nums,temp,0,n-1,diff);
    }
    private long sort(long[] nums,long[] temp,int low,int high,int diff){
        if(low==high){
            return 0L;
        }
        int mid=low+(high-low)/2;
        long res=0L;
        res+=sort(nums,temp,low,mid,diff);
        res+=sort(nums,temp,mid+1,high,diff);
        res+=merge(nums,temp,low,mid,high,diff);
        return res;
    }
    private long merge(long[] nums,long[] temp,int low,int mid,int high,int diff){
        long res=0L;
        for(int i=low,j=mid+1;i<=mid && j<=high;i++){
            while(j<=high && nums[i]>nums[j]+diff){
                j++;
            }
            res+=high-j+1;
        }
        for(int i=low,j=mid+1,k=low;i<=mid || j<=high;k++){
            if(j>high || i<=mid && nums[i]<nums[j]){
                temp[k]=nums[i++];
            }
            else{
                temp[k]=nums[j++];
            }
        }
        System.arraycopy(temp,low,nums,low,high-low+1);
        return res;
    }
}