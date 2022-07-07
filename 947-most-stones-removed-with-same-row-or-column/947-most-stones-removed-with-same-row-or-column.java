class Solution {
    int[] arr = new int[20000];
    
    public int removeStones(int[][] stones) {
        for(int i=0;i<arr.length;i++)
            arr[i] = i;
        
        for(int[] stone: stones) {
            union(stone[0], stone[1]+10000);
        }
        
        Set<Integer> seen = new HashSet();
        for (int[] stone: stones)
            seen.add(find(stone[0]));

        return stones.length - seen.size();
    }
    
    public int find(int x) {
        while(arr[x] != x) {
            x = arr[x];
        }
        
        return x;
    }
    
    public void union(int x, int y) {
        int find_x = find(x);
        int find_y = find(y);
        arr[find_x] = find_y;
    }
}