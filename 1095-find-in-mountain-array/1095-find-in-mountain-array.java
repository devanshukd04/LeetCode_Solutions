/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */
 
class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int length=mountainArr.length();
        int peakIndex=peakIndexFinder(mountainArr,0,length-2);
        int index=binarySearchFirst(0,peakIndex,target,mountainArr);
        return index==-1?binarySearchLast(peakIndex,length-1,target,mountainArr):index;
    }
    
    public int peakIndexFinder(MountainArray mountainArr, int start, int end){
        
        int ans=0;
        while(start!=end){
            int mid=start+(end-start)/2;
            if(mountainArr.get(mid)<mountainArr.get(mid+1)){
                start=mid+1;
            }
            else{
                end=mid;
            }
        }
        return start;
    }
    public int binarySearchFirst(int start, int end, int target, MountainArray mountainArr){
        if(start>end){
            return -1;
        }
        int mid=start+(end-start)/2;
        int val=mountainArr.get(mid);
        if(val==target){
            int index=binarySearchFirst(start,mid-1,target,mountainArr);
            if(index==-1){
                return mid;
            }
            return index;
        }
        else if(val>target){
            return binarySearchFirst(start,mid-1,target,mountainArr);
        }
        else{
            return binarySearchFirst(mid+1,end,target,mountainArr);
        }
    }
    public int binarySearchLast(int start, int end, int target, MountainArray mountainArr){
        if(start>end){
            return -1;
        }
        int mid=start+(end-start)/2;
        int val=mountainArr.get(mid);
        if(val==target){
            int index=binarySearchLast(start,mid-1,target,mountainArr);
            if(index==-1){
                return mid;
            }
            return index;
        }
        else if(val>target){
            return binarySearchLast(mid+1,end,target,mountainArr);
        }
        else{
            return binarySearchLast(start,mid-1,target,mountainArr);
        }
    }
}