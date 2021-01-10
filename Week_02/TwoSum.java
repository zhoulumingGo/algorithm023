class Solution {
    public int[] twoSum(int[] nums, int target) {
        // 异常情况处理
        if (nums == null) {
            return new int[0];
        }

        int n = nums.length;
        // 第一层循环，从第一个元素开始，循环到最后一个元素
        for (int i = 0; i < n; i++) {
            // 第二层循环，由于1、前面已经匹配过 2、数组中同一个元素不能使用两遍，所以从上一层循环的下一个元素开始，循环到最后一个元素
            for (int j = i + 1; j < n; j++) {
                // 判断是否成立
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }

        // 如果没有匹配情况
        return new int[0];
    }
}