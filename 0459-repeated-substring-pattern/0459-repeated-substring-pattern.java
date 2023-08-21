class Solution {
    public boolean repeatedSubstringPattern(String s) {
        int length=s.length();
        for(int i=1;i<=length/2;i++){
            if(length%(i)==0){
                String subStr=s.substring(0,i);
                StringBuilder sb=new StringBuilder();
                for(int j=0;j<length;j+=i){
                    sb.append(subStr);
                }
                if(sb.toString().equals(s)){
                    return true;
                }
            }
        }
        return false;
    }
}