import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class NanogramGrid extends JFrame {
    // Attributes for the class NanogramGrid
    // Also includes getter methods
    private final int row;
    private final int col;
    private final JButton[][] gridButtons;
    private final int[][] solutionNono;
    private Color selectedColor = Color.BLACK;
    private boolean testSolution(){
        return NonogramSolverCheck.testSolution(solutionNono, gridButtons);
    }
    private String[] getRowNumbers(int[][] solutionNono) {
        return NonogramLabel.getRowNumbers(solutionNono);
    }

    private String[] getColumnNumbers(int[][] solutionNono) {
        return NonogramLabel.getColumnNumbers(solutionNono);
    }


    // constructor
    public NanogramGrid(int[][] solution) {
        this.solutionNono = solution;
        this.row = solution.length;
        this.col = solution[0].length;

        setTitle("Nanogram");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Creating The layout with JPanel for the grid
        JPanel mainPanel = new JPanel(new BorderLayout());
        JPanel rowPanel = new JPanel(new GridLayout(row, 1));
        JPanel columnPanel = new JPanel(new GridLayout(1, col));
        JPanel gridPanel = new JPanel(new GridLayout(row, col));
        // Adding the Row labels
        String[] rowNumbers = getRowNumbers(solution);
        for (String rowNumber : rowNumbers) {
            JLabel label = new JLabel(rowNumber, SwingConstants.CENTER);
            label.setPreferredSize(new Dimension(60, 40));
            rowPanel.add(label);
        }
        // Adding the Column labels
        String[] colNumbers = getColumnNumbers(solution);
        for (String colNumber : colNumbers) {
            JLabel label = new JLabel(colNumber, SwingConstants.CENTER);
            label.setPreferredSize(new Dimension(60, 40));
            columnPanel.add(label);
        }

        gridButtons = new JButton[row][col];
        Dimension buttonSize = new Dimension(50, 50);
         //Buttons for toggling between red and black
         //Black
        JButton selectBlackButton = new JButton("Black");
        selectBlackButton.setBackground(Color.BLACK);
        selectBlackButton.addActionListener(e -> {
            selectedColor = Color.BLACK;
        });
        //RED
        JButton selectRedButton = new JButton("RED");
        selectRedButton.setBackground(Color.RED);
        selectRedButton.addActionListener(e -> {
            selectedColor = Color.RED;
        });
        //Creating a JPanel that will be played North so that the user can select between the two colours
        JPanel colorSelectionPanel = new JPanel();
        colorSelectionPanel.setLayout(new FlowLayout());
        colorSelectionPanel.add(selectRedButton);
        colorSelectionPanel.add(selectBlackButton);
        add(colorSelectionPanel, BorderLayout.NORTH);

        // Create the grid panel for the nonogram
        gridPanel.setLayout(new GridLayout(solution.length, solution[0].length));
        // Creating grid buttons
        // Done using a nested for loop
        // Each Button will have a Mouse listener
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                JButton button = new JButton();
                button.setPreferredSize(buttonSize);
                gridButtons[i][j] = button;
                button.setBackground(Color.YELLOW);
                button.setOpaque(true);
                button.setBorderPainted(false);
                button.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        if (SwingUtilities.isLeftMouseButton(e)) {
                            Color currentColor = button.getBackground();
                            if (currentColor == Color.WHITE || currentColor == Color.YELLOW) {
                                button.setBackground(selectedColor);
                            } else {
                                button.setBackground(Color.YELLOW);
                            }
                        } else if (SwingUtilities.isRightMouseButton(e)) {
                            if(button.getBackground() == Color.YELLOW){
                                button.setBackground(Color.WHITE);
                            }else{
                                button.setBackground(Color.YELLOW);
                            }
                        }

                    }
                });
                gridPanel.add(button);
            }
        }

        mainPanel.add(rowPanel, BorderLayout.WEST);
        mainPanel.add(columnPanel, BorderLayout.NORTH);
        mainPanel.add(gridPanel, BorderLayout.CENTER);
        add(mainPanel);
        //Check solution
        JButton checkSolutionButton = new JButton();
        checkSolutionButton.setPreferredSize(new Dimension(50,50));
        checkSolutionButton.setText("Check Solution");
        checkSolutionButton.setBackground(Color.WHITE);
                checkSolutionButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                if (testSolution()){
                    JOptionPane.showMessageDialog(NanogramGrid.this, "Congratulations! Solution is correct!");
                }else{
                    JOptionPane.showMessageDialog(NanogramGrid.this, "Sorry! Solution is incorrect!");
                }
            }
        });
        mainPanel.add(checkSolutionButton, BorderLayout.SOUTH);
        // Set size and visibility
        setPreferredSize(new Dimension(800, 600));
        pack();
        setVisible(true);

    }
}
