class Solution {
    public String intToRoman(int num) {
        String[] a ={"M","D","C","L","X","V","I"};
        int[] b={1000,500,100,50,10,5,1};
        String d="";
        String e="";
        int c;
        for(int i=0;i<7;i++){
            c=b[i];
            while(num/c>=1){
                d+=a[i];
                num-=c;
            }
            if(num>=8 && num<9){
                d+="VIII";
                num-=8;
            }
            else if(num>=80 && num<90){
                d+="LXXX";
                num-=80;
            }
            else if(num>=800 && num<900){
                d+="DCCC";
                num-=800;
            }
            else if((double)num/(double)c>=0.8){
                e=a[i];
                for(int j=i;j<a.length;j++){
                    if(b[i]-b[j]>0.8*num){
                        d+=a[j]+e;
                        num-=(b[i]-b[j]);
                        break;
                    }
                }
            }
        }
        return d;
    }
}