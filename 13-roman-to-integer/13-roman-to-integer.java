class Solution {
    public int romanToInt(String s) {
        char[] a1={'M','D','C','L','X','V','I'};
        List<Character> a=new ArrayList<Character>();
        for(int i=0;i<a1.length;i++){
            a.add(a1[i]);
        }
        char c;
        c='M';
        int [] b={1000,500,100,50,10,5,1};
        int d=0;
        for(int i=0;i<s.length();i++){
            if(a.indexOf(s.charAt(i))<a.indexOf(c)){
                d+=b[a.indexOf(s.charAt(i))]-2*b[a.indexOf(c)];
            }
            else{
                c=s.charAt(i);
                d+=b[a.indexOf(c)];
            }
        }
        return d;
    }
}