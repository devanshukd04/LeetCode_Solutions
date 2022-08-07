class Solution {
    public int reachableNodes(int n, int[][] edges, int[] restricted) {
        //Creating a hashmap
        HashMap<Integer,List<Integer>> map=new HashMap<Integer,List<Integer>>();
        //Creating a hashset
        HashSet<Integer> set=new HashSet<Integer>();
        int ans=0;
        //Adding restricted nodes to the hashset
        for(int num:restricted){
            set.add(num);
        }
        for(int i=0;i<edges.length;i++){
            //Checking if whether the given edge is among any restricted node, if no adding them to the hashset
            if(!set.contains(edges[i][0]) && !set.contains(edges[i][1])){
                //if hashmap contains that node already, adding it to the array of reachable nodes from that node
                if(map.containsKey(edges[i][0])){
                    List<Integer> list=map.get(edges[i][0]);
                    list.add(edges[i][1]);
                }
                //Else creating a new arraylist and add that node to that list and putting it in hashmap
                else{
                    List<Integer> list=new ArrayList<Integer>();
                    list.add(edges[i][1]);
                    map.put(edges[i][0],list);
                }
                //Doing the same thing for second node in pair as it is an undirected graph
                if(map.containsKey(edges[i][1])){
                    List<Integer> list=map.get(edges[i][1]);
                    list.add(edges[i][0]);
                }
                else{
                    List<Integer> list=new ArrayList<Integer>();
                    list.add(edges[i][0]);
                    map.put(edges[i][1],list);
                }
                
            }
        }
        //Creating a visited array
        int[] visited=new int[n];
        //Creating a queue
        Queue<Integer> queue=new LinkedList<Integer>();
        //Adding initial node 0 to the queue
        queue.add(0);
        visited[0]=1;
        while(!queue.isEmpty()){
            int node=queue.poll();
            //ans keeps track of number of reachable nodes
            ans++;
            if(map.containsKey(node)){
                //list contains all nodes reachable from the current node
                List<Integer> list=map.get(node);
                //Traversing over all the nodes in list
                for(int num:list){
                    //if node not visited then adding it to the queue and marking it as visited
                    if(visited[num]!=1){
                        queue.add(num);
                        visited[num]=1;
                    }
                }
            }
        }
        return ans;
    }
}