class Solution {
    public String convert(String s, int numRows) {
        if(s.length()==1 || numRows==1){
            return s;
        }
        StringBuffer ans=new StringBuffer();
        boolean flag=true;
        for(int i=0;i<numRows;i++){
            int j=i;
            if((i+1)==numRows || i==0){
                while(j<s.length()){
                    ans.append(s.charAt(j));
                    j+=(numRows)*2-2;
                }
                
            }
            else{
                flag=true;
                while(j<s.length()){
                    ans.append(s.charAt(j));
                    if(flag){
                        j+=(numRows-1-i)*2;   
                    }
                    else{
                        j+=i*2;
                    }
                    flag=!flag;
                }   
            }
        }
        return ans.toString();
    }
}