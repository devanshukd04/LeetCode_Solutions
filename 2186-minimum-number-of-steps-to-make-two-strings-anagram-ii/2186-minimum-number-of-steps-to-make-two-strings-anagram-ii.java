class Solution {
    public int minSteps(String s, String t) {
        int a;
        int count=0;
        char [] a1={'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
        HashMap<Character,Integer> map1=new HashMap<Character,Integer>();
        HashMap<Character,Integer> map2=new HashMap<Character,Integer>();
        for(int i=0;i<s.length();i++){
            if(map1.containsKey(s.charAt(i))){
                a=map1.get(s.charAt(i));
                map1.put(s.charAt(i),a+1);
            }
            else{
                map1.put(s.charAt(i),1);
            }
        }
        for(int i=0;i<t.length();i++){
            if(map2.containsKey(t.charAt(i))){
                a=map2.get(t.charAt(i));
                map2.put(t.charAt(i),a+1);
            }
            else{
                map2.put(t.charAt(i),1);
            }
        }
        if(map1.equals(map2)){
            return 0;   
        }
        for(int i=0;i<a1.length;i++){
            if(map1.get(a1[i])==null && map2.get(a1[i])==null){
                count+=0;
            }
            else if(map1.get(a1[i])==null && !(map2.get(a1[i])==null)){
                count+=map2.get(a1[i]);
            }
            else if(!(map1.get(a1[i])==null) && map2.get(a1[i])==null){
                count+=map1.get(a1[i]);
            }
            else if(map1.get(a1[i])>map2.get(a1[i])){
                count+=map1.get(a1[i])-map2.get(a1[i]);
            }
            else{
                count+=map2.get(a1[i])-map1.get(a1[i]);
            }
        }
        return count;
    }
}