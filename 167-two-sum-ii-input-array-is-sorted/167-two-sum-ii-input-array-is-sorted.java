class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] answer=new int[2];
        HashMap<Integer,Integer> a=new HashMap<Integer,Integer>();
        for(int i=0;i<numbers.length;i++){
            if(a.containsKey(target-numbers[i])){
                int b=a.get(target-numbers[i]);
                answer[0]=b+1;
                answer[1]=i+1;
                return answer;
            }
            else{
                a.put(numbers[i],i);
            }
        }
        return answer;
    }
}