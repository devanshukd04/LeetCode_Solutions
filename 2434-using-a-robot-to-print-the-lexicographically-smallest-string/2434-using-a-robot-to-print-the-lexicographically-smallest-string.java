class Solution {
    public String robotWithString(String s) {
        StringBuffer ans=new StringBuffer();
        StringBuffer s1=new StringBuffer(s);
        StringBuffer t=new StringBuffer();
        HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
        TreeSet<Integer> set=new TreeSet<Integer>();
        for(int i=0;i<s.length();i++){
            set.add(s.charAt(i)-'a');
            map.put(s.charAt(i)-'a',map.getOrDefault(s.charAt(i)-'a',0)+1);
        }
        while(true){
            if(s1.length()>0){
                t.append(s1.charAt(0));
                s1.deleteCharAt(0);   
                int freq=map.get(t.charAt(t.length()-1)-'a');
                if(freq-1==0){
                    map.remove(t.charAt(t.length()-1)-'a');
                    set.remove(t.charAt(t.length()-1)-'a');
                }
                else{
                    map.put(t.charAt(t.length()-1)-'a',freq-1);
                }
            }
            while(t.length()>0){
                if(s1.length()==0 || t.charAt(t.length()-1)-'a'<=set.first()){
                    ans.append(t.charAt(t.length()-1));
                    t.deleteCharAt(t.length()-1);
                }
                else{
                    break;
                }
            }
            if(s1.length()==0 && t.length()==0){
                break;
            }
        }
        return ans.toString();
    }
}