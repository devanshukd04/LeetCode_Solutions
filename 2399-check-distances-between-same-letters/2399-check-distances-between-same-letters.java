class Solution {
    public boolean checkDistances(String s, int[] distance) {
        //Creating a HashMap
        HashMap<Character,Integer> map=new HashMap<Character,Integer>();
        //Iterating over the String
        for(int i=0;i<s.length();i++){
            //If map doesn't conatins Key then putting it in hashMap
            if(!map.containsKey(s.charAt(i))){
                map.put(s.charAt(i),i);
            }
            //If it contains Key then updating diatnce between the current and previous occurence
            else{
                int prev=map.get(s.charAt(i));
                int index=s.charAt(i)-'a';
                //Checking is the computed distance matches with the provided distance
                if(distance[index]!=i-prev-1){
                    return false;
                }
                
            }
        }
        return true;
    }
}