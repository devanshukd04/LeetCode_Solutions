class Solution {
    public String frequencySort(String s) {
        HashMap<Character,Integer> map=new HashMap<Character,Integer>();
        StringBuilder ans=new StringBuilder();
        for(int i=0;i<s.length();i++){
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
        }
        PriorityQueue<Character> queue=new PriorityQueue<Character>((a,b)->{
            return map.get(b)-map.get(a);
        });
        for(char c:map.keySet()){
            queue.add(c);
        }
        while(!queue.isEmpty()){
            char c=queue.poll();
            int d=map.get(c);
            while(d>0){
                ans.append(c);
                d--;
            }
        }
        return ans.toString();
    }
}