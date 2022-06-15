class Solution {
    
    private List<List<int[]>> convert(int[][] mat) {
        List<List<int[]>> converted = new ArrayList<>();
        for(int i = 0; i < mat.length; i++) {
            
            List<int[]> row = new ArrayList<>();
            for(int j = 0; j < mat[0].length; j++) {
                if ( mat[i][j] != 0 ) {
                    row.add(new int[]{mat[i][j], j});
                }
            }
            
            converted.add(row);
        }
        return converted;
    }
    
    public int[][] multiply(int[][] mat1, int[][] mat2) {
        List<List<int[]>> mat1Converted = convert(mat1);
        List<List<int[]>> mat2Converted = convert(mat2);
        
        int[][] result = new int[mat1.length][mat2[0].length];
        
        for(int i = 0; i < mat1.length; i++) {
            List<int[]> currentRowOfMat1 = mat1Converted.get(i);
            for(int[] cellsOfMat1: currentRowOfMat1) {
                List<int[]> rowOfMat2ColOfMat1 = mat2Converted.get(cellsOfMat1[1]);
                for(int[] cellsOfMat2: rowOfMat2ColOfMat1) {
                    result[i][cellsOfMat2[1]] += cellsOfMat1[0] * cellsOfMat2[0];
                }
            }
        }
        
        return result;
    }
}