class Solution {
    public int countVowelSubstrings(String word) {
        int ans=0;
        boolean flag=false;
        HashSet<Character> set=new HashSet<Character>(Arrays.asList('a','e','i','o','u'));
        for(int i=0;i<word.length()-4;i++){
            HashSet<Character> set1=new HashSet<Character>();
            for(int j=i;j<word.length();j++){
                if(set.contains(word.charAt(j))){
                    set1.add(word.charAt(j));
                    if(set1.size()==5){
                        ans++;
                    }
                }
                else{
                    break;
                }
            }
        }
        return ans++;
    }
}