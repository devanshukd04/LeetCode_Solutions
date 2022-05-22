class Solution {
    public int percentageLetter(String s, char letter) {
        int b;
        char c;
        HashMap<Character,Integer> a=new HashMap<Character,Integer>();
        for(int i=0;i<s.length();i++){
            c=s.charAt(i);
            if(a.containsKey(c)){
                b=a.get(c);
                a.put(c,b+1);
            }
            else{
                a.put(c,1);
            }
        }
        if(a.containsKey(letter)){
            return (a.get(letter)*100)/s.length();
        }
        else{
            return 0;
        }
    }
}