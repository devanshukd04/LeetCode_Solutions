class LUPrefix {
    TreeSet<Integer> set;
    int n;
    public LUPrefix(int n) {
        set=new TreeSet<Integer>();
        for(int i=1;i<=n;i++){
            this.set.add(i);
        }
        this.n=n;
    }
    
    public void upload(int video) {
        this.set.remove(video);
    }
    
    public int longest() {
        return this.set.isEmpty()?this.n:this.set.first()-1;
    }
}

/**
 * Your LUPrefix object will be instantiated and called as such:
 * LUPrefix obj = new LUPrefix(n);
 * obj.upload(video);
 * int param_2 = obj.longest();
 */