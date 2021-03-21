class Solution {
    public String reverseWords(String s) {
        int length = s.length();
        char[] chars = new char[length];
        int a = 0;
        for (int i = 0; i < length; i++) {
                while (i < length && s.charAt(i) != ' ') {
                    // 找出空格
                    i++;
                }
                for (int j = a; j < i; j++) {
                    // 交换
                    chars[j] = s.charAt(a + (i-1-j));
                }
                if (i < length-1) {
                    // 若不是最后一个，则添加空格
                    chars[i] = ' ';
                    a = i+1;
                }
        }
        String re = new String(chars);
        return re;
    }
}