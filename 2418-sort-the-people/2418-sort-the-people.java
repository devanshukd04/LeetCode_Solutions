class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        HashMap<Integer,String> map=new HashMap<Integer,String>();
        for(int i=0;i<names.length;i++){
            map.put(heights[i],names[i]);
        }
        Arrays.sort(heights);
        for(int i=0;i<heights.length/2;i++){
            int temp=heights[i];
            heights[i]=heights[heights.length-1-i];
            heights[heights.length-1-i]=temp;
        }
        String[] res=new String[names.length];
        for(int i=0;i<heights.length;i++){
            res[i]=map.get(heights[i]);
        }
        return res;
    }
}