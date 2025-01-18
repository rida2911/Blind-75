class Solution {
  public int getSum(int a, int b) {
    while (b != 0) {           // Still have carry bits.
      final int carry = a & b; // Record the carry bits.
      a ^= b;                  
      b = carry << 1;
    }
    return a;
  }
}


//Time: O(32)
//Space: O(1)

