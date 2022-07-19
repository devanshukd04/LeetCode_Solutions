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
        int total=k1+k2;
        while(total>0 && max>0){
            if(map.getOrDefault(max,0)>0){
                int count=map.get(max);
                if(total>=count){
                    ans-=1L*count*((max*max)-((max-1)*(max-1)));
                    map.remove(max);
                    map.put(max-1,map.getOrDefault(max-1,0)+count);
                    total-=count;
                }
                else{
                    ans-=1L*total*((max*max)-((max-1)*(max-1)));
                    map.put(max-1,map.getOrDefault(max,0)-total);
                    map.put(max-1,map.getOrDefault(max-1,0)+total);
                    return ans;
                }
            }
            max--;
        }
        return ans;
    }
}