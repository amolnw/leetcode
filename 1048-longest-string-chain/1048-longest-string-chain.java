class Solution {
    public int longestStrChain(String[] words) {
        HashMap<String, Integer> hashMap = new HashMap<>();
        Arrays.sort(words, (a,b) -> a.length() - b.length());
        int maxChainForAllWords = 0;
        for(String word: words) {
            int maxChainForWord = 0;
            for(int i = 0; i < word.length(); i++) {
                String current = word.substring(0, i) + word.substring(i+1);
                maxChainForWord = Math.max(maxChainForWord, hashMap.getOrDefault(current, 0) + 1);
            }
            hashMap.put(word, maxChainForWord);
            maxChainForAllWords = Math.max(maxChainForAllWords, maxChainForWord);
        }
        
        return maxChainForAllWords;
    }
}