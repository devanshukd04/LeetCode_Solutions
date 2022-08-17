class Solution {
    public int uniqueMorseRepresentations(String[] words) {
        String[] code=new String[]{".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        HashSet<String> set=new HashSet<String>();
        for(int i=0;i<words.length;i++){
            StringBuffer res=new StringBuffer();
            for(int j=0;j<words[i].length();j++){
                int ch=words[i].charAt(j)-'a';
                res.append(code[ch]);
            }   
            set.add(res.toString());
        }
        return set.size();
    }
}