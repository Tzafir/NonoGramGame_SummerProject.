import javax.swing.SwingUtilities;

public class NonogramApp {
    public static void main(String[] args){
        int[][] solutionNono = {
            {1, 0, 0, 1, 0},
            {1, 0, 0, 1, 0},
            {0, 0, 0, 1, 0},
            {1, 0, 0, 1, 0},
            {1, 0, 0, 1, 0},
        };
        SwingUtilities.invokeLater(() -> {
            new NanogramGrid(solutionNono);
        });
    }
}
