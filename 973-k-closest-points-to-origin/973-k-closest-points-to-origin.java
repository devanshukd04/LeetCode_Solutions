class Solution {
    public int[][] kClosest(int[][] points, int k) {
        int[][] result=new int[k][2];
        List<Integer> list=new ArrayList<Integer>();
        HashMap<Integer,List<Integer>> map=new HashMap<Integer,List<Integer>>();
        for(int i=0;i<points.length;i++){
            int x=points[i][0];
            int y=points[i][1];
            x*=x;
            y*=y;
            int sum=x+y;
            list.add(sum);
            if(map.containsKey(sum)){
                List<Integer> list1=map.get(sum);
                list1.add(i);
                map.put(sum,list1);
            }
            else{
                List<Integer> list1=new ArrayList<Integer>();
                list1.add(i);
                map.put(sum,list1);
            }
        }
        Collections.sort(list);
        for(int i=0;i<k;i++){
            List<Integer> list1=map.get(list.get(i));
            for(int b:list1){
                result[i][0]=points[b][0];
                result[i][1]=points[b][1];
                ++i;
            }
            --i;
        }
        return result;
    }
}