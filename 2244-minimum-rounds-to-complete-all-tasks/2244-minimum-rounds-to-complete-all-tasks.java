class Solution {
    public int minimumRounds(int[] tasks) {
        //Initializing a hashmap to update frequency of numbers
        HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
        for(int num:tasks){
            //Updating the frequency of number in hashmap
            map.put(num,map.getOrDefault(num,0)+1);
        }
        //Initializing ans variable
        int ans=0;
        //Running for-loop for unique numbers in tasks array
        for(int num:map.keySet()){
            //Storing frequency of number in freq variable
            int freq=map.get(num);
            //If freq<2 then it violates the condition of completing atleast 2 tasks on once round so it violates the condition so return -1
            if(freq<2){
                return -1;
            }
            //Initializing three and two variable to store number of round needed to complete three and two tasks at once respectively
            int three,two;
            //If freq%3==1 means we need to carry round of 3 tasks at once for (freq/3)-1 times and round of 2 tasks at once for 2 times 
            if(freq%3==1){
                //If (freq/3)>0 then ((freq/3)-1) else 0
                three=freq/3>0?(freq/3)-1:0;
                two=2;
            }
            //Else we need to carry round of 3 tasks at freq/3 times and round of 2 tasks at (freq%3)/2 times 
            else{
                three=freq/3;
                two=(freq%3)/2;
            }
            //Updating the ans variable by adding no. of three round at once and no. of two round at once with ans variable
            ans+=three+two;
        }
        //Returning the ans
        return ans;
    }
}