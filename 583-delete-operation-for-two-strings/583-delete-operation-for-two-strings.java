class Solution {
    public int minDistance(String word1, String word2) {
        int[][] a=new int[word1.length()+1][word2.length()+1];
        return word1.length()+word2.length()-2*lcs(word1,word2,word1.length(),word2.length(),a);
    }
    public int lcs(String word1, String word2, int m, int n, int[][] a){
        if(m==0 || n==0){
            return 0;
        }
        if(a[m][n]>0){
            return a[m][n];
        }
        if(word1.charAt(m-1)==word2.charAt(n-1)){
            a[m][n]=1+lcs(word1,word2,m-1,n-1,a);
        }
        else{
            a[m][n]=Math.max(lcs(word1,word2,m,n-1,a),lcs(word1,word2,m-1,n,a));
        }
        return a[m][n];
    }
}