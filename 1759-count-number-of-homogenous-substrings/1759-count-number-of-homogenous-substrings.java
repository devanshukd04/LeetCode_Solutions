class Solution {
    public int countHomogenous(String s) {
        
        int ans=0;
        int mod=(int)1e9+7;
        int prev='a'-1;
        int freq=0;
        for(int i=0;i<s.length();i++){
            int curr=s.charAt(i)-'a';
            if(prev==curr){
                freq++;
                ans=(ans+freq)%mod;
            }
            else{
                freq=1;
                ans=(ans+freq)%mod;
            }
            prev=curr;
        }
        return ans;
    }
}