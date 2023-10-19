class Solution {
    public boolean backspaceCompare(String s, String t) {
        StringBuffer str1=new StringBuffer();
        StringBuffer str2=new StringBuffer();
        
        int length=0;
        
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)!='#'){
                ++length;
                str1.append(s.charAt(i));
            }
            else{
                if(length>0){
                    str1.deleteCharAt(--length);   
                }
            }
        }
        
        length=0;
        for(int i=0;i<t.length();i++){
            if(t.charAt(i)!='#'){
                ++length;
                str2.append(t.charAt(i));
            }
            else{
                if(length>0){
                    str2.deleteCharAt(--length);   
                }
            }
        }
        
        return str1.toString().equals(str2.toString());
    }
}