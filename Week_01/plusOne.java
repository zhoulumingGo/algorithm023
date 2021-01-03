class Solution {
    public int[] plusOne(int[] digits) {
        int length = digits.length;

        // 从数组的最右边循环到最左边，即从数的低位循环到高位
        for (int i = length - 1; i >= 0; i--) {
            // 当前位数加1
            digits[i]++;
            // 除10取余数
            digits[i] %= 10;
            // 不是9+1的情况，digits[i]不变，直接返回数组
            if (digits[i] != 0) return digits;
            // 是9+1的情况，digits[i]变成0，进入下一次循环，进一位
        }
        // 如果数组中所有元素是9的情况，就将数组长度增加一位，第一个元素值设置为1
        digits = new int[length + 1];
        digits[0] = 1;
        
        return digits;
    }
}