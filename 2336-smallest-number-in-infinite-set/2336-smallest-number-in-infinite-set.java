class SmallestInfiniteSet {
    HashSet<Integer> a;
    int count=0;
    public SmallestInfiniteSet() {
        a=new HashSet<Integer>();
    }
    
    public int popSmallest() {
        if(a.size()==0){
            a.add(1);
            return 1;
        }
        else{
            int d=1;
            while(a.contains(d) && d<=1000){
                d++;
            }
            if(!a.contains(d)){
                a.add(d);
                return d;
            }
            return -1;
        }
    }
    
    public void addBack(int num) {
        if(a.contains(num)){
            a.remove(num);
        }
    }
}

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */