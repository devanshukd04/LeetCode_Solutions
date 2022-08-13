class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        boolean flag;
        HashMap<String,Integer> map=new HashMap<String,Integer>();
        for(String word:words){
            map.put(word,map.getOrDefault(word,0)+1);
        }
        List<Integer> res=new ArrayList<Integer>();
        int wordCount=words.length;
        int wordLength=words[0].length();
        
        for(int i=0;i<=s.length()-wordCount*wordLength;i++){
            HashMap<String,Integer> freq=new HashMap<String,Integer>();
            flag=true;
            for(int j=0;j<wordCount;j++){
                int nextIndex=i+j*wordLength;
                String nextWord=s.substring(nextIndex,nextIndex+wordLength);
                if(!map.containsKey(nextWord)){
                    flag=false;
                    break;
                }
                freq.put(nextWord,freq.getOrDefault(nextWord,0)+1);
                if(freq.get(nextWord)>map.get(nextWord)){
                    flag=false;
                    break;
                }
            }
            if(flag){
                res.add(i);
            }
        }
        return res;
    }
}