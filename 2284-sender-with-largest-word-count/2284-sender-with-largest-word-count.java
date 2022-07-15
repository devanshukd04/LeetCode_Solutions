class Solution {
    public String largestWordCount(String[] messages, String[] senders) {
        HashMap<String,Integer> map=new HashMap<String,Integer>();
        for(int i=0;i<messages.length;i++){
            String[] message=messages[i].split(" ");
            if(map.containsKey(senders[i])){
                int count=map.get(senders[i]);
                map.put(senders[i],count+message.length);
            }
            else{
                map.put(senders[i],message.length);
            }
        }
        List<String> list=new ArrayList(map.keySet());
        Collections.sort(list,(word1,word2)->{
            int comparision=map.get(word2).compareTo(map.get(word1));
            if(comparision==0){
                return word2.compareTo(word1);
            }
            return comparision;
        });
        return list.get(0);
    }
}