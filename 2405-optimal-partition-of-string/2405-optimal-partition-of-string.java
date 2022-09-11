class Solution {
    public int partitionString(String s) {
        int ans=1;
        //Creating an HashSet
        HashSet<Character> set=new HashSet<Character>();
        for(int i=0;i<s.length();i++){
            //Check if current character present in set
            if(!set.contains(s.charAt(i))){
                //If current character not present in set then add current charcter in set
                set.add(s.charAt(i));
            }
            else{
                //If current character present in set then clear the set increment the ans and clear the set
                ans++;
                set.clear();
                set.add(s.charAt(i));
            }
        }
        return ans;
    }
}