class Solution {
    public int longestPalindrome(String s) {
        List<Character> a=new ArrayList<Character>();
        List<Integer> b=new ArrayList<Integer>();
        int c;
        int d;
        for(int i=0;i<s.length();i++){
            if(a.contains(s.charAt(i))){
                d=a.indexOf(s.charAt(i));
                c=b.get(d);
                b.set(d,c+1);
            }
            else{
                a.add(s.charAt(i));
                b.add(1);
            }
        }
        c=0;
        d=0;
        System.out.println(a+" "+b);
        for(int i=0;i<b.size();i++){
            if(b.get(i)%2==0){
                d+=b.get(i);
            }
            else{
                c=4;
                d+=b.get(i)-1;
            }
        }
        if(c!=0){
            d+=1;
        }
        return d; 
    }
}