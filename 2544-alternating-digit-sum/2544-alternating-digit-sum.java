class Solution {
    public int alternateDigitSum(int n) {
        int sum=0;
        boolean alternate=true;
        List<Integer> list=new ArrayList<Integer>();
        while(n>0){
            int digit=n%10;
            n/=10;
            list.add(digit);
        }
        for(int i=list.size()-1;i>=0;i--){
            if(alternate){
                sum+=list.get(i);
            }
            else{
                sum-=list.get(i);
            }
            alternate=!alternate;
        }
        return sum;
    }
}