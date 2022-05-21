class Solution {
    int count1=0;
    public int countVowelStrings(int n) {
        String[] b=new String[]{"a","e","i","o","u"};
        StringBuilder a=new StringBuilder();
        count(b,n,a,0);
        return count1;
        }
    public void count(String[] b,int n, StringBuilder a,int i){
        if(i>4 && n!=0){
            return;
        }
        if(n==0){
            ++count1;
            return;
        }
        count(b,n-1,a.append(b[i]),i);
        count(b,n,a,i+1);
    }
}