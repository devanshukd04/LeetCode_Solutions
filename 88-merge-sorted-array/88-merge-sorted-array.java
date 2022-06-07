class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int a=0;
        int b=0;
        int c=m;
         if(nums2.length==0){
            return;
        }
        else if(m==0){
            for(int i=0;i<n;i++){
                nums1[i]=nums2[i];
            }
        }
        else{
        while(a<nums1.length && b<n){
            if(nums1[a]>nums2[b] || (nums2[b]==0 && nums1[a]==nums2[b]) || (nums1[a]==0 && a>=m)){
                nums1[m]=nums1[m-1];
                for(int i=m-1;i>a;i--){
                    nums1[i]=nums1[i-1];
                }
                nums1[a]=nums2[b];
                a++;
                b++;
                m++;
            }
            else if(nums1[a]<nums2[b]){
                a++;
}
            else{
                a++;
            }
        }
        }
    }
}