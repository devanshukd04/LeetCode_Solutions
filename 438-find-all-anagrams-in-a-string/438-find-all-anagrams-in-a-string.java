class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        ArrayList<Integer> list=new ArrayList<Integer>();
        HashMap<Character,Integer> ht=new HashMap<>();
        HashMap<Character,Integer> ht1=new HashMap<>();
        if(s.length()<p.length()){
            return list;
        }
        for(int i=0;i<p.length();i++){
            if(ht.containsKey(p.charAt(i))){
                ht.put(p.charAt(i),ht.get(p.charAt(i))+1);  
            }
            else{
             ht.put(p.charAt(i),1);      
             }
        }
        for(int i=0;i<p.length();i++){
            if(ht1.containsKey(s.charAt(i))){
                ht1.put(s.charAt(i),ht1.get(s.charAt(i))+1);  
            }
            else{
             ht1.put(s.charAt(i),1);      
             }
        }
        if(ht.equals(ht1)){
                list.add(0);
            }
        for (int i=p.length();i<s.length();i++){
            ht1.put(s.charAt(i-p.length()),ht1.get(s.charAt(i-p.length()))-1); 
            if(ht1.get(s.charAt(i-p.length()))==0){
                ht1.remove(s.charAt(i-p.length()));
            }
            if(ht1.containsKey(s.charAt(i))){
                ht1.put(s.charAt(i),ht1.get(s.charAt(i))+1);  
            }
            else{
                ht1.put(s.charAt(i),1);      
             }
            if(ht.equals(ht1)){
                list.add(i-p.length()+1);
            }
        }
        return list;
    }
}