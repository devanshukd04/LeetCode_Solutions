class Solution {
    public int maxProduct(String[] words) {
        int n=words.length;
        int[] a=new int[n];
        int[] b=new int[n];
        String a1;
        int b1;
        for(int i=0;i<n;i++){
            a1=words[i];
            b1=a1.length();
            int c=0;
            for(int j=0;j<b1;j++){
                c|=1<<(a1.charAt(j)-'a');
            }
            a[i]=c;
            b[i]=b1;
        }
        int max=0;
        for(int i=0;i<n-1;i++){
            for(int j=i+1;j<n;j++){
                if((a[i] & a[j])==0){
                    max=Math.max(max,b[i]*b[j]);
                }
            }
        }
        return max;
    }
}