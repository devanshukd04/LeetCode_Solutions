class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int a=triangle.size();
        if(a==1){
            return triangle.get(0).get(0);
        }
        int b[]=new int[a+1];
        for(int i=a-1;i>=0;i--){
            int c=triangle.get(i).size();
            for(int j=0;j<c;j++){
                b[j]=Math.min(b[j],b[j+1])+triangle.get(i).get(j);
            }
        }
        return b[0];
    }
}