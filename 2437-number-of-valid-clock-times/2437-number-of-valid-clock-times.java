class Solution {
    public int countTime(String time) {
        int ans=1;
        if(time.charAt(0)!='?' && time.charAt(1)!='?' && time.charAt(3)!='?' && time.charAt(4)!='?'){
            return 1;
        }
        if(time.charAt(0)=='?'){
            if(time.charAt(1)=='?'){
                ans=24;
            }
            else{
                if(time.charAt(1)-'0'>4){
                    ans=2;
                }
                else if(time.charAt(1)=='4' && time.charAt(3)!='0' && time.charAt(4)!='0'){
                    ans=2;
                }
                else{
                    ans=3;
                }
            }
        }
        else if(time.charAt(1)=='?'){
            if(time.charAt(0)-'0'==2){
                ans=4;
            }
            else{
                ans=10;
            }
        }
        ans=ans==0?1:ans;
        if(time.charAt(3)=='?'){
            if(time.charAt(4)=='?'){
                ans*=60;   
            }
            else{
                ans*=6;
            }
        }
        else if(time.charAt(4)=='?'){
            if(time.charAt(3)-'0'==6){
                ans*=1;
            }
            else{
                ans*=10;
            }
        }
        return ans;
    }
}