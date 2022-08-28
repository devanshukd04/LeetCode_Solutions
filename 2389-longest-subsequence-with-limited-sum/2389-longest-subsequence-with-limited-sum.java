class Solution {
    public int[] answerQueries(int[] nums, int[] queries) {
        int[] ans=new int[queries.length];
        if(nums.length==0){
            return ans;
        }
        Arrays.sort(nums);
        int[] sumarray=new int[nums.length];   
        sumarray[0]=nums[0];
        for(int i=1;i<nums.length;i++){
            sumarray[i]=nums[i]+sumarray[i-1];
        }
        for(int i=0;i<queries.length;i++){
            int start=0;
            int end=sumarray.length-1;
            while(start<=end){
                int mid=start+(end-start)/2;
                if(sumarray[mid]==queries[i]){
                    ans[i]=mid+1;
                    break;
                }
                else if(sumarray[mid]>queries[i]){
                    end=mid-1;
                }
                else{
                    ans[i]=mid+1;
                    start=mid+1;
                }
            }
        }
        return ans;
    }
}