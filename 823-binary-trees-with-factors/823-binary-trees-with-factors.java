class Solution {
    public int numFactoredBinaryTrees(int[] arr) {
        int mod=(int)1e9+7;
        int length=arr.length;
        Arrays.sort(arr);
        long[] dp=new long[length];
        Arrays.fill(dp,1);
        
        HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
        for(int i=0;i<length;i++){
            map.put(arr[i],i);
        }
        
        for(int i=1;i<length;i++){
            for(int j=0;j<i;j++){
                if(arr[i]%arr[j]==0){
                    int right=arr[i]/arr[j];
                    if(map.containsKey(right)){
                        dp[i]=(dp[i]+dp[j]*dp[map.get(right)]);
                    }
                }
            }
        }
        long ans=0;
        for(long num:dp){
            ans=(ans+num)%mod;
        }
        return (int)ans;
    }
}