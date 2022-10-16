class Solution {
    public boolean sumOfNumberAndReverse(int num) {
        int i=0;
        HashSet<Integer> set=new HashSet<Integer>();
        if(num==0){
            return true;
        }
        i=num/2;
        //Here, we start from mid of number
        while(i<=num){
            int temp=i;
            int temp1=0;
            //Check if it is already being checked for the number, If no checking again.
            if(!set.contains(i)){
                //Reversing the number
                while(temp>0){
                    temp1=temp1*10+temp%10;
                    temp/=10;
                }
                //if(i+reverse(i)==number) return true
                if(i+temp1==num){
                    return true;
                }
                set.add(i);
                set.add(temp1); 
            }
            i++;
        }
        //If we do not any such number then return false
        return false;
    }
}