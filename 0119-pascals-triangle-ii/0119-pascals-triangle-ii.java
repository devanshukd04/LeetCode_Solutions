class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<List<Integer>> list=new ArrayList<List<Integer>>();
        int count=1;
        int a;
        for(int i=0;i<=rowIndex;i++){
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
        return list.get(list.size()-1);
    }
}