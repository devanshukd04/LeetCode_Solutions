class Solution {
    HashMap<String,Integer> d=new HashMap<String,Integer>();
    int count=0;
    public int countSubstrings(String s) {
        boolean c;
        String d1;
        StringBuffer b=new StringBuffer("");
        d.put("",0);
        for(int i=0;i<s.length();i++){
            for(int j=i;j<s.length();j++){
                d1=s.substring(i,j+1);
                if(d.containsKey(d1)){
                    if(d.get(d1)==1){
                        ++count;
                    }
                }
                else{
                    c=checkPalindromes(d1,0);
                    if(c){
                        ++count;
                        d.put(d1,1);
                    }
                    else{
                        d.put(d1,0);
                    }
                }
            }
        }
        return count;
    }
    public boolean checkPalindromes(String a2,int i){
        boolean e;
        if(d.containsKey(a2)){
            
        }
        if(i<a2.length()-i-1){
            if(a2.charAt(i)==a2.charAt(a2.length()-i-1)){
                e=checkPalindromes(a2,i+1);
                if(e){
                    d.put(a2,1);
                    return true;
                }
                else{
                    d.put(a2,0);
                    return false;
                }
            }
            else{
                d.put(a2,0);
                return false;
            }
        }
        else{
            d.put(a2,1);
            return true;
        }
    }
}