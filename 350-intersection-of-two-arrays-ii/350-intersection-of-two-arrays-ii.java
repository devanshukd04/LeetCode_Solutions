class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        ArrayList<Integer> arr= new ArrayList<Integer>();
        int i=0;
        boolean stat=true;
        int j=0;
        int a=0;
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        while(i<nums1.length){
            stat=true;
            while(j<nums2.length){
                if(nums1[i]==nums2[j]){
                    arr.add(nums1[i]);
                    stat=false;
                    a=j;
                    break;
                }
                j++;
            }
            i++;
            if(stat){
                j=a;
            }
            else{
                j=a+1;
                a=j;
            }
        }
        int[] num=new int[arr.size()];
        for(int k=0;k<arr.size();k++){
            num[k]=arr.get(k);
}
        return num;
    }
}