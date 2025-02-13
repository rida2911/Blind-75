class Solution {
    public int climbStairs(int n) {
        if (n == 1) return 1;  // If there's only 1 step, only 1 way to climb
        if (n == 2) return 2;  // If there are 2 steps, two ways (1+1 or 2)

        int first = 1, second = 2;
        for (int i = 3; i <= n; i++) {
            int temp = first + second;
            first = second;
            second = temp;
        }
        return second;
    }
}
