public class NonogramLabel {
    public static String[] getRowNumbers(int[][] solutionNono) {
        String[] rowNumber = new String[solutionNono.length];
        for (int i = 0; i < solutionNono.length; i++) {
            String rowNumbers = "";
            int count = 0;
            for (int j = 0; j < solutionNono[i].length; j++) {

                if (solutionNono[i][j] != 0) { // we Check that the element is non-zero and add it to the counter
                    count++;
                } else {
                    if (count > 0) { // If the element is zero then we add the count to the variable rowNumbers.
                        rowNumbers += count + " ";
                        count = 0;
                    }
                }
            }
            if (count > 0) {
                rowNumbers += count; // In case the last element is not non-zero.
            }
            if (rowNumbers.isEmpty()) {
                rowNumbers = "0";
            }
            rowNumber[i] = rowNumbers;
        }
        return rowNumber;
    }
    public static String[] getColumnNumbers(int[][] solutionNono) {
        String[] colNumber = new String[solutionNono.length];
        for (int j = 0; j < solutionNono[0].length; j++) {
            String colNumbers = "";
            int count = 0;
            for (int i = 0; i < solutionNono.length; i++) {
    
                if (solutionNono[i][j] != 0) {
                    count++;
                } else {
                    if (count > 0) {
                        colNumbers += count +" ";
                        count = 0;
                    }
                }
            }
            if (count > 0) {
                colNumbers += count;
            }
            if (colNumbers.isEmpty()) {
                colNumbers = "0";
            }
            colNumber[j] = colNumbers;
        }
        return colNumber;
    }
    
}
