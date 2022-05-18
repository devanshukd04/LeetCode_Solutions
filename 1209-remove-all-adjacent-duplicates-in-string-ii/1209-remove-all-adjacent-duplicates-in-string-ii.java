class Solution {
    public String removeDuplicates(String s, int k) {
        List<Character> a =new ArrayList<Character>();
        List<Integer> b =new ArrayList<Integer>();
        StringBuilder d1= new StringBuilder();
        int c;
        int c1;
        String c2;
        String d;
        char e;
        for(int i=0;i<s.length();i++){
            c=a.size();
            e=s.charAt(i);
            if(c!=0 && a.get(c-1)==e){
                c1=b.get(c-1);
                if(c1+1==k){
                    a.remove(c-1);
                    b.remove(c-1);
                }
                else{
                    b.set(c-1,c1+1);
                }
            }
            else{
                a.add(e);
                b.add(1);
            }
        }
        for(int i=0;i<a.size();i++){
            e=a.get(i);
            c2=Character.toString(e);
            d1.append(c2);
            for(int j=1;j<b.get(i);j++){
                d1.append(c2);
            }
        }
        d=d1.toString();
        return d;
    }
}