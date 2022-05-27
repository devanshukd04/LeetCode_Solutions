class Solution {
    public String getSmallestString(int n, int k) {
        char[] a= new char[n];
        int c;
        for(int i=n;i>0;i--){
            c=k-i+1;
            if(c==1){
                for(int j=i;j>0;j--){
                    a[j-1]='a';
                }
                return new String(a);
            }
            c=Math.min(26,c);
            k-=c;
            a[i-1]=(char)(c-1+'a');
        }
        return new String(a);
    }
}