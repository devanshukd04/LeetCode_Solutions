class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] a=new int[n];
        int[] b=new int[n];
        for(int i=0;i<trust.length;i++){
            a[trust[i][0]-1]=1;
            ++b[trust[i][1]-1];
        }
        for(int i=0;i<a.length;i++){
            if(a[i]==0 && b[i]==n-1){
                return i+1;
            }
        }
        return -1;
    }
}