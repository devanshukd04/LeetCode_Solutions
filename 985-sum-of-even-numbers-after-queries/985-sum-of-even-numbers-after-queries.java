class Solution {
    public int[] sumEvenAfterQueries(int[] nums, int[][] queries) {
        int[] ans=new int[queries.length];
        int sum=0;
        for(int num:nums){
            if(num%2==0){
                sum+=num;   
            }
        }
        int i=0;
        for(int[] query:queries){
            sum-=nums[query[1]]%2==0?nums[query[1]]:0;
            nums[query[1]]+=query[0];
            sum+=nums[query[1]]%2==0?nums[query[1]]:0;
            ans[i++]=sum;
        }
        return ans;
    }
}