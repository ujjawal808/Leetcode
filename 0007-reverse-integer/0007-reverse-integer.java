class Solution {
    public int reverse(int x) {
        int rev=0;
        while(x!=0){
        int ld=x%10;
         if (rev > Integer.MAX_VALUE / 10 ||
                (rev == Integer.MAX_VALUE / 10 && ld > 7))
                return 0;

            if (rev < Integer.MIN_VALUE / 10 ||
                (rev == Integer.MIN_VALUE / 10 && ld < -8))
                return 0;
                
              rev=rev*10+ld;
             x=x/10;
        }
             return rev;
        
        
    }
}
// Why 7 and -8?
// Integer.MAX_VALUE = 2147483647 (last digit is 7)
// Integer.MIN_VALUE = -2147483648 (last digit is -8)

// If rev is already 214748364 and the next digit is greater than 7, the result would exceed the maximum int.