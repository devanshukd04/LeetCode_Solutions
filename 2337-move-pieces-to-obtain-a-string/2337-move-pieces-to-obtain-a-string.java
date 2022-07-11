class Solution {
    public boolean canChange(String start, String target) {
        if(start.length()!=target.length()){
            return false;
        }
        int[] Lseq=new int[start.length()];
        int[] Rseq=new int[start.length()];
        int[] Lseqt=new int[target.length()];
        int[] Rseqt=new int[target.length()];
        
        if(start.charAt(0)=='L'){
            Lseq[0]=1;
        }
        else if(start.charAt(0)=='R'){
            Rseq[0]=1;
        }
        if(target.charAt(0)=='L'){
            Lseqt[0]=1;
        }
        else if(target.charAt(0)=='R'){
            Rseqt[0]=1;
        }
        for(int i=1;i<start.length();i++){
            if(start.charAt(i)=='L'){
                Rseq[i]=Rseq[i-1];
                Lseq[i]=Lseq[i-1]+1;
            }
            else if(start.charAt(i)=='R'){
                Rseq[i]=Rseq[i-1]+1;
                Lseq[i]=Lseq[i-1];
            }
            else{
                Rseq[i]=Rseq[i-1];
                Lseq[i]=Lseq[i-1];
            }
            if(target.charAt(i)=='L'){
                Rseqt[i]=Rseqt[i-1];
                Lseqt[i]=Lseqt[i-1]+1;
            }
            else if(target.charAt(i)=='R'){
                Rseqt[i]=Rseqt[i-1]+1;
                Lseqt[i]=Lseqt[i-1];
            }
            else{
                Rseqt[i]=Rseqt[i-1];
                Lseqt[i]=Lseqt[i-1];
            }
        }


        if((Lseq[Lseq.length-1]!=Lseqt[Lseq.length-1]) || (Rseq[Rseq.length-1]!=Rseqt[Rseq.length-1])){
            return false;
            }
        boolean flag =true;
        for(int i=0;i<start.length();i++){
            if((Lseq[i]>Lseqt[i]) || (Rseq[i]<Rseqt[i]) || (Lseq[i]<Lseqt[i] && Rseq[i]>Rseqt[i])){
                return false;
            }
            if(Rseq[i]>Rseqt[i]){
                flag=false;
        }
            else if(Rseq[i]==Rseqt[i]){
                flag=true;
                }
            if(!flag && start.charAt(i)=='L'){
                return false;}
}
        return true;
    }
}