class Solution {
    public String longestCommonPrefix(String[] strs) {
        String b="";
        String b1;
        if(strs.length<=1){
            return strs[0];
        }
        int a=strs[0].length()>strs[1].length()?strs[1].length():strs[0].length();
        for(int i=0;i<a;i++){
            if(strs[0].substring(i,i+1).equals(strs[1].substring(i,i+1))){
                b+=strs[0].substring(i,i+1);
            }
            else{
                break;
            }
        }
        for(int i=2;i<strs.length;i++){
            a=strs[i].length()>b.length()?b.length():strs[i].length();
            b1="";
            for(int j=0;j<a;j++){
                if(strs[i].substring(j,j+1).equals(b.substring(j,j+1))){
                    b1+=strs[i].substring(j,j+1);
                }
                else{
                    break;
                }
            }
            if(b1.isEmpty()){
                return b1;
            }
            if(!b1.equals(b)){
                b=b1;
            }
        }
        return b;
    }
}