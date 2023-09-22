class Solution {
    public boolean isSubsequence(String s, String t) {
        int index1=0;
        int index2=0;
        while(index1<s.length() && index2<t.length()){
            if(s.charAt(index1)==t.charAt(index2)){
                index1++;
            }
            index2++;
        }
        if(index1==s.length()){
            return true;
        }
        return false;
    }
}