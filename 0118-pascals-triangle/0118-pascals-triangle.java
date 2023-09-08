class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans=new ArrayList<List<Integer>>();
        for(int i=0;i<numRows;i++){
            List<Integer> list=new ArrayList<Integer>();
            if(i==0){
                list.add(1);
            }
            else{
                list.add(1);
                List<Integer> prevlist=ans.get(ans.size()-1);
                for(int j=0;j<prevlist.size()-1;j++){
                    list.add(prevlist.get(j)+prevlist.get(j+1));
                }
                list.add(1);
            }
            ans.add(list);
        }
        return ans;
    }
}