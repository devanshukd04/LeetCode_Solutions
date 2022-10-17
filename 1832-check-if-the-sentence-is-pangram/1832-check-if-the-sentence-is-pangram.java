class Solution {
    public boolean checkIfPangram(String sentence) {
        HashSet<Character> set=new HashSet<Character>();
        for(int i=0;i<26;i++){
            set.add((char)('a'+i));
        }
        for(int i=0;i<sentence.length();i++){
            char ch=sentence.charAt(i);
            if(set.contains(ch)){
                set.remove(ch);
            }
        }
        return set.size()==0?true:false;
    }
}