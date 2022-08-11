class Solution {
    public int longestPalindrome(String[] words) {
        //Creating a hashmap to count frequency of a String
        HashMap<String,Integer> map=new HashMap<String,Integer>();
        //Initializing ans variable with maximum possible value
        int ans=words.length*2;
        //Initializing two boolean varibales
        boolean flag=false;  //To check if palindromic substring present in words array
        boolean flag1=false; //To check if frequency of palindromc substring if present is odd
        for(int i=0;i<words.length;i++){
            //If map containsKey then incrementing its frequency by 1
            if(map.containsKey(words[i])){
                map.put(words[i],map.get(words[i])+1);
            }
            else{
                //Creating a StringBuilder to reverse the String
                StringBuilder s=new StringBuilder();
                s.append(words[i]);
                s.reverse();
                String s1=s.toString();
                //Checking if reverse String present in map if yes then decrementing count of that reverse String by 1 as it could be used for creating palindromic String
                if(map.containsKey(s1)){
                    //If count was 1 so decrementing by 1 will make it 0, so removing that String
                    if(map.get(s1)==1){
                        map.remove(s1);
                    }
                    else{
                        map.put(s1,map.get(s1)-1);
                    }
                }
                //If map does not contain that reverse String so adding the original String to map
                else{
                    map.put(words[i],1);
                }
            }
        }
        //Now in map we have some palindromic String and other String
        //Non-palindromic String would not contribute to resultant String
        for(String word:map.keySet()){
            //If String is plaindromic then it can be part of resulatnat palindromic String
            if(word.charAt(0)==word.charAt(1)){
                flag=true;
                //If frequency of palindromic String is odd making flag1 true as only even frequency would be used now and as there could many palindromic String of odd frequency but only one odd frequency String would be used rest all even frequency would be used
                if(map.get(word)%2!=0){
                    flag1=true;
                    ans-=2;
                }
            }
            //Else decrementing frequency of that word multiply by 2 from ans
            //Multiply by 2 as every String contain two letters
            else{
                ans-=map.get(word)*2;
            }
        }
        if(flag){
            //If flag is true so addiing 2 to the ans
            return flag1==true?ans+2:ans;
        }
        return ans;
    }
}