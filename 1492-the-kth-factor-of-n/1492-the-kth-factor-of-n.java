class Solution {
    public int kthFactor(int n, int k) {
        List<Integer> list1=new ArrayList<>();
        List<Integer> list2=new ArrayList<>();
        for(int i=1;i*i<=n;i++){
            int factor1=i;
            int factor2=n/i;
            if(n%i==0){
                if(factor1!=factor2){
                    list1.add(factor1);
                    list2.add(factor2);
                }
                else{
                    list1.add(factor1);
                }
            }
        }
        if(list1.size()+list2.size()<k){
            return -1;
        }
        if(list1.size()>=k){
            return list1.get(k-1);
        }
        k-=list1.size();
        return list2.get(list2.size()-k);
    }
}