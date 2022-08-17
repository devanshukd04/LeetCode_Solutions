class Solution {
    public String minWindow(String s, String t) {
        int a=0;
        int b=0;
        int ans=Integer.MAX_VALUE;
        int a1=0;
        int a2=0;
        HashMap<Character,Integer> map=new HashMap<Character,Integer>();
        HashSet<Character> set=new HashSet<Character>();
        for(int i=0;i<t.length();i++){
            map.put(t.charAt(i),map.getOrDefault(t.charAt(i),0)+1);
            set.add(t.charAt(i));
        }
        if(map.getOrDefault(s.charAt(0),0)!=0){
            if(map.getOrDefault(s.charAt(0),0)==1){
                map.remove(s.charAt(0));
            }
            else{
                map.put(s.charAt(0),map.get(s.charAt(0))-1);
            }
        }
        while(a<=b && b<s.length()){
            boolean flag=true;
            for(int value:map.values()){
                if(value>0){
                    flag=false;
                    break;
                }
            }
            if(flag){
                if(ans>(b-a+1)){
                    ans=b-a+1;
                    a1=a;
                    a2=b+1;
                }
                if(set.contains(s.charAt(a))){
                    map.put(s.charAt(a),map.getOrDefault(s.charAt(a),0)+1);
                }
                a++;
            }
            else{
                b++;
                if(b!=s.length() && set.contains(s.charAt(b))){
                    int freq=map.getOrDefault(s.charAt(b),0);
                    map.put(s.charAt(b),freq-1);
                }
            }
        }
        if(a1==0 && a2==0){
            return "";
        }
        return s.substring(a1,a2);
    }
    public boolean checkEqual(String a, HashMap<Character,Integer> map){
        HashMap<Character,Integer> map1=new HashMap<Character,Integer>();
        map1.putAll(map);
        for(int i=0;i<a.length();i++){
            int freq=map1.getOrDefault(a.charAt(i),0);
            if(freq>1){
                map1.put(a.charAt(i),freq-1);
            }
            else if(freq==1){
                map1.remove(a.charAt(i));
            }
        }
        if(map1.size()==0){
            return true;
        }
        return false;
    }
}