 public class Solution{
 public static int myAtoi(String s) {
    // Handle null or empty string first
    if (s == null || s.isEmpty()) {
        return 0;
    }

    int i = 0;
    int n = s.length();

    // Skip leading spaces
    while (i < n && s.charAt(i) == ' ') {
        i++;
    }

    // Determine sign
    int sign = 1;
    if (i < n && (s.charAt(i) == '+' || s.charAt(i) == '-')) {
        if (s.charAt(i) == '-') {
            sign = -1;
        }
        i++;
    }

    int result = 0;

    while (i < n) {
        char ch = s.charAt(i);

        if (ch < '0' || ch > '9') {
            break;
        }

        int digit = ch - '0';

        // Check overflow before calculating
        if (result > Integer.MAX_VALUE / 10 ||
            (result == Integer.MAX_VALUE / 10 && digit > 7)) {
            return sign == 1
                    ? Integer.MAX_VALUE
                    : Integer.MIN_VALUE;
        }

        result = result * 10 + digit;
        i++;
    }

    return result * sign;
}
 }
// Act as an Senior Java Developer.
// Task: Converts a String into a 32 bit  signed integer and return the integer as the final result.
// The algorithm for myAtoi(string s) is as follows:

// Whitespace: Ignore any leading whitespace (" ").
// Signedness: Determine the sign by checking if the next character is '-' or '+', assuming positivity if neither present.
// Conversion: Read the integer by skipping leading zeros until a non-digit character is encountered or the end of the string is reached. If no digits were read, then the result is 0.
// Rounding: If the integer is out of the 32-bit signed integer range [-231, 231 - 1], then round the integer to remain in the range. Specifically, integers less than -231 should be rounded to -231, and integers greater than 231 - 1 should be rounded to 231 - 1.
// Input:String s, Exp- s = "42".
// Output:int ,Exp=42.

// Constraints:
// 1.Language:Java,only standard libraries.
// 2. Time complexity:O(n) or O(n log n) or better ,Space O(1)/O(n).
// 3.Edge Cases:null,empty,single element,duplicates,large values , 0 <= s.length <= 200
// s consists of English letters (lower-case and upper-case), digits (0 - 9), ' ', '+', '-', and '.'.
// 4. Keep this Signature:int myAtoi(String s).
// 5.Don't use HashMap,recursion ,built insort.​​​​​​​ You must not use any built-in library function that converts a string to a number (for example, atoi, stoi, Integer.parseInt, int(), parseInt, Number()). Perform the conversion manually.

// // Deliver:
// 1.Completely runnable code with important line comments  and Space and time Complexity.
// 2.Explain approach in 2-3 lines.
// 3.5 test Cases with expected output.
