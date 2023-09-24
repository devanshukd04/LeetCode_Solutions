class Solution {
    public String maximumOddBinaryNumber(String s) {
        int count=0;
        
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='1'){
                count++;
            }
        }
        
        StringBuilder ans=new StringBuilder();
        
        for(int i=0;i<s.length()-1;i++){
            if(count>1){
                ans.append('1');
                count--;
            }
            else{
                ans.append('0');
            }
        }
        ans.append('1');
        return ans.toString();
    }
}