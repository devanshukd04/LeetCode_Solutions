class Solution {
    public boolean winnerOfGame(String colors) {
        boolean flag=true;
        int freq=0;
        int turnA=0;
        int turnB=0;
        for(int i=0;i<colors.length();i++){
            char ch=colors.charAt(i);
            if(ch=='A' && flag){
                freq++;
            }
            else if(ch=='B' && !flag){
                freq++;
            }
            else{
                if(flag){
                    turnA+=(freq-2>0?freq-2:0);
                }
                else{
                    turnB+=(freq-2>0?freq-2:0);
                }
                freq=1;
                flag=ch=='A'?true:false;
            }
        }
        if(flag){
            turnA+=freq-2>0?freq-2:0;
        }
        else{
            turnB+=freq-2>0?freq-2:0;
        }
        
        return turnA<=turnB?false:true;
    }
}