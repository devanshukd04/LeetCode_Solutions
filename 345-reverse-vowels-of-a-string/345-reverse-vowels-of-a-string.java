class Solution {
    public String reverseVowels(String s) {
        List<Character> list=new ArrayList<Character>();
        HashSet<Character> set=new HashSet<Character>(Arrays.asList('a','e','i','o','u','A','E','I','O','U'));
        StringBuffer res=new StringBuffer();
        for(int i=0;i<s.length();i++){
            if(set.contains(s.charAt(i))){
                list.add(s.charAt(i));
            }
        }
        int j=list.size()-1;
        for(int i=0;i<s.length();i++){
            if(set.contains(s.charAt(i))){
                res.append(list.get(j));
                j--;
            }
            else{
                res.append(s.charAt(i));
            }
        }
        return res.toString();
    }
}