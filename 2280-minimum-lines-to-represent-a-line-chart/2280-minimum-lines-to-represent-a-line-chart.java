class Solution {
    public int minimumLines(int[][] stockPrices) {
        double a;
        HashMap<Double,Integer> b=new HashMap<Double,Integer>();
        Arrays.sort(stockPrices, (a1, b1) -> Integer.compare(a1[0], b1[0]));
        if(stockPrices.length<=1){
            return 0;
        }
        double[] c=new double[stockPrices.length-1];
        int count=0;
        for(int i=2;i<stockPrices.length;i++){
            if(((stockPrices[i][1]-stockPrices[i-1][1])*(stockPrices[i-1][0]-stockPrices[i-2][0]))!=((stockPrices[i][0]-stockPrices[i-1][0])*(stockPrices[i-1][1]-stockPrices[i-2][1]))){
                ++count;
            }
        }
        return count+1;
    }
}