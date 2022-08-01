class Solution {
    public int maximumGroups(int[] grades) {
        Arrays.sort(grades);
        int count=0;
        int group_size=1;
        int sum=0;
        int i=0;
        while(i<grades.length){
            if(i+group_size<=grades.length){
                i+=group_size;
                sum+=group_size;
                group_size++;
                count++;   
            }
            else{
                break;
            }
        }
        return count;
    }
}