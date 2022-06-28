import java.util.Arrays;
import java.util.Collections;
class Solution {
    public int minDeletions(String s) {
        int[] a=new int[26];
        int c;
        int d;
        int sum=0;
        for(int i=0;i<s.length();i++){
            c=s.charAt(i)-97;
            ++a[c];
        }
        Arrays.sort(a);
        for(int i=0;i<a.length/2;i++){
            int temp=a[i];
            a[i]=a[a.length-1-i];
            a[a.length-1-i]=temp;
        }
        int[] b=new int[a[0]];
        for(int i=0;i<a.length && a[i]>0;i++){
            if(b[a[i]-1]==0){
                b[a[i]-1]=1;
            }
            else{
                boolean flag=false;
                int e=a[i]-1;
                while(e>=0){
                    if(b[e]==0){
                        sum+=a[i]-1-e;
                        b[e]=1;
                        flag=true;
                        break;
                    }
                    e--;
                }
                if(!flag){
                    int f=i;
                    while(f<a.length && a[f]>0){
                        sum+=a[f];
                        f++;
                    }
                    return sum;
                }
            }
        }
        return sum;
    }
}