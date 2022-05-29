class Solution {
    public int rearrangeCharacters(String s, String target) {
        List<String> a=new ArrayList<String>();
        List<Integer> b=new ArrayList<Integer>();
        String c;
        int d;
        int e;
        int max=Integer.MAX_VALUE;
        for(int i=0;i<s.length();i++){
            c=Character.toString(s.charAt(i));
            if(!a.contains(c)){
                a.add(c);
                b.add(1);
            }
            else{
                d=a.indexOf(c);
                e=b.get(d);
                b.set(d,e+1);
            }
        }
        List<String> c1=new ArrayList<String>();
        List<Integer> d1=new ArrayList<Integer>();
        for(int i=0;i<target.length();i++){
            c=Character.toString(target.charAt(i));
            if(!c1.contains(c)){
                c1.add(c);
                d1.add(1);
            }
            else{
                d=c1.indexOf(c);
                e=d1.get(d);
                d1.set(d,e+1);
            }
        }
        for(int i=0;i<c1.size();i++){
            c=c1.get(i);
            e=d1.get(i);
            d=a.indexOf(c);
            if(d==-1){
                return 0;
            }
            d=b.get(d);
            if(max>d/e){
                max=d/e;
            }
            if(d/e==0){
                return 0;
            }
        }
        return max;
    }
}