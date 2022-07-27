class Solution {
    public String decodeString(String s) {
        int i=0;
        Stack<Integer> s1=new Stack<Integer>();
        Stack<String> s2=new Stack<String>();
        String number;
        StringBuffer word=new StringBuffer();
        while(i<s.length()){
            if((s.charAt(i)>='0') && (s.charAt(i)<='9')){
                int j=i;
                while(s.charAt(j)!='['){
                    j++;
                }
                s1.push(Integer.valueOf(s.substring(i,j)));
                s2.push(word.toString());
                i=j;
                word.delete(0,word.length());
            }
            else if((s.charAt(i)>='a') && (s.charAt(i)<='z')){
                word.append(s.charAt(i));
            }
            else if(s.charAt(i)==']'){
                int a=s1.pop();
                String b=s2.pop();
                StringBuffer word1=new StringBuffer();
                word1.append(b);
                while(a>0){
                    word1.append(word);
                    a--;
                }
                word=word1;
            }
            i++;
        }
        return word.toString();
    }
}