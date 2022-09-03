class Solution {
    public int[] numsSameConsecDiff(int n, int k) {
        List<Integer> ans=new ArrayList<Integer>();
        for(int i=1;i<10;i++){
            digitDiff(n-1,k,ans,i);
        }
        int[] res=new int[ans.size()];
        int j=0;
        for(int num:ans){
            res[j++]=num;
        }
        return res;
    }
    public void digitDiff(int n,int k,List<Integer> ans,int num){
        if(n==0){
            ans.add(num);
            return;
        }
        int digit=num%10;
        if(digit-k>=0){
            digitDiff(n-1,k,ans,num*10+(digit-k));
        }
        if(digit+k<=9 && digit-k!=digit+k){
            digitDiff(n-1,k,ans,num*10+(digit+k));
        }
    } 
}