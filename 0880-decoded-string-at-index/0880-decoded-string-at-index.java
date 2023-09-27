class Solution {
    public String decodeAtIndex(String s, int k) {
        long length=0;
        int index=0;
        while(length<k){
            if(Character.isDigit(s.charAt(index))) {
                length*=s.charAt(index)-'0';
            } 
            else{
                length++;
            }
            index++;
        }
        for(int i=index-1;i>=0;i--){
            if(Character.isDigit(s.charAt(i))) {
                length/=s.charAt(i)-'0';
                k%=length;
            } 
            else{
                if(k==0 || k==length){
                    return Character.toString(s.charAt(i));
                }
                length--;
            }
        }
        return "";
    }
}