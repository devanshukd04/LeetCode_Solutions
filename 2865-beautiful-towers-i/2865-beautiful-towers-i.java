class Solution {
    public long maximumSumOfHeights(List<Integer> maxHeights) {
        long res=0;
        for(int i=0;i<maxHeights.size();i++){
            long ans=0;
            ans+=findSumLeft(i,maxHeights);
            ans+=findSumRight(i,maxHeights);
            ans+=(long)maxHeights.get(i);
            res=Math.max(ans,res);
        }
        return res;
    }
    public long findSumLeft(int index, List<Integer> maxHeights){
        long sum=0;
        int curr=maxHeights.get(index);
        index--;
        while(index>=0){
            int element=maxHeights.get(index);
            if(curr>=element){
                sum+=(long)element;
                curr=element;
            }
            else{
                sum+=(long)curr;
            }
            index--;
        }
        return sum;
    }
    public long findSumRight(int index, List<Integer> maxHeights){
        long sum=0;
        int curr=maxHeights.get(index);
        index++;
        while(index<maxHeights.size()){
            int element=maxHeights.get(index);
            if(curr>=element){
                sum+=(long)element;
                curr=element;
            }
            else{
                sum+=(long)curr;
            }
            index++;
        }
        return sum;
    }
}