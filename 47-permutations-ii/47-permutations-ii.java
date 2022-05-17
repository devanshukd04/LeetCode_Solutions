class Solution {
    List<List<Integer>> a=new ArrayList<List<Integer>>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<Integer> b=new ArrayList<Integer>();
        List<Integer> d=new ArrayList<Integer>();
        for(int i=0;i<nums.length;i++){
            d.add(nums[i]);
        }
        permutation(d,b);
        return a;
    }
    public void permutation(List<Integer> d,List<Integer> b){
        int a1;
        if(d.size()==0){
            if(!a.contains(b)){
                List<Integer> c=new ArrayList<Integer>();
                c.addAll(b);
                a.add(c);
            }
            return;
        }
        a1=d.get(0);
        d.remove(0);
        for(int i=0;i<=b.size();i++){
            b.add(i,a1);
            permutation(d,b);
            b.remove(i);
        }
        d.add(0,a1);
    }
}