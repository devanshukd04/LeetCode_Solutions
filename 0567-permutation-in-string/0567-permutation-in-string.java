class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length()==0){
            return true;
        }
        else if(s2.length()==0 || s1.length()>s2.length()){
            return false;
        }
        HashMap<Character,Integer> map1=new HashMap<Character,Integer>();
        HashMap<Character,Integer> map2=new HashMap<Character,Integer>();
        for(int i=0;i<s1.length();i++){
            map1.put(s1.charAt(i),map1.getOrDefault(s1.charAt(i),0)+1);
        }
        int i=0;
        int j=0;
        while(i<=j && j<s2.length() && j<s2.length()){
            while(j<s2.length() && (j-i+1)<=s1.length()){
                map2.put(s2.charAt(j),map2.getOrDefault(s2.charAt(j),0)+1);
                j++;
            }
            if(map1.equals(map2)){
                return true;
            }
            map2.put(s2.charAt(i),map2.getOrDefault(s2.charAt(i),0)-1);
            if(map2.get(s2.charAt(i))==0){
                map2.remove(s2.charAt(i));
            }
            i++;
        }
        return false;
    }
}