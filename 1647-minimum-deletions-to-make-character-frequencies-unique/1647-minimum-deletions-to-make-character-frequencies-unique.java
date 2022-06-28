import java.util.Arrays;
import java.util.Collections;
class Solution {
    public int minDeletions(String s) {
        int[] a=new int[26];
        int c;
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
        int f=a[0]-1;
        for(int i=0;i<a.length && a[i]>0;i++){
            if(a[i]-1<f){
                f=a[i]-1;
            }
            sum+=a[i]-1-f;
            f--;
            if(f==-1){
                int e=i+1;
                while(e<a.length && a[e]>0){
                    sum+=a[e];
                    e++;
                }
                return sum;
            }
        }
        return sum;
    }
}