class Solution {
    
    private String getKey(String str) {
        int[] map = new int[26];
        for(int i = 0; i< str.length(); i++) {
            map[str.charAt(i) - 'a']++;
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i<26; i++) {
            sb.append(map[i]);
            sb.append("@");
        }
        
        return sb.toString();
    }
    
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> hashMap = new HashMap<>();
        for(String str: strs) {
            String key = getKey(str);
            List<String> l = hashMap.getOrDefault(key, new ArrayList<String>());
            l.add(str);
            hashMap.put(key, l);
        }
        
        return new ArrayList<>(hashMap.values());
    }
}