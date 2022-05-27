class Solution {
    public long[] sumOfThree(long num) {
        long [] array =new long[3];
        if(num%3==0){
            array[0]=num/3-1;
            array[1]=num/3;
            array[2]=num/3+1;
            return array;
        }
        else{
            return new long[0];
        }
        
    }
}