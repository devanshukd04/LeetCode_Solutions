class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String,Integer> map=new HashMap<String,Integer>();
        List<String> result=new ArrayList<String>();
        for(int i=0;i<words.length;i++){
            if(map.containsKey(words[i])){
                int freq=map.get(words[i]);
                map.put(words[i],freq+1);
            }
            else{
                map.put(words[i],1);
            }
        }
        List<String> list=new ArrayList(map.keySet());
        Collections.sort(list,(word1,word2)->{
            int comparision=map.get(word2).compareTo(map.get(word1));
            if(comparision==0){
                return word1.compareTo(word2);
            }
            return comparision;
        });
        List<String> ans=new ArrayList<String>();
        int j=0;
        while(j<k){
            ans.add(list.get(j));
            j++;
        }
        return ans;
    }
}