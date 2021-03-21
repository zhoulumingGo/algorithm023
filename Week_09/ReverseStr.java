class Solution {
    public String reverseStr(String s, int k) {
        char[] a = s.toCharArray();
	    int i = 0;
	    int j = 0;
	    char tmp;
        for (int start = 0; start < a.length; start += 2 * k) {
            i = start;
	        j = Math.min(start + k - 1, a.length - 1);
            while (i < j) {
                tmp = a[i];
                a[i++] = a[j];
                a[j--] = tmp;
            }
        }
        
        return new String(a);
    }
}