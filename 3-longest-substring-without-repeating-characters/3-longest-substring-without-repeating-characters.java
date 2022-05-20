class Solution {
    public int lengthOfLongestSubstring(String s) {
        int max=Integer.MIN_VALUE;
        int count=0;
        String s1="";
        if(s.isEmpty()){
            return 0;
        }
        for(int i=0;i<s.length();i++){
            if(s1.contains(Character.toString(s.charAt(i)))){
                s1=s1.substring(s1.indexOf(Character.toString(s.charAt(i)))+1,s1.length());
                s1=s1+Character.toString(s.charAt(i));
                count=s1.length();
}
            else{
                s1=s1+Character.toString(s.charAt(i));
                count+=1;
            }
            System.out.println(count);
            if(max<count){
                max=count;
}
        }
        return max;
    }
}