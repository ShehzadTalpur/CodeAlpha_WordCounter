import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class WordCounter extends JFrame {
    private JLabel instructionLabel;
    private JTextField inputField;
    private JButton countButton;
    private JLabel resultLabel;

    public WordCounter() {
        setTitle("Word Counter");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create a panel to hold the components
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 1));

        //Add a JLabel for instructions
        instructionLabel = new JLabel("Enter a paragraph:");
        panel.add(instructionLabel);

        // Add a JTextField for user input
        inputField = new JTextField();
        panel.add(inputField);

        // Add a JButton to trigger the word count
        countButton = new JButton("Count Words");
        countButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                countWordsAndDisplay();
            }
        });
        panel.add(countButton);

        // Add a JLabel to display the word count result
        resultLabel = new JLabel();
        panel.add(resultLabel);

        // Add the panel to the frame
        add(panel);
        setVisible(true);
    }

    // Define a method to count words and display the result
    private void countWordsAndDisplay() {
        String paragraph = inputField.getText();
        int wordCount = countWords(paragraph);
        resultLabel.setText("Word count: " + wordCount);
    }

    // Helper method to count words
    private int countWords(String paragraph) {
        if (paragraph == null || paragraph.isEmpty()) {
            return 0;
        }

        String[] words = paragraph.split("\\s+");
        return words.length;
    }

    public static void main(String[] args) {
        new WordCounter();
    }
}