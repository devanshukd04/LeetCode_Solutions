class Solution {
    public long minimumMoney(int[][] transactions) {
        long max=0;
        long ans=0;
        long buffer=0;
        Arrays.sort(transactions,(int[] a,int[] b)->(a[1]-b[1]));
        for(int[] arr:transactions){
            if(arr[0]>arr[1]){
                max+=arr[0];
                ans=Math.max(ans,max);
                max-=arr[1];
            }
            else{
                buffer=Math.max(buffer,arr[0]);
            }
        }
        ans=Math.max(ans,max+buffer);
        return ans; 
    }
}