class Solution {
    public int prefixCount(String[] words, String pref) {
        int a=pref.length();
        int count=0;
        for(int i=0;i<words.length;i++){
            if(words[i].length()>=a && words[i].substring(0,a).equals(pref)){
                ++count;
            }
        }
        return count;
    }
}