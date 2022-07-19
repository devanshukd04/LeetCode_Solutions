class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        long ans=0;
        //Creating a hashmap
        HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
        int max=Integer.MIN_VALUE;
        for(int i=0;i<nums1.length;i++){
            //Absolute difference between pair of values
            int b=Math.abs(nums1[i]-nums2[i]);
            //Updating the frequency of the absolute difference in hashmap
            map.put(b,map.getOrDefault(b,0)+1);
            //Adding the square of absolute difference to ans variable
            ans+=1L*b*b;
            //Updating the max value
            max=max<b?b:max;
        }
        //Taking sum of no. of modification allowed as modification could be made on any number among a pair of number
        int total=k1+k2;
        //While loop runs until no. of modifications left>0 and absoluediffernce>0
        while(total>0 && max>0){
            //Checking if map contains any frequency of that absolute differnce 
            if(map.getOrDefault(max,0)>0){
                int count=map.get(max);
                //If total>count, all frequency of that absolute difference could be reduced by 1
                if(total>=count){
                    //Updating ans variable
                    ans-=1L*count*((max*max)-((max-1)*(max-1)));
                    map.remove(max);
                    map.put(max-1,map.getOrDefault(max-1,0)+count);
                    total-=count;
                }
                //All frequency of abolute difference could not be reduce by 1 so reducing permitted frequency of abolute differnce by 1 and returning ans
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