public class NonogramLabel{
public static String[] getRowNumbers(int[][] solutionNono) {
    String[] rowNumber = new String[solutionNono.length];
    for (int i = 0; i < solutionNono.length; i++) {
        String rowNumbers = "";
        int blackCount = 0;
        int redCount = 0;
        for (int j = 0; j < solutionNono[i].length; j++) { // For loop going through the Array
            if (solutionNono[i][j] == 1) {  ////Every time a colours come in consecutively//
                if (redCount > 0) {          //it's counters will go up until a zero or another color is seen.//
                    rowNumbers += redCount + "R";
                    redCount = 0;
                }
                blackCount++;
            } else if (solutionNono[i][j] == 2) {
                if (blackCount > 0) {
                    rowNumbers += blackCount + "B";
                    blackCount = 0;
                }
                redCount++;
            } else if (solutionNono[i][j] == 0) {
                if (blackCount > 0 ) {
                    rowNumbers += blackCount + "B ";
                    blackCount = 0;
                }
                if (redCount > 0 ) {
                    rowNumbers += redCount + "R ";
                    redCount = 0;
                }
            }
        }
        if (blackCount > 0) {
            rowNumbers += blackCount + "B";
        } else if (redCount > 0) {
            rowNumbers += redCount + "R";
        }
        if (rowNumbers.isEmpty()) {
            rowNumbers = "0";
        }
        rowNumber[i] = rowNumbers;
    }
    return rowNumber;
}
//Same as Row but get's Numbers for column
public static String[] getColumnNumbers(int[][] solutionNono) {
    String[] colNumber = new String[solutionNono[0].length];
    for (int j = 0; j < solutionNono[0].length; j++) {
        String colNumbers = "";
        int blackCount = 0;
        int redCount = 0;
        for (int i = 0; i < solutionNono.length; i++) {
            if(solutionNono[i][j] == 1) {
                if (redCount > 0){
                    colNumbers += redCount +"R";
                    redCount = 0;
                }
                blackCount++;
            }else if(solutionNono[i][j] == 2){
                if(blackCount > 0){
                    colNumbers += blackCount +"B";
                    blackCount = 0;
                }
                redCount++;
            }else if(solutionNono[i][j] == 0){
                if(blackCount > 0){
                    colNumbers += blackCount +"B ";
                    blackCount = 0;
                }
                if (redCount > 0){
                    colNumbers += redCount +"R ";
                    redCount = 0;
                }
            }
        }
        if (blackCount > 0) {
            colNumbers += blackCount + "B";
        } else if (redCount > 0) {
            colNumbers += redCount + "R";
        }
        if (colNumbers.isEmpty()) {
            colNumbers = "0";
        }
        colNumber[j] = colNumbers;
    }
    return colNumber;
}
}
