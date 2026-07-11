class Solution {
    public static boolean isPalindrome(int x) {
        int revnum=0;
        int ognum=x;
        while(x>0){
            int ld=x%10;
            revnum=revnum*10+ld;
            x=x/10;
        }
        if(revnum==ognum){
            return true;
        }
        else{
            return false;
        }

        
    }
    
}