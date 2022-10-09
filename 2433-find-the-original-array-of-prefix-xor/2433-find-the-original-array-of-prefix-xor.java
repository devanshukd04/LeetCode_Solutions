class Solution {
    public int[] findArray(int[] pref) {
        //Creating an ans array
        int[] ans=new int[pref.length];
        int prev=0;
        for(int i=0;i<pref.length;i++){
            //Getting the prev XOR pref[i] as our current answer
            ans[i]=prev^pref[i];
            //Storing pref[i] as prev
            prev=pref[i];
        }
        return ans;
    }
}