class Solution {
    public int longestPalindrome(String[] words) {
        HashMap<String,Integer> map=new HashMap<String,Integer>();
        int ans=words.length*2;
        boolean flag=false;
        boolean flag1=false;
        for(int i=0;i<words.length;i++){
            if(map.containsKey(words[i])){
                map.put(words[i],map.get(words[i])+1);
            }
            else{
                StringBuilder s=new StringBuilder();
                s.append(words[i]);
                s.reverse();
                String s1=s.toString();
                if(map.containsKey(s1)){
                    if(map.get(s1)==1){
                        map.remove(s1);
                    }
                    else{
                        map.put(s1,map.get(s1)-1);
                    }
                }
                else{
                    map.put(words[i],1);
                }
            }
        }
        for(String word:map.keySet()){
            if(word.charAt(0)==word.charAt(1)){
                flag=true;
                if(map.get(word)%2!=0){
                    flag1=true;
                    ans-=2;
                }
            }
            else{
                ans-=map.get(word)*2;
            }
        }
        if(flag){
            return flag1==true?ans+2:ans;
        }
        return ans;
    }
}