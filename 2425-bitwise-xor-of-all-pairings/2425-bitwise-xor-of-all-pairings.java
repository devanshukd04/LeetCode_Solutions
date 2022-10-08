class Solution {
    public int xorAllNums(int[] nums1, int[] nums2) {
        int ans=0;
        boolean flag1=true;
        boolean flag2=true;
        for(int i=1;i<nums1.length;i++){
            if(nums1[i]!=nums1[i-1]){
                flag1=false;
            }
        }
        for(int i=1;i<nums2.length;i++){
            if(nums2[i]!=nums2[i-1]){
                flag2=false;
            }
        }
        if(flag1 && flag2){
            int a=nums1.length%2==0?0:nums1[0];
            int b=nums2.length%2==0?0:nums2[0];
            return a^b;
        }
        for(int i=0;i<nums1.length;i++){
            for(int j=0;j<nums2.length;j++){
                ans^=(nums1[i]^nums2[j]);
            }
        }
        return ans;
    }
}