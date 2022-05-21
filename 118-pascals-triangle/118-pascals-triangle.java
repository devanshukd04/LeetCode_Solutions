class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list=new ArrayList<List<Integer>>();
        int count=1;
        int a;
        for(int i=0;i<numRows;i++){
            ArrayList<Integer> list1 =new ArrayList<Integer>();
            for(int j=0;j<count;j++){
               if(j==0 || j==count-1){
                   list1.add(1);
               }
               else{
                   a=(list.get(count-2)).get(j)+(list.get(count-2)).get(j-1);
                   list1.add(a);
               }
            }
            list.add(list1);
            ++count;
        }
        return list;
    }
}