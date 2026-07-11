class Solution {
    public int[] concatWithReverse(int[] nums){
        int n=nums.length;
        int ans[]=new int[2*n];
        for(int i=0;i<nums.length;i++){
            ans[i]=nums[i];
            ans[i+n]=nums[n-i-1];
        }
        return ans;
        
    }
}