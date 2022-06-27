class Solution {
    public int minPartitions(String n) {
        int a=-1;
        int b;
        for(int i=0;i<n.length();i++){
            b=n.charAt(i)-48;
            a=b>a?b:a;
        }
        return a;
    }
}