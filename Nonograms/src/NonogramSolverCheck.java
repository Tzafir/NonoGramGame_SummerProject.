import javax.swing.JButton;
import java.awt.Color;

public class NonogramSolverCheck {
    public static boolean testSolution(int[][]solutionNono, JButton[][] gridbuttons){
        int row = solutionNono.length;
        int col = solutionNono[0].length;
        for (int i = 0;i<row;i++){
            for(int j = 0;j<col;j++){
                if (gridbuttons[i][j].getBackground() == Color.BLACK){
                    if(solutionNono[i][j] == 0){
                        return false;
                    }
                }else if (gridbuttons[i][j].getBackground() == Color.WHITE){
                    if(solutionNono[i][j] != 0){
                        return false;
                    }
                }else if (gridbuttons[i][j].getBackground() == Color.YELLOW){
                    return false;
                }
                }
                }
            return true;
        }
    }
