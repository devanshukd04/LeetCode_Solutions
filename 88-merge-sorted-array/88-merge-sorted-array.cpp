class Solution {
public:
    void merge(vector<int>& nums1, int m, vector<int>& nums2, int n) {
        vector<int> result;
        int start1 =0;
        int start2 = 0;
        int end1=m-1;
        int end2=n-1;
        while(start1<=end1 && start2<=end2){
            if(nums1[start1]<nums2[start2]){
                result.push_back(nums1[start1]);
                start1++;
            }
            else{
                result.push_back(nums2[start2]);
                start2++;
            }
            
        }
        while(start1<=end1){
            result.push_back(nums1[start1]);
                start1++;
        }
        while(start2<=end2){
            result.push_back(nums2[start2]);
                start2++;
        }
        for(int k=0;k<result.size();k++){
            nums1[k] = result[k];
        }
        
    }
};