class Solution {
    public String getHint(String secret, String guess) {
        HashMap<Character,Integer> map=new HashMap<Character,Integer>();
        List<Integer> list=new ArrayList<Integer>();
        int b=0;
        int c=0;
        for(int i=0;i<secret.length();i++){
            char ch=secret.charAt(i);
            if(secret.charAt(i)==guess.charAt(i)){
                b++;
            }
            else{
                int count=0;
                if(map.containsKey(ch)){
                    count=map.get(ch);
                }
                map.put(ch,count+1);
                list.add(guess.charAt(i)-'0');
            }
        }
        for(int num:list){
            char ch=(char)(num+'0');
            if(map.containsKey(ch)){
                c++;
                int count=map.get(ch);
                --count;
                if(count==0){
                    map.remove(ch);
                }
                else{
                    map.put(ch,count);
                }
            }
        }
        String ans=b+"A"+c+"B";
        return ans;
    }
}