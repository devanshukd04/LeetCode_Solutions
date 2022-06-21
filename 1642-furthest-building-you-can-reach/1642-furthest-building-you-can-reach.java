class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        PriorityQueue<Integer> a=new PriorityQueue<>();
        for(int i=1;i<heights.length;i++){
            int b=heights[i]-heights[i-1];
            if(b>0){
                a.add(b);
            }
            if(a.size()>ladders){
                bricks-=a.poll();
            }
            if(bricks<0){
                return i-1;
            }
        }
        return heights.length-1;
    }
}