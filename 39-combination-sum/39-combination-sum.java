class Solution {
    List<List<Integer>> a1=new ArrayList<List<Integer>>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> a=new ArrayList<Integer>();
        helper(a,candidates,target,0);
        return a1;
    }
    public void helper(List<Integer> a, int[] candidates, int target,int sum){
        if(sum==target){
            List<Integer> b=new ArrayList<Integer>();
            b.addAll(a);
            Collections.sort(b);
            if(!a1.contains(b)){
                a1.add(b);
            }
            return;
        }
        else if(sum>target){
            return;
        }
        for(int i=0;i<candidates.length;i++){
            a.add(candidates[i]);
            helper(a,candidates,target,sum+candidates[i]); 
            a.remove(a.size()-1);
        }
    }
}