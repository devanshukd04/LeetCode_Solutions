class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        HashMap<String,PriorityQueue<String>> map=new HashMap<>();
        
        for(List<String> ticket:tickets){
            
            String source=ticket.get(0);
            String destination=ticket.get(1);
            
            map.putIfAbsent(source,new PriorityQueue<String>());
            map.get(source).add(destination);
        }
        LinkedList<String> ans = new LinkedList<>();
        helper(map,"JFK",ans);
        return ans;
    }
    public void helper(HashMap<String,PriorityQueue<String>> map, String source, LinkedList<String> ans){
        PriorityQueue<String> nextAirports = map.get(source);
        while (nextAirports != null && !nextAirports.isEmpty()) {
            helper(map,nextAirports.poll(),ans);
        }
        ans.addFirst(source);
    }
}