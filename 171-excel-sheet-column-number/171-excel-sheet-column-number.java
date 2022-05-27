class Solution {
    public int titleToNumber(String columnTitle) {
        int a;
        int b=1;
        int sum=0;
        for(int i=columnTitle.length()-1;i>=0;i--){
            a=columnTitle.charAt(i)-'0'-16;
            sum+=b*a;
            b*=26;
        }
        return sum;
    }
}