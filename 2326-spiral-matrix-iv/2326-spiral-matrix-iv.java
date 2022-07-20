/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int[][] matrix=new int[m][n];
        ListNode temp=head;
        int top=0;
        int bottom=m-1;
        int left=0;
        int right=n-1;
        
        while(top<=bottom && left<=right){
            for(int i=left;i<=right;i++){
                if(temp==null){
                    matrix[top][i]=-1;
                }
                else{
                    matrix[top][i]=temp.val;
                    temp=temp.next;
                }
            }
            
            for(int i=top+1;i<=bottom;i++){
                if(temp==null){
                    matrix[i][right]=-1;
                }
                else{
                    matrix[i][right]=temp.val;
                    temp=temp.next;
                }
            }
            
            if(top<bottom){
                for(int i=right-1;i>=left;i--){
                    if(temp==null){
                        matrix[bottom][i]=-1;
                    }
                    else{
                        matrix[bottom][i]=temp.val;
                        temp=temp.next;
                    }
                }
            }
            
            if(left<right){
                for(int i=bottom-1;i>top;i--){
                    if(temp==null){
                        matrix[i][left]=-1;
                    }
                    else{
                        matrix[i][left]=temp.val;
                        temp=temp.next;
                    }
                }
            }
            
            top++;
            bottom--;
            left++;
            right--;
            
        }
        return matrix;
    }
}