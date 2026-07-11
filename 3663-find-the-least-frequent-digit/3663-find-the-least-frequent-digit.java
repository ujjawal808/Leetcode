class Solution {
    public int getLeastFrequentDigit(int n) {
        int freq[]=new int[10];
        while(n>0){
            int ld=n%10;
            freq[ld]++;
            n=n/10;
        }
        
        int ans = -1;
        int minFreq = Integer.MAX_VALUE;

        for (int i = 0; i < 10; i++) {
            if (freq[i] > 0 && freq[i] < minFreq) {
                minFreq = freq[i];
                ans = i;
            }
        }

        return ans;
       
    }
}