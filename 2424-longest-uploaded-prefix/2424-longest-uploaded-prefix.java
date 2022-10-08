class LUPrefix {
    HashSet<Integer> set;
    int max=0;
    public LUPrefix(int n) {
        set=new HashSet<Integer>();
    }
    
    public void upload(int video) {
        this.set.add(video);
        while(this.set.contains(this.max+1)){
            this.max++;
        }
    }
    
    public int longest() {
        return this.max;
    }
}

/**
 * Your LUPrefix object will be instantiated and called as such:
 * LUPrefix obj = new LUPrefix(n);
 * obj.upload(video);
 * int param_2 = obj.longest();
 */