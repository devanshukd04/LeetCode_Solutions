class Solution {
    public int equalPairs(int[][] grid) {
        HashMap<List<Integer>,List<Integer>> map=new HashMap<List<Integer>,List<Integer>>();
        int count=0;
        for(int i=0;i<grid.length;i++){
            List<Integer> list=new ArrayList<Integer>();
            for(int j=0;j<grid[0].length;j++){
                list.add(grid[i][j]);
            }
            if(map.containsKey(list)){
                List<Integer> list1=map.get(list);
                list1.add(i);
                map.put(list,list1);
            }
            else{
                List<Integer> list1=new ArrayList<Integer>();
                list1.add(i);
                map.put(list,list1);
            }
        }
        for(int i=0;i<grid[0].length;i++){
            List<Integer> list=new ArrayList<Integer>();
            for(int j=0;j<grid.length;j++){
                list.add(grid[j][i]);
            }
            if(map.containsKey(list)){
                List<Integer> list1=map.get(list);
                count+=list1.size();
            }
        }
        return count;
    }
}