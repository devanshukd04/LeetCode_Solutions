class Solution {
    List<Integer> b=new ArrayList<Integer>();
    public List<Integer> lexicalOrder(int n) {
        for(int j=1;j<10;j++){
            order(j,n);
        }
        return b;
    }
    public void order(int i, int n){
        if(i>n){
            return;
        }
        b.add(i);
        for(int j=0;j<10;j++){
            order(10*i+j,n);
        }
    }
}