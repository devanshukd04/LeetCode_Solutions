class Solution {
    public char findTheDifference(String s, String t) {
        Map<Character,Integer> map=new HashMap<>();
        
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        
        for(int i=0;i<t.length();i++){
            char ch=t.charAt(i);
            if(!map.containsKey(ch) || map.get(ch)<1){
                return ch;
            }
            map.put(ch,map.get(ch)-1);
        }
        return 'a';
    }
}