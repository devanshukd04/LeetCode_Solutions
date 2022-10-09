class Solution {
    public int[] findArray(int[] pref) {
        int[] ans=new int[pref.length];
        int prev=0;
        for(int i=0;i<pref.length;i++){
            ans[i]=prev^pref[i];
            prev=pref[i];
        }
        return ans;
    }
}