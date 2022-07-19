class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        if(nums1.length!=nums2.length){
            return 0;
        }
        long ans=0;
        int[] arr=new int[(int)1e5+1];
        HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
        int max=Integer.MIN_VALUE;
        for(int i=0;i<nums1.length;i++){
            int b=Math.abs(nums1[i]-nums2[i]);
            ++arr[b];
            ans+=1L*b*b;
            map.put(b,map.getOrDefault(b,0)+1);
            max=max<b?b:max;
        }
        int j=max;
        int total=k1+k2;
        while(total>0 && j>0){
            if(arr[j]>0){
                long count=arr[j];
                if(total>=count){
                    ans-=1L*count*((j*j)-((j-1)*(j-1)));
                    arr[j]=0;
                    arr[j-1]+=count;
                    total-=count;
                }
                else{
                    ans-=1L*total*((j*j)-((j-1)*(j-1)));
                    arr[j-1]+=total;
                    arr[j]-=total;
                    return (long)ans;
                }
            }
            j--;
        }
        return ans;
    }
}