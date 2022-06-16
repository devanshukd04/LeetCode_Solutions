class Solution {
    public String longestPalindrome(String s) {
        int n=s.length();
        int a=0;
        int b=0;
        boolean[][] c=new boolean[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;i+j<n;j++){
                c[j][i+j]=s.charAt(j)==s.charAt(i+j) && (i<2 || c[j+1][i+j-1]);
                if(c[j][i+j] && i>b-a){
                    a=j;
                    b=i+j;
                }
            }
        }
        return s.substring(a,b+1);
    }
}