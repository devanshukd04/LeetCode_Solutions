class Solution {
    public int minFlipsMonoIncr(String s) {
        int ans=s.length();
        int curr=0;
        int[] arr=new int[s.length()];
        if(s.charAt(s.length()-1)=='0'){
            arr[s.length()-1]+=1;
        }
        for(int i=s.length()-2;i>=0;i--){
            if(s.charAt(i)=='0'){
                arr[i]+=1;
            }
            arr[i]+=arr[i+1];
        }
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='1'){
                ans=Math.min(ans,curr+arr[i]);  
                curr++;
            }
        }
        ans=Math.min(ans,curr);
        return ans;
    }
}