class Solution {
    public int[] smallestTrimmedNumbers(String[] nums, int[][] queries) {
        int[] ans=new int[queries.length];
        for(int i=0;i<queries.length;i++){
            int index=queries[i][0];
            int trim=queries[i][1];
            int sindex=nums[0].length()-trim;
            PriorityQueue<Integer> queue=new PriorityQueue<Integer>((a,b)->{
                for(int j=sindex;j<nums[a].length();j++){
                    if(nums[a].charAt(j)!=nums[b].charAt(j)){
                        return nums[b].charAt(j)-nums[a].charAt(j);
                    }
                }
                return b-a;
            });                                                     
                                                                
            for(int j=0;j<nums.length;j++){
               queue.add(j);
                if(queue.size()>index){
                    queue.poll();
                }
            }
            ans[i]=queue.poll();
        }
        return ans;
    }
}