class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (a, b) -> {return b[1] - a[1];});
        int sum=0;
        int a=0;
        int csum=0;
        for(int i=0;i<boxTypes.length && csum+boxTypes[i][0]<=truckSize;i++){
            csum+=boxTypes[i][0];
            sum+=boxTypes[i][0]*boxTypes[i][1];
            a=i;
        }
        a++;
        for(int i=1;a<boxTypes.length && i<=boxTypes[a][0] && csum+1<=truckSize;i++){
            csum+=1;
            sum+=boxTypes[a][1];
        }
        return sum;
    }
}