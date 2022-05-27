class Solution {
    public int numberOfBeams(String[] bank) {
        String a;
        int count,b,c;
        a=bank[0];
        b=countVar(a);
        c=0;
        for(int i=1;i<bank.length;i++){
            a=bank[i];
            count=countVar(a);
            if(!(count==0)){
                c+=b*count;
                b=count;
            }
        }
        return c;
    }
    public int countVar(String s){
        int count=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='1'){
                count++;
            }
        }
        return count;
    }
}