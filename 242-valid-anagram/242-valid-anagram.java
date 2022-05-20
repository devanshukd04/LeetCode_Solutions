class Solution {
    public boolean isAnagram(String s, String t) {
        char a;
        int b=s.length()>t.length()?s.length():t.length();
        String c=s.length()>t.length()?s:t;
        HashMap<Character,Integer> ht=new HashMap<>();
        HashMap<Character,Integer> ht1=new HashMap<>();
        for(int i=0;i<s.length();i++){
            if(ht.containsKey(s.charAt(i))){
                ht.put(s.charAt(i),ht.get(s.charAt(i))+1);  
            }
            else{
             ht.put(s.charAt(i),1);      
             }
        }
        for(int i=0;i<t.length();i++){
            if(ht1.containsKey(t.charAt(i))){
                ht1.put(t.charAt(i),ht1.get(t.charAt(i))+1);  
            }
            else{
             ht1.put(t.charAt(i),1);      
             }
        }
        
        for(int i=0;i<b;i++){
           a=c.charAt(i);
            if((ht.get(a)==null) || (ht1.get(a)==null)){
                return false;
            }
            else{
                if(!(ht.get(a).equals(ht1.get(a)))){
                    return false;
                }
            }
        }
        return true;
    }
}