class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] sarray=s.split(" ");
        HashMap<Character,String> a=new HashMap<Character,String>();
        if(pattern.length()!=sarray.length){
            return false;
        }
        for(int i=0;i<pattern.length();i++){
            if(a.containsKey(pattern.charAt(i))){
                if(!(a.get(pattern.charAt(i)).equals(sarray[i]))){
                    return false;
                }
            }
            else if(a.containsValue(sarray[i])){
                return false;
            }
            else{
                a.put(pattern.charAt(i),sarray[i]);
            }
        }
        return true;
    }
}