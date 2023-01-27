class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int i=0;
        int index1=0;
        int index2=0;
        boolean flag=true;
        if((nums1.length+nums2.length)%2==0){
            flag=false;
        }
        int size=(nums1.length+nums2.length)/2+1;
        int prev=i;
        while(index1<nums1.length && index2<nums2.length){
            int temp;
            if(nums1[index1]<nums2[index2]){
                temp=nums1[index1++];
            }
            else{
                temp=nums2[index2++];
            }
            i++;
            if(!flag && size==i){
                return ((double)temp+(double)prev)/2;
            }
            else if(flag && size==i){
                return (double)temp;
            }
            prev=temp;
        }
        while(index1<nums1.length){
            i++;
            if(!flag && size==i){
                return ((double)nums1[index1]+(double)prev)/2;
            }
            else if(flag && size==i){
                return nums1[index1];
            }
            prev=nums1[index1++];
        }
        while(index2<nums2.length){
            i++;
            if(!flag && size==i){
                return ((double)nums2[index2]+(double)prev)/2;
            }
            else if(flag && size==i){
                return nums2[index2];
            }
            prev=nums2[index2++];
        }
        return -1;
    }
}