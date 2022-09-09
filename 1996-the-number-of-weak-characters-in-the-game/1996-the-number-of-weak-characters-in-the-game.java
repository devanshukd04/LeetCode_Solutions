class Solution {
    public int numberOfWeakCharacters(int[][] properties) {
        Arrays.sort(properties,(a,b)->(a[0]==b[0]?a[1]-b[1]:b[0]-a[0]));
        int defense=0;
        int ans=0;
        for(int[] arr:properties){
            if(arr[1]<defense){
                ans++;
            }
            defense=defense>arr[1]?defense:arr[1];
        }
        return ans;
    }
}