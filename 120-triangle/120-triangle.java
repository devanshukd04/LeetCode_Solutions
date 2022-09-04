class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int a=triangle.size();
        if(a==1){
            return triangle.get(0).get(0);
        }
        int b[]=new int[a+1];
        for(int i=a-1;i>=0;i--){
            int c=triangle.get(i).size();
            for(int j=0;j<c;j++){
                b[j]=Math.min(b[j],b[j+1])+triangle.get(i).get(j);
            }
        }
        return b[0];
    }
}

//Dynamic Programming

// class Solution {
//     public int minimumTotal(List<List<Integer>> triangle) {
//         int[][] dp=new int[triangle.size()][triangle.get(triangle.size()-1).size()];
//         int[][] visited=new int[triangle.size()][triangle.get(triangle.size()-1).size()];
//         for(int i=0;i<dp.length;i++){
//             Arrays.fill(dp[i],-1);
//         }
//         return helper(triangle,0,0,dp,visited);
//     }
//     public int helper(List<List<Integer>> triangle,int i,int j,int[][] dp,int[][] visited){
//         if(visited[i][j]!=0){
//             return dp[i][j];
//         }
//         visited[i][j]=1;
//         if(i<triangle.size()-1){
//             int a=helper(triangle,i+1,j,dp,visited);
//             int b=helper(triangle,i+1,j+1,dp,visited);
//             return dp[i][j]=triangle.get(i).get(j)+Math.min(a,b);
//         }
//         else{
//             return dp[i][j]=triangle.get(i).get(j);
//         }
//     }
// }
