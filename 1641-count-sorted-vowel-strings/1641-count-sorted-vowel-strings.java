//Dynamic Programming
class Solution {
    public int countVowelStrings(int n) {
        int[][] dp=new int[n][5];
        int ans=0;
        for(int i=0;i<5;i++){
            dp[n-1][i]=1;
        }
        for(int i=n-2;i>=0;i--){
            for(int j=0;j<5;j++){
                if(j==0){
                    dp[i][j]=dp[i+1][0]+dp[i+1][1]+dp[i+1][2]+dp[i+1][3]+dp[i+1][4];
                }
                else if(j==1){
                    dp[i][j]=dp[i+1][1]+dp[i+1][2]+dp[i+1][3]+dp[i+1][4];
                }
                else if(j==2){
                    dp[i][j]=dp[i+1][2]+dp[i+1][3]+dp[i+1][4];
                }
                else if(j==3){
                    dp[i][j]=dp[i+1][3]+dp[i+1][4];
                }
                else{
                    dp[i][j]=dp[i+1][4];
                }
            }
        }
        for(int j=0;j<5;j++){
            ans+=dp[0][j];
        }
        return ans;
    }
}


//Recursive Approach
// class Solution {
//     int count1=0;
//     public int countVowelStrings(int n) {
//         String[] b=new String[]{"a","e","i","o","u"};
//         StringBuilder a=new StringBuilder();
//         count(b,n,a,0);
//         return count1;
//         }
//     public void count(String[] b,int n, StringBuilder a,int i){
//         if(i>4 && n!=0){
//             return;
//         }
//         if(n==0){
//             ++count1;
//             return;
//         }
//         count(b,n-1,a.append(b[i]),i);
//         count(b,n,a,i+1);
//     }
// }
