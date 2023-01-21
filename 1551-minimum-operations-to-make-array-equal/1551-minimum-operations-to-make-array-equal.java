class Solution {
    public int minOperations(int n) {
        int ans=0;
        for(int i=0;i<n/2;i++){
            ans+=((n-i-1)*2-(i)*2)/2;
        }
        return ans;
    }
}