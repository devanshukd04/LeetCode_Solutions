class Solution {
    class Pair{
        int profit;
        int capital;
        Pair(int profit,int capital){
            this.profit=profit;
            this.capital=capital;
        }
    }
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        PriorityQueue<Pair> pqueue=new PriorityQueue<Pair>(new Comparator<Pair>(){
            public int compare(Pair a,Pair b){
                if(a.profit>b.profit){
                    return -1;
                }
                else if(a.profit==b.profit){
                    return a.capital-b.capital;
                }
                else{
                    return 1;
                }
            }
        });
        int[][] arr=new int[profits.length][2];
        for(int i=0;i<profits.length;i++){
            arr[i][0]=profits[i];
            arr[i][1]=capital[i];
        }
        Arrays.sort(arr,(a,b)->a[1]==b[1]?(a[0]-b[0]):(a[1]-b[1]));
        int index=0;
        while(k>0){
            while(index<arr.length && w>=arr[index][1]){
                pqueue.add(new Pair(arr[index][0],arr[index][1]));
                index++;
            }
            if(pqueue.isEmpty()){
                return w;
            }
            Pair pair=pqueue.poll();
            w+=pair.profit;
            k--;
        }
        return w;
    }
}