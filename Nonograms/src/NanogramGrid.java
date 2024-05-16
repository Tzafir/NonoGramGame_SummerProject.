import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class NanogramGrid extends JFrame {
    //Atributes for the class NanogramGrid
    //Also includes getter methods
    private final int row;
    private final int col;
    private final JButton[][] gridButtons;
    private final int[][] solutionNono;
    private String[] getRowNumbers(int[][] solutionNono){
        String[] rowNumber = new String[solutionNono.length];
        for(int i = 0;i<solutionNono.length;i++){
            String rowNumbers = "";
            int count = 0;
            for(int j = 0;j<solutionNono[i].length;j++){
                
                if (solutionNono[i][j] != 0){ //we Check that the element is non-zero and add it to the counter
                    count++;
                }else{
                    if(count>0){ //If the element is zero then we add the count to the variable rowNumbers.
                        rowNumbers += count ;
                        count = 0;
                    }
                }
            }
            if (count>0){
                rowNumbers += count;//In case the last element is not non-zero.
            }
            if (rowNumbers.isEmpty()) {
                rowNumbers = "0";
            }
            rowNumber[i] = rowNumbers;
        }
        return rowNumber;
    }
    private String[] getColumnNumbers(int[][] solutionNano){
        String[] colNumber = new String[solutionNono.length];
        for(int j = 0;j<solutionNono[0].length;j++){
            String colNumbers = "";
            int count = 0;
            for(int i = 0;i<solutionNono.length;i++){
                
                if (solutionNono[i][j] != 0){
                    count++;
                }else{
                    if(count>0){
                        colNumbers += count ;
                        count = 0;
                    }
                }
            }
            if (count>0){
                colNumbers += count;
            }
            if (colNumbers.isEmpty()) {
                colNumbers = "0";
            }
            colNumber[j] = colNumbers;
        }
        return colNumber;
    }
    // constructor
    public NanogramGrid(int [][] solution) {
        this.solutionNono = solution;
        this.row = solution.length;
        this.col = solution[0].length;

        setTitle("Nanogram");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        //Creating The layout with JPanel for the grid
        JPanel gridNano = new JPanel();
        gridNano.setLayout(new GridLayout(row, col));
        gridButtons = new JButton[row][col];

        // Creating grid buttons
        //Done using a nested for loop
        //Each Button will have a Mouse listener
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                JButton button = new JButton();
                button.setBackground(Color.YELLOW);
                button.setOpaque(true);
                button.setBorderPainted(false);
                button.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        if (SwingUtilities.isLeftMouseButton(e)){
                            if (button.getBackground() == Color.BLACK){
                                button.setBackground(Color.YELLOW);
                            } else {
                                button.setBackground(Color.BLACK);
                            }
                        }else if (SwingUtilities.isRightMouseButton(e)) {
                            button.setBackground(Color.WHITE);
                        }

                    }
                });
                gridButtons[i][j] = button;
                gridNano.add(button);
            }
        }

        add(gridNano, BorderLayout.CENTER);

        // Set size and visibility
        pack();
        setVisible(true);
    
    }
}
