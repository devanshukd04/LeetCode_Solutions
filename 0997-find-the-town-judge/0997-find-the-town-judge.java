class Solution {
    public int findJudge(int n, int[][] trust) {
        HashMap<Integer,List<Integer>> map=new HashMap<Integer,List<Integer>>();
        HashSet<Integer> set=new HashSet<Integer>();
        for(int i=1;i<=n;i++){
            map.put(i,new ArrayList<Integer>());
        } 
        for(int[] arr:trust){
            map.get(arr[1]).add(arr[0]);
            set.add(arr[0]);
        }
        for(int i=1;i<=n;i++){
            if(!set.contains(i) && map.get(i).size()==n-1){
                return i;
            }
        }
        return -1;
    }
}