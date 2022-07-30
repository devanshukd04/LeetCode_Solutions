class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        List<String> ans=new ArrayList<String>();
        HashMap<Character,Integer> map=new HashMap<Character,Integer>();
        for(String word:words2){
            HashMap<Character,Integer> map1=new HashMap<Character,Integer>();
            for(int i=0;i<word.length();i++){
                map1.put(word.charAt(i),map1.getOrDefault(word.charAt(i),0)+1);
            }
            for(char ch:map1.keySet()){
                int a=map.getOrDefault(ch,0);
                int b=map1.get(ch);
                if(b>a){
                    map.put(ch,b);
                }
            }
        }
        for(String word:words1){
            HashMap<Character,Integer> map1=new HashMap<Character,Integer>();
            boolean flag=true;
            for(int i=0;i<word.length();i++){
                map1.put(word.charAt(i),map1.getOrDefault(word.charAt(i),0)+1);
            }
            for(char ch:map.keySet()){
                int a=map.get(ch);
                int b=map1.getOrDefault(ch,0);
                if(a>b){
                    flag=false;
                    break;
                }
            }
            if(flag){
                ans.add(word);
            }
        }
        return ans;
    }
}