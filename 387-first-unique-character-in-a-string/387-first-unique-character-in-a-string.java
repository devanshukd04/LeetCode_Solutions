class Solution {
    public int firstUniqChar(String s) {
        HashMap<Character,Integer> ht=new HashMap<>();
        for(int i=0;i<s.length();i++){
            if(ht.containsKey(s.charAt(i))){
                ht.put(s.charAt(i),ht.get(s.charAt(i))+1);  
            }
            else{
             ht.put(s.charAt(i),1);      
             }
        }
        for(int i=0;i<s.length();i++){
        if(ht.get(s.charAt(i))==1){
            return i;
        }
        }
        return -1;
    }
}