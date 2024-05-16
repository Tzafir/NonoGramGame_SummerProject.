import javax.swing.SwingUtilities;

public class NonogramApp {
    public static void main(String[] args){
        boolean[][] solutionNano = {
            {true, false, true, false, true},
            {true, false, true, false, true},
            {true, false, true, false, true},
            {true, false, true, false, true},
            {true, false, true, false, true},
        };
        SwingUtilities.invokeLater(() -> {
            new NanogramGrid(solutionNano);
        });
    }
}
