class Solution {
    public int wiggleMaxLength(int[] nums) {
        int i=1;
        int a=-1;
        int sum=1;
        boolean flag=true;
        boolean flag1=true;
        while(i<nums.length){
            if(a==-1){
                if(nums[i]-nums[i-1]!=0){
                    if(nums[i]-nums[i-1]<0){
                        flag=true;
                    }
                    else if(nums[i]-nums[i-1]>0){
                        flag=false;
                    }
                    sum=2;
                    a=0;
                }
                i++;
            }
            else{
                if(flag && (nums[i]-nums[i-1])>0){
                    flag=!flag;
                    sum++;
                }
                else if(!flag && (nums[i]-nums[i-1])<0){
                    flag=!flag;
                    sum++;
                }
                i++;   
            }
        }
        return sum;
    }
}

//Memoization
// class Solution {
//     public int wiggleMaxLength(int[] nums) {
//         int ans=0;
//         int[][] dp=new int[nums.length][nums.length+1];
//         for(int[] arr:dp){
//             Arrays.fill(arr,-1);
//         }
//         for(int i=0;i<nums.length;i++){
//             int res=helper(nums,dp,i,0);
//             ans=Math.max(ans,res);
//         }
//         return ans+1;
//     }
//     public int helper(int[] nums,int[][] dp,int i,int prev){
//         if(i==nums.length-1){
//             return 0;
//         }
//         if(dp[i][prev+1]!=-1){
//             return dp[i][prev+1];
//         }
//         if(prev==0){
//             if(nums[i+1]-nums[i]==0){
//                 return 0;
//             }
//             prev=nums[i+1]-nums[i]>0?-1:1;
//             return dp[i][prev+1]=1+helper(nums,dp,i+1,prev);
//         }
//         else if(prev==-1 && nums[i+1]-nums[i]<0){
//             return dp[i][prev+1]=1+helper(nums,dp,i+1,1);
//         }
//         else if(prev==1 && nums[i+1]-nums[i]>0){
//             return dp[i][prev+1]=1+helper(nums,dp,i+1,-1);
//         }
//         return dp[i][prev+1]=helper(nums,dp,i+1,prev);
//     }
// }
