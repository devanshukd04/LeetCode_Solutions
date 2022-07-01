class Solution {
    public int strStr(String haystack, String needle) {
        boolean flag=false;
        for(int i=0;i<haystack.length()-needle.length()+1;i++){
            if(haystack.charAt(i)==needle.charAt(0)){
                flag=true;
                for(int j=i+1;j<i+needle.length();j++){
                    if(!(haystack.charAt(j)==needle.charAt(j-i))){
                        flag=false;
                    }
                }
                if(flag){
                    return i;
                }
            }
        }
        return -1;
    }
}