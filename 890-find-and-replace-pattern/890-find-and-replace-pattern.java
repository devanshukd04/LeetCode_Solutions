class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> list=new ArrayList<String>();
        for(String word:words){
            HashMap<Character,Character> map=new HashMap<Character,Character>();
            boolean flag=true;
            if(word.length()==pattern.length()){
                for(int i=0;i<word.length();i++){
                    if(map.containsKey(word.charAt(i))){
                        if(!map.get(word.charAt(i)).equals(pattern.charAt(i))){
                            flag=false;
                            break;
                        }
                    }
                    else{
                        if(map.containsValue(pattern.charAt(i))){
                            flag=false;
                            break;
                        }
                        map.put(word.charAt(i),pattern.charAt(i));
                    }
                }
                if(flag){
                    list.add(word);
                }
            }
        }
        return list;
    }
}