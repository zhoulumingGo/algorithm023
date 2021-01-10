class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // 排序法
        HashMap<String, ArrayList<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] ch = s.toCharArray();
            // 先排序再放入哈希表
            Arrays.sort(ch);
            String key = String.valueOf(ch);
            if (!map.containsKey(key)) {
                map.put(key,new ArrayList<>());
            }
            map.get(key).add(s);
        }

        return new ArrayList(map.values());
    }
}