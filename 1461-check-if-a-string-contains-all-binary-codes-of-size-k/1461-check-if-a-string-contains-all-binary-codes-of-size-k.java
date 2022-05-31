class Solution {
    public boolean hasAllCodes(String s, int k) {
        int a=1<<k;
        Set<String> c=new HashSet<String>();
        for(int i=k;i<=s.length();i++){
            String b=s.substring(i-k,i);
            if(!c.contains(b)){
                c.add(b);
                a--;
                if(a==0){
                    return true;
                }
            }
        }
        return false;
    }
}