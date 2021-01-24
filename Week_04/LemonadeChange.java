class Solution {
    public boolean lemonadeChange(int[] bills) {
        //统计店员所拥有的5元和10元的数量
        int five = 0, ten = 0;
        for (int bill : bills) {
            if (bill == 5) {
                // 如果顾客使用的是5元，不用找零，5元数量加1
                five++;
            } else if (bill == 10) {
                // 如果顾客使用的是10元，需要找他5元，所以5元数量减1，10元数量加1
                five--;
                ten++;
            } else if (ten > 0) {
                // 如果顾客使用的只能是20元，先给他10元的，然后再给他5元的，所以这里5元和10元数量都要减1
                ten--;
                five--;
            } else {
                // 如果顾客使用的是20元，没有10元的，只能找3个5元的，所以5元的数量要减3
                five -= 3;
            }

            // 如果5元的数量小于0，说明上面某一步找零的时候5元不足了，直接返回false即可
            if (five < 0) {
                return false;
            }
        }
        return true;
    }
}