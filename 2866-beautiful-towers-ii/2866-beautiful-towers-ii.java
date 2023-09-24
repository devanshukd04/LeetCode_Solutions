class Solution {
    class Node{
        long cost;
        long totalSum;
        long elements=0;
        Node(long cost, long totalSum, long elements){
            this.cost=cost;
            this.totalSum=totalSum;
            this.elements=elements;
        }
    }
    public long maximumSumOfHeights(List<Integer> maxHeights) {
        if(maxHeights.size()==1){
            return maxHeights.get(0);
        }
        
        int size=maxHeights.size();
        Stack<Node> left=new Stack<Node>();
        Stack<Node> right=new Stack<Node>();
        
        
        int prev=-1;
        long sum=0;
        long[] leftArr=new long[size];
        long[] rightArr=new long[size];
        
        for(int i=0;i<size;i++){
            long element=(long)maxHeights.get(i);
            long temp=element;
            long n=0;
            while(!left.isEmpty() && left.peek().cost>element){
                Node node=left.pop();
                sum-=node.totalSum;
                n+=node.elements;
                temp+=node.elements*element;
            }
            sum+=temp;
            left.push(new Node((long)element,temp,n+1));
            leftArr[i]=sum;
        }
        
        sum=0;
        
        for(int i=size-1;i>=0;i--){
            long element=(long)maxHeights.get(i);
            long temp=element;
            long n=0;
            while(!right.isEmpty() && right.peek().cost>element){
                Node node=right.pop();
                sum-=node.totalSum;
                n+=node.elements;
                temp+=node.elements*element;
            }
            sum+=temp;
            right.push(new Node((long)element,temp,n+1));
            rightArr[i]=sum;
        }
        
        long ans=0;
        for(int i=0;i<size-1;i++){
            long temp=leftArr[i]+rightArr[i+1];
            ans=Math.max(temp,ans);
        }
        
    
        return ans;
        
    }
}