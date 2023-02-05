class Solution {
    public int maxCount(int[] banned, int n, int maxSum) {
        HashSet<Integer> set=new HashSet<Integer>();
        for(int num:banned){
            set.add(num);
        }
        int ans=0;
        int count=0;
        int i=1;
        while(i<=n){
            if(!set.contains(i)){
                if((ans+i)>maxSum){
                    return count;
                }
                ans+=i;
                ++count;
            }
            ++i;
        }
        return count;
    }
}