class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length()+s2.length()!=s3.length()){
            return false;
        }
        int a[][] =new int[s1.length()][s2.length()];
        for(int i=0;i<s1.length();i++){
            for(int j=0;j<s2.length();j++){
                a[i][j]=-1;
            }
        }
        return possibleStrings(s1,0,s2,0,s3,0,a);
        
    }
    public boolean possibleStrings(String s1, int i, String s2, int j, String s3, int k, int[][] a){
        if(i==s1.length()){
            return s2.substring(j).equals(s3.substring(k));
        }
        if(j==s2.length()){
            return s1.substring(i).equals(s3.substring(k));
        }
        if(a[i][j]>=0){
            return a[i][j]==1?true:false;
        }
        boolean b=false;
        if(s3.charAt(k)==s1.charAt(i) && possibleStrings(s1,i+1,s2,j,s3,k+1,a) || s3.charAt(k)==s2.charAt(j) && possibleStrings(s1,i,s2,j+1,s3,k+1,a)){
            b=true;
        }
        a[i][j]=b?1:0;
        return b;
    }
}