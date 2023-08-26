class Solution {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs,(a,b)->a[1]-b[1]);
        int ans=0;
        int prev=-1001;
        for(int i=0;i<pairs.length;i++){
            if(pairs[i][0]>prev){
                ans++;
                prev=pairs[i][1];
            }
        }
        return ans;
    }
}