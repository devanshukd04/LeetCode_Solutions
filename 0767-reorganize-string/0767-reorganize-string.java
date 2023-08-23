class Solution {
    public String reorganizeString(String s) {
        HashMap<Character,Integer> map=new HashMap<>();
        for(int i=0;i<s.length();i++){
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
        }
        PriorityQueue<Character> queue=new PriorityQueue<Character>((a,b)->Integer.compare(map.get(b),map.get(a)));
        StringBuilder ans=new StringBuilder();
        for(char ch:map.keySet()){
            queue.add(ch);
        }
        while(!queue.isEmpty()){
            char ch1=queue.poll();
            if(ans.length()==0 || ans.charAt(ans.length()-1)!=ch1){
                ans.append(ch1);
                if(map.get(ch1)!=1){
                    map.put(ch1,map.get(ch1)-1);
                    queue.add(ch1);
                }
            }
            else{
                if(queue.isEmpty()){
                    return "";
                }
                char ch2=queue.poll();
                ans.append(ch2);
                queue.add(ch1);
                if(map.get(ch2)!=1){
                    map.put(ch2,map.get(ch2)-1);
                    queue.add(ch2);
                }
            }
        }
        return ans.toString();
    }
}