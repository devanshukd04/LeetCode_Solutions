class Solution {
    public String gcdOfStrings(String str1, String str2) {
        StringBuffer ans=new StringBuffer();
        String res="";
        int length1=str1.length();
        int length2=str2.length();
        int j=0;
        while(j<str1.length() && j<str2.length()){
            if(str1.charAt(j)!=str2.charAt(j)){
                return "";
            }
            ans.append(str1.charAt(j));
            if(length1%(j+1)==0 && length2%(j+1)==0){
                res=ans.toString();
            }
            j++;
        }
        int index=0;
        for(int i=0;i<length1;i++){
            if(index==res.length()){
                index=0;
            }
            if(str1.charAt(i)!=res.charAt(index++)){
                return "";
            }
        }
        index=0;
        for(int i=0;i<length2;i++){
            if(index==res.length()){
                index=0;
            }
            if(str2.charAt(i)!=res.charAt(index++)){
                return "";
            }
        }
        return res;
    }
}