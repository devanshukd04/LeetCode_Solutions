class Solution {
    public int[] findOriginalArray(int[] changed) {
        if(changed.length%2!=0){
            return new int[0];
        }
        Arrays.sort(changed);
        int j=0;
        int[] ans=new int[changed.length/2];
        int[] visited=new int[changed.length];
        for(int i=0;i<changed.length;i++){
            if(j==changed.length){
                return changed;
            }
            if(visited[i]!=1){
                int index=binarySearch(changed,visited,i,changed[i]*2);
                if(index==-1){
                    return new int[0];
                }
                visited[index]=1;
                ans[j]=changed[i];
                j++;
            }
        }
        return ans;
    }
    public int binarySearch(int[] changed,int[] visited,int i,int search){
        int start=i+1;
        int end=changed.length-1;
        while(start<=end){
            int mid=start+(end-start)/2;
            if(changed[mid]==search){
                while(mid>i && changed[mid]==search){
                    if(visited[mid]!=1){
                        return mid;
                    }
                    mid--;
                }
                mid=start+(end-start)/2;
                while(mid<changed.length && changed[mid]==search){
                    if(visited[mid]!=1){
                        return mid;
                    }
                    mid++;
                }
                return -1;
            }
            else if(changed[mid]<search){
                start=mid+1;
            }
            else{
                end=mid-1;
            }
        }
        
        return -1;
    }
}