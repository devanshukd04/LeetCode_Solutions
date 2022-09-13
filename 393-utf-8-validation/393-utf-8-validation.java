class Solution {
    public boolean validUtf8(int[] data) {
        int[] setArray=new int[data.length];
        for(int i=0;i<data.length;i++){
            int num=128;
            while((data[i]&num)>=1){
                setArray[i]++;
                num=num>>1;
            }
        }
        int a=-1;
        int counter=0;
        for(int i=0;i<data.length;i++){
            if(a==-1){
                a=1;
                if(setArray[i]==4){
                    counter=3;
                }
                else if(setArray[i]==3){
                    counter=2;
                }
                else if(setArray[i]==2){
                    counter=1;
                }
                else if(setArray[i]==0){
                    a=-1;
                    counter=0;
                }
                else{
                    return false;
                }
            }
            else if(a==1 && counter!=0){
                if(setArray[i]!=1){
                    return false;
                }
                counter--;
                a=counter==0?-1:1;
            }
        }
        if(a!=-1 || counter!=0){
            return false;
        }
        return true;
    }
}