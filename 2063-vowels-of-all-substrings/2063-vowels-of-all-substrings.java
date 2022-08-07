class Solution {
    public long countVowels(String word) {
        long ans=0;
        HashSet<Character> set=new HashSet<Character>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        int length=word.length();
        for(int i=0;i<word.length();i++){
            Character c=word.charAt(i);
            if(set.contains(c)){
                ans+=length-i+(long)(i)*(length-i);
            }
        }
        return ans;
    }
}