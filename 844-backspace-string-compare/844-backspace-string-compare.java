class Solution {
    public boolean backspaceCompare(String s, String t) {
        List<String> a=new ArrayList<String>();
        String b,d,e;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='#'){
                if((a.size()-1)>=0){
                    a.remove(a.size()-1);   
                }
            }
            else{
                e=String.valueOf(s.charAt(i));
                a.add(e);
            }
        }
        StringBuilder c=new StringBuilder();
        for(int i=0;i<a.size();i++){
            e=a.get(i);
            c.append(e);
        }
        b=c.toString();
        List<String> f=new ArrayList<String>();
        c=new StringBuilder();;
        for(int i=0;i<t.length();i++){
            if(t.charAt(i)=='#'){
                if((f.size()-1)>=0){
                    f.remove(f.size()-1);   
                }
            }
            else{
                e=String.valueOf(t.charAt(i));
                f.add(e);
            }
        }
        for(int i=0;i<f.size();i++){
            e=f.get(i);
            c.append(e);
        }
        d=c.toString();
        if(b.equals(d)){
            return true;
        }
        return false;
    }
}