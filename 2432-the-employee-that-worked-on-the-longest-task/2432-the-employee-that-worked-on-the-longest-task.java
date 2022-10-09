class Solution {
    public int hardestWorker(int n, int[][] logs) {
        int prev=0;
        int ans=0;
        int prevDiff=0;
        for(int i=0;i<logs.length;i++){
            int diff=logs[i][1]-prev;
            prev=logs[i][1];
            if(diff>prevDiff){
                prevDiff=diff;
                ans=logs[i][0];
            }
            else if(diff==prevDiff){
                ans=ans<logs[i][0]?ans:logs[i][0];
            }
        }
        return ans;
    }
}