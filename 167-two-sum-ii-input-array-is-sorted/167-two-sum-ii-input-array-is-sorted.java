class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] answer=new int[2];
        int i,j;
        i=0;
        j=numbers.length-1;
        while(i<j){
            if(numbers[i]+numbers[j]==target){
                answer[0]=i+1;
                answer[1]=j+1;
                return answer;
            }
            else if(numbers[i]+numbers[j]<target){
                i++;
            }
            else{
                j--;
            }
        }
        return answer;
    }
}