class Solution {
    public int majorityElement(int[] nums) {
        for(int i=0;i<nums.length;i++){
            int count=0;
            for(int j=0;j<nums.length;j++){
                if(nums[i]==nums[j]){
                    count++;
                }   
            }
            if(count>nums.length/2){//This logic defines whether the number consists majority .
                return nums[i];
            }
            

        }
        return -1;
        
    }
}