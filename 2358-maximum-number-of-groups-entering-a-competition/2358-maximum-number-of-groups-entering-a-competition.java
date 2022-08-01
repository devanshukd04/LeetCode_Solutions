class Solution {
    public int maximumGroups(int[] grades) {
        Arrays.sort(grades);
        int group_size=1;
        int i=0;
        while(i<grades.length){
            if(i+group_size<=grades.length){
                i+=group_size;
                group_size++;
            }
            else{
                break;
            }
        }
        return --group_size;
    }
}