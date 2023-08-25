class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int[][][] dp=new int[s1.length()+1][s2.length()+1][s3.length()+1];
        for(int[][] arr1:dp){
            for(int[] arr2:arr1){
                Arrays.fill(arr2,-1);
            }
        }
        return(helper(dp,s1,0,s2,0,s3,0));
    }
    public boolean helper(int[][][] dp,String s1, int index1, String s2, int index2, String s3, int index3){
        if(index3==s3.length() && (index1<s1.length() || index2<s2.length())){
            return false;
        }
        if(index3==s3.length() && index1==s1.length() && index2==s2.length()){
            return true;
        }
        if(dp[index1][index2][index3]!=-1){
            return dp[index1][index2][index3]==1?true:false;
        }
        boolean ans=false;
        if(index1<s1.length() &&  s1.charAt(index1)==s3.charAt(index3)){
            ans|=helper(dp,s1,index1+1,s2,index2,s3,index3+1);
        }
        if(ans){
            dp[index1][index2][index3]=1;
            return ans;
        }
        if(index2<s2.length() &&  s2.charAt(index2)==s3.charAt(index3)){
            ans|=helper(dp,s1,index1,s2,index2+1,s3,index3+1);
        }
        dp[index1][index2][index3]=ans?1:0;
        return ans;
    }
}