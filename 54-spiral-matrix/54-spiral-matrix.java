class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int top=0;
        int bottom=matrix.length-1;
        int left=0;
        int right=matrix[0].length-1;
        List<Integer> ans_list=new ArrayList<Integer>();
        while(top<=bottom && left<=right){
            for(int i=left;i<=right;i++){
                ans_list.add(matrix[top][i]);
            }
            for(int i=top+1;i<=bottom;i++){
                ans_list.add(matrix[i][right]);
            }
            if(top<bottom){
                for(int i=right-1;i>=left;i--){
                    ans_list.add(matrix[bottom][i]);
                }
            }
            if(left<right){
                for(int i=bottom-1;i>top;i--){
                    ans_list.add(matrix[i][left]);
                }
            }
            top++;
            bottom--;
            left++;
            right--;
        }
        return ans_list;
    }
}