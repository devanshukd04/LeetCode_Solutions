class Solution {
    public int maxVowels(String s, int k) {
        HashSet<Character> set = new HashSet<Character>() {{
            add('a');
            add('e');
            add('i');
            add('o');
            add('u');
        }};
        System.out.println(set);
        int start=0;
        int end=0;
        int ans=0;
        int count=0;
        while(start<=end && end<s.length()){
            char ch;
            while(end<s.length() && (end-start+1)<=k){
                ch=s.charAt(end);
                if(set.contains(ch)){
                    count++;
                }
                end++;
            }
            ch=s.charAt(start);
            start++;
            ans=ans<count?count:ans;
            if(set.contains(ch)){
                count--;
            }
        }
        return ans;
    }
}