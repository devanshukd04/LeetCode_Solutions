class Solution {
    public int findPairs(int[] nums, int k) {
        int count=0;
        String b;
        Set<String> Set = new HashSet<String>();
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                int a=nums[i]-nums[j];
                if((a==k && !Set.contains(Integer.toString(nums[i])+Integer.toString(nums[j])))){
                    b=Integer.toString(nums[i])+Integer.toString(nums[j]);
                    Set.add(b);
                    b=Integer.toString(nums[j])+Integer.toString(nums[i]);
                    Set.add(b);
                    count++;  
                }
                else if(a<0 && (a-2*a)==k && !Set.contains(Integer.toString(nums[j])+Integer.toString(nums[i]))){
                    b=Integer.toString(nums[i])+Integer.toString(nums[j]);
                    Set.add(b);
                    b=Integer.toString(nums[j])+Integer.toString(nums[i]);
                    Set.add(b);
                    count++;
                }
        }
        }
        return count;
    }
}