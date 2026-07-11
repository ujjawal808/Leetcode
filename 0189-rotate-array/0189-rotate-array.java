class Solution {
    public void reverse(int nums[],int left,int right){
        while(left<right){
            int temp=nums[left];
            nums[left]=nums[right];
            nums[right]=temp;
            left++;
            right--;
        }
    }
    public void rotate(int[] nums, int k) {
        int n=nums.length;
         k=k%n;
        // //  By creating a new Array
        // int arr[]=new int[n];
        // for(int i=0;i<n;i++){
        //     arr[(i + k)% n]=nums[i];

        // }
        // for(int i=0;i<n;i++){
        //    nums[i]=arr[i];
        // }
        reverse(nums,0,n-1);
        reverse(nums,0,k-1);
        reverse(nums,k,n-1);
    }
}