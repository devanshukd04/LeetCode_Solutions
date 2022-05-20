class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        char a;
        //int b=s.length()>t.length()?s.length():t.length();
        //String c=s.length()>t.length()?s:t;
        HashMap<Character,Integer> ht=new HashMap<>();
        HashMap<Character,Integer> ht1=new HashMap<>();
        for(int i=0;i<ransomNote.length();i++){
            if(ht.containsKey(ransomNote.charAt(i))){
                ht.put(ransomNote.charAt(i),ht.get(ransomNote.charAt(i))+1);  
            }
            else{
             ht.put(ransomNote.charAt(i),1);      
             }
        }
        for(int i=0;i<magazine.length();i++){
            if(ht1.containsKey(magazine.charAt(i))){
                ht1.put(magazine.charAt(i),ht1.get(magazine.charAt(i))+1);  
            }
            else{
             ht1.put(magazine.charAt(i),1);      
             }
        }
        for(int i=0;i<ransomNote.length();i++){
           a=ransomNote.charAt(i);
            if((ht.get(a)==null) || (ht1.get(a)==null)){
                return false;
            }
            else{
                if(!(ht.get(a)<=ht1.get(a))){
                    return false;
                }
            }
        }
        return true;
    }
}