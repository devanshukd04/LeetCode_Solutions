class Solution {
    List<List<Integer>> a=new ArrayList<List<Integer>>();
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<Integer> c=new ArrayList<Integer>();
        combination(k,n,1,c);
        return a;
    }
    public void combination(int k,int n,int start,List<Integer> c){
        int b;
        if(k==0 && n==0){
            List<Integer> d=new ArrayList<Integer>();
            d.addAll(c);
            a.add(d);
            return;
        }
        else if(k<0 || n<0){
            return;
        }
        for(int i=start;i<=n && i<10;i++){
            c.add(i);
            combination(k-1,n-i,i+1,c);
            b=c.size();
            c.remove(b-1);
        }
    }
}