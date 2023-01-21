class Solution {
    public long minOperations(int[] nums1, int[] nums2, int k) {
        long ans=0; 
        long sum=0;
        if(k==0){
            for(int i=0;i<nums1.length;i++){
                if(nums1[i]-nums2[i]!=0){
                    return -1;
                }
            }
            return 0;
        }
        for(int i=0;i<nums1.length;i++){
            int diff=nums1[i]-nums2[i];
            if(diff==0){
                continue;
            }
            if(diff%k!=0){
                return -1;
            }
            ans+=Math.abs(diff)/k;
            sum+=diff;
        }
        if(sum!=0){
            return -1;
        }
        return ans/2;
    }
}