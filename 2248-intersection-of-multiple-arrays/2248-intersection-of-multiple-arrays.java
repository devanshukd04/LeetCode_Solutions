class Solution {
    public List<Integer> intersection(int[][] nums) {
        List<Integer> a=new ArrayList<Integer>();
        List<Integer> b=new ArrayList<Integer>();
        List<Integer> c=new ArrayList<Integer>();
        int d;
        for(int i=0;i<nums.length;i++){
            for(int j=0;j<nums[i].length;j++){
                if(i==0){
                    b.add(nums[i][j]);
                    c.add(1);
                }
                else{
                    if(b.contains(nums[i][j])){
                        d=b.indexOf(nums[i][j]);
                        c.set(d,c.get(d)+1);
                    }
                }
            }
        }
        for(int i=0;i<c.size();i++){
            if(c.get(i)==nums.length){
                a.add(b.get(i));
            }
        }
        Collections.sort(a);
        return a;
    }
}