class Solution {
    public int climbStairs(int n) {
        if (n <= 3) {
            return n;
        }
        int firstStair = 1;
        int secondStair = 2;
        int total = 3;
        for (int a = 3; a <= n; a++) {
            total = firstStair + secondStair;
            firstStair = secondStair;
            secondStair = total;
        }

        return total;
    }
}