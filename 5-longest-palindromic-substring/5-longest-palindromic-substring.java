class Solution {
    public String longestPalindrome(String s) {
        // int n=s.length();
        // int a=0;
        // int b=0;
        // boolean[][] c=new boolean[n][n];
        // for(int i=0;i<n;i++){
        //     for(int j=0;i+j<n;j++){
        //         c[j][i+j]=s.charAt(j)==s.charAt(i+j) && (i<2 || c[j+1][i+j-1]);
        //         if(c[j][i+j] && j>b-a){
        //             a=j;
        //             b=i+j;
        //         }
        //     }
        // }
        // return s.substring(a,b+1);
        int n = s.length(), start = 0, end = 0;
        boolean[][] dp = new boolean[n][n];

        for (int len=0; len<n; len++) {
            for (int i=0; i+len<n; i++) {
                dp[i][i+len] = s.charAt(i) == s.charAt(i+len) && (len < 2 || dp[i+1][i+len-1]);
                if (dp[i][i+len] && len > end - start) {
                    start = i;
                    end = i + len;
                }
            }
        }

        return s.substring(start, end + 1);

    }
}