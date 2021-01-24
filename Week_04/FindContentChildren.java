class Solution {
    public int findContentChildren(int[] g, int[] s) {
        //先对胃口值和饼干尺寸进行排序
        Arrays.sort(g);
        Arrays.sort(s);
        int count = 0;
        for (int j = 0; count < g.length && j < s.length; j++) {
            //如果当前饼干能满足当前孩子的胃口值，count就加1，否则就继续查找更大的饼干
            if (g[count] <= s[j])
                count++;
        }
        return count;
    }
}