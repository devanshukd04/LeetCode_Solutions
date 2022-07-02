class Solution {
    public List<String> buildArray(int[] target, int n) {
        List<String> target1=new ArrayList<String>();
        int i=0;
        for(int j=1;j<=target[target.length-1];j++){
            if(target[i]==j){
                target1.add("Push");
                ++i;
            }
            else{
                target1.add("Push");
                target1.add("Pop");
            }
        }
        return target1;
    }
}