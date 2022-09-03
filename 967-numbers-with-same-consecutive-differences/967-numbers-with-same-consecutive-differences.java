class Solution {
    public int[] numsSameConsecDiff(int n, int k) {
        //Creating a list to store ans
        List<Integer> ans=new ArrayList<Integer>();
        //Using for loop as first digit cannot be 0
        for(int i=1;i<10;i++){
            digitDiff(n-1,k,ans,i);
        }
        //As return type is integer array creating a array
        int[] res=new int[ans.size()];
        int j=0;
        //Storing the elements of list into an integer array
        for(int num:ans){
            res[j++]=num;
        }
        //Returning the array
        return res;
    }
    public void digitDiff(int n,int k,List<Integer> ans,int num){
        //If num equals 0, implies we have foyund one number
        if(n==0){
            ans.add(num);
            return;
        }
        //Accessing the last digit by num%10
        int digit=num%10;
        //If digit-k>=0 means we can take that digit
        if(digit-k>=0){
            digitDiff(n-1,k,ans,num*10+(digit-k));
        }
        //If digit+k<=9 means we can take that digit
        //There's a check that digit-k!=digit+k this case occurs to avoid repeated function calls when k is 0
        if(digit+k<=9 && digit-k!=digit+k){
            digitDiff(n-1,k,ans,num*10+(digit+k));
        }
    } 
}