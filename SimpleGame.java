import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SimpleGame extends JFrame implements ActionListener {
    private JButton[] buttons;
    private int[] numbers;
    private int score;

    public SimpleGame() {
        super("Simple Game");

        JPanel buttonPanel = new JPanel(new GridLayout(2, 2));
        buttons = new JButton[4];
        numbers = new int[4];

        for (int i = 0; i < 4; i++) {
            buttons[i] = new JButton();
            buttons[i].addActionListener(this);
            buttonPanel.add(buttons[i]);
        }

        add(buttonPanel, BorderLayout.CENTER);

        JButton restartButton = new JButton("Restart");
        restartButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                startNewGame();
            }
        });

        add(restartButton, BorderLayout.SOUTH);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);
        setVisible(true);

        startNewGame();
    }

    public void actionPerformed(ActionEvent e) {
        JButton clickedButton = (JButton) e.getSource();
        int clickedIndex = -1;

        for (int i = 0; i < 4; i++) {
            if (clickedButton == buttons[i]) {
                clickedIndex = i;
                break;
            }
        }

        if (clickedIndex == -1) {
            return;
        }

        if (numbers[clickedIndex] == 1) {
            score++;
            JOptionPane.showMessageDialog(this, "You clicked the correct button! Your score is now " + score);
        } else {
            JOptionPane.showMessageDialog(this, "You clicked the wrong button. Game over. Your final score is " + score);
            startNewGame();
        }
    }

    private void startNewGame() {
        score = 0;

        for (int i = 0; i < 4; i++) {
            numbers[i] = (int) (Math.random() * 2);
            buttons[i].setText(numbers[i] + "");
        }
    }

    public static void main(String[] args) {
        new SimpleGame();
    }
}
