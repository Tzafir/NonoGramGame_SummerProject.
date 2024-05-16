import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class NanogramGrid extends JFrame {
    private final int row;
    private final int col;
    private final JButton[][] gridButtons;
    private final boolean[][] solutionNano;
    // constructor
    public NanogramGrid(boolean[][] solution) {
        this.solutionNano = solution;
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