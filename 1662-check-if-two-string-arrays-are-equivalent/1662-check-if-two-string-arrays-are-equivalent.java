class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        StringBuffer sb1=new StringBuffer();
        StringBuffer sb2=new StringBuffer();
        for(int i=0;i<word1.length;i++){
            for(int j=0;j<word1[i].length();j++){
                sb1.append(word1[i].charAt(j));
            }
        }
        for(int i=0;i<word2.length;i++){
            for(int j=0;j<word2[i].length();j++){
                sb2.append(word2[i].charAt(j));
            }
        }
        if(sb1.toString().equals(sb2.toString())){
            return true;
        }
        return false;
    }
}