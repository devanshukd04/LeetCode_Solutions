class Solution {
    public long minimumMoney(int[][] transactions) {
        long max=0;
        long res=0;
        for(int[] arr:transactions){
            max=Math.max(max,Math.min(arr[0],arr[1]));
            res+=Math.max(arr[0]-arr[1],0);
        }
        return res+max;
    }
}