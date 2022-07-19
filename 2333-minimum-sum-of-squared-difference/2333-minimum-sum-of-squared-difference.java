class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        if(nums1.length!=nums2.length){
            return 0;
        }
        long ans=0;
        HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
        int max=Integer.MIN_VALUE;
        for(int i=0;i<nums1.length;i++){
            int b=Math.abs(nums1[i]-nums2[i]);
            map.put(b,map.getOrDefault(b,0)+1);
            ans+=1L*b*b;
            max=max<b?b:max;
        }
        int j=max;
        int total=k1+k2;
        while(total>0 && j>0){
            if(map.getOrDefault(j,0)>0){
                int count=map.get(j);
                if(total>=count){
                    ans-=1L*count*((j*j)-((j-1)*(j-1)));
                    map.remove(j);
                    map.put(j-1,map.getOrDefault(j-1,0)+count);
                    total-=count;
                }
                else{
                    ans-=1L*total*((j*j)-((j-1)*(j-1)));
                    map.put(j-1,map.getOrDefault(j,0)-total);
                    map.put(j-1,map.getOrDefault(j-1,0)+total);
                    return ans;
                }
            }
            j--;
        }
        return ans;
    }
}