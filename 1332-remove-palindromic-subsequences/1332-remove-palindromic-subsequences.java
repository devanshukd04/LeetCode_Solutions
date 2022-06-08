class Solution {
    public int removePalindromeSub(String s) {
        int[] a=new int[2];
        for(int i=0;i<s.length()/2;i++){
            if(s.charAt(i)!=s.charAt(s.length()-i-1)){
                return 2;
            }
        }
        return 1;
    }
}