class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        boolean[] arr=new boolean[n];;
        for(int i=0;i<edges.size();i++){
            arr[edges.get(i).get(1)]=true;
        }
        List<Integer> ans=new ArrayList<Integer>();
        for(int i=0;i<n;i++){
            if(!arr[i]){
                ans.add(i);
            }
        }
        return ans;
    }
}