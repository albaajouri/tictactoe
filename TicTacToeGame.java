import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class TicTacToeGame implements ActionListener {

    JFrame frame = new JFrame();
    JPanel t_panel = new JPanel();
    JPanel t1_panel = new JPanel();
    JPanel bt_panel = new JPanel();
    JLabel textfield = new JLabel();
    JLabel textfield1 = new JLabel();
    static JButton[] bton = new JButton[9];
    int chanceFlag = 0;
    Random random = new Random();
    boolean pl1Chance;
    boolean player = true;
    String picked = text.picked;
    JLabel pName = text.l;

    TicTacToeGame() {

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 1000);
        frame.getContentPane().setBackground(new Color(50, 50, 50));
        frame.setTitle("Tic Tac Toe");
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);
        
        textfield1.setBackground(new Color(120, 20, 124));
        textfield1.setForeground(new Color(25, 255, 0));
        textfield1.setFont(new Font("Ink Free", Font.BOLD, 75));
        textfield1.setHorizontalAlignment(JLabel.CENTER);
        textfield1.setText("Test");
        textfield1.setOpaque(true);

        textfield.setBackground(new Color(120, 20, 124));
        textfield.setForeground(new Color(25, 255, 0));
        textfield.setFont(new Font("Ink Free", Font.BOLD, 75));
        textfield.setHorizontalAlignment(JLabel.CENTER);
        textfield.setText("Tic Tac Toe");
        textfield.setOpaque(true);

        

        t_panel.setLayout(new BorderLayout());
        t_panel.setBounds(0, 0, 1000, 75);
        
        t1_panel.setLayout(new BorderLayout());
        t1_panel.setBounds(0, 0, 1000, 75);
        bt_panel.setLayout(new GridLayout(3, 3));
        bt_panel.setBackground(new Color(150, 150, 150));

        for (int i = 0; i < 9; i++) {
            bton[i] = new JButton();
            bt_panel.add(bton[i]);
            bton[i].setFont(new Font("Ink Free", Font.BOLD, 100));
            bton[i].setFocusable(false);
            bton[i].addActionListener(this);
        }
        
        t_panel.add(pName);
        
        t_panel.add(textfield);
        t1_panel.add(textfield1);
        frame.add(t_panel, BorderLayout.NORTH);
        frame.add(t1_panel, BorderLayout.SOUTH);
        frame.add(bt_panel);
        startGame();
    }

    public void startGame() {

        // try {
        //     textfield.setText("Loading....");
        //     Thread.sleep(4000);
        // } catch (InterruptedException e) {

        //     e.printStackTrace();
        // }

        if (picked.equals("X")) {
            pl1Chance = true;
            textfield.setText("X turn");
            textfield1.setText("test1");
        } else {
            pl1Chance = false;
            textfield.setText("O turn");
            textfield1.setText("test1");
        }
    }

    public void gameOver(String s) {
        chanceFlag = 0;
        Object[] option = { "Restart", "Exit" };
        int n = JOptionPane.showOptionDialog(frame, "Game Over\n" + s, "Game Over", JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE, null, option, option[0]);
        if (n == 0) {
            for (int i = 0; i < 9; i++) {
                bton[i].setText("");
                bton[i].setEnabled(true);
                bton[i].setFont(new Font("Ink Free", Font.BOLD, 100));
                bton[i].setFocusable(false);
                bton[i].setBackground(new Color(150, 150, 150));
                
            }
            startGame();
        } else {
            frame.dispose();

        }

    }

    public void matchCheck() {
        if ((bton[0].getText().equals("X")) && (bton[1].getText().equals("X")) && (bton[2].getText().equals("X"))) {
            xWins(0, 1, 2);
        } else if ((bton[0].getText().equals("X")) && (bton[4].getText().equals("X"))
                && (bton[8].getText().equals("X"))) {
            xWins(0, 4, 8);
        } else if ((bton[0].getText().equals("X")) && (bton[3].getText().equals("X"))
                && (bton[6].getText().equals("X"))) {
            xWins(0, 3, 6);
        } else if ((bton[1].getText().equals("X")) && (bton[4].getText().equals("X"))
                && (bton[7].getText().equals("X"))) {
            xWins(1, 4, 7);
        } else if ((bton[2].getText().equals("X")) && (bton[4].getText().equals("X"))
                && (bton[6].getText().equals("X"))) {
            xWins(2, 4, 6);
        } else if ((bton[2].getText().equals("X")) && (bton[5].getText().equals("X"))
                && (bton[8].getText().equals("X"))) {
            xWins(2, 5, 8);
        } else if ((bton[3].getText().equals("X")) && (bton[4].getText().equals("X"))
                && (bton[5].getText().equals("X"))) {
            xWins(3, 4, 5);
        } else if ((bton[6].getText().equals("X")) && (bton[7].getText().equals("X"))
                && (bton[8].getText().equals("X"))) {
            xWins(6, 7, 8);
        }

        else if ((bton[0].getText().equals("O")) && (bton[1].getText().equals("O"))
                && (bton[2].getText().equals("O"))) {
            oWins(0, 1, 2);
        } else if ((bton[0].getText().equals("O")) && (bton[3].getText().equals("O"))
                && (bton[6].getText().equals("O"))) {
            oWins(0, 3, 6);
        } else if ((bton[0].getText().equals("O")) && (bton[4].getText().equals("O"))
                && (bton[8].getText().equals("O"))) {
            oWins(0, 4, 8);
        } else if ((bton[1].getText().equals("O")) && (bton[4].getText().equals("O"))
                && (bton[7].getText().equals("O"))) {
            oWins(1, 4, 7);
        } else if ((bton[2].getText().equals("O")) && (bton[4].getText().equals("O"))
                && (bton[6].getText().equals("O"))) {
            oWins(2, 4, 6);
        } else if ((bton[2].getText().equals("O")) && (bton[5].getText().equals("O"))
                && (bton[8].getText().equals("O"))) {
            oWins(2, 5, 8);
        } else if ((bton[3].getText().equals("O")) && (bton[4].getText().equals("O"))
                && (bton[5].getText().equals("O"))) {
            oWins(3, 4, 5);
        } else if ((bton[6].getText().equals("O")) && (bton[7].getText().equals("O"))
                && (bton[8].getText().equals("O"))) {
            oWins(6, 7, 8);
        } else if (chanceFlag == 9) {
            textfield.setText("Match Tie");
            gameOver("Match Tie");
        }
    }

    public void xWins(int x1, int x2, int x3) {
        bton[x1].setBackground(Color.RED);
        bton[x2].setBackground(Color.RED);
        bton[x3].setBackground(Color.RED);

        for (int i = 0; i < 9; i++) {
            bton[i].setEnabled(false);
        }
        textfield.setText("X wins");
        gameOver("X Wins");
    }

    public void oWins(int x1, int x2, int x3) {
        bton[x1].setBackground(Color.RED);
        bton[x2].setBackground(Color.RED);
        bton[x3].setBackground(Color.RED);

        for (int i = 0; i < 9; i++) {
            bton[i].setEnabled(false);
        }
        textfield.setText("O Wins");
        gameOver("O Wins");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        while (player) {
            for (int i = 0; i < 9; i++) {
                if (e.getSource() == bton[i]) {
                    if (pl1Chance) {
                        if (bton[i].getText().equals("")) {
                            bton[i].setForeground(new Color(255, 0, 0));
                            bton[i].setText("X");
                            bton[i].setEnabled(false);
                            bton[i].setBackground(Color.GREEN);
                            pl1Chance = false;
                            player = false;
                            textfield.setText("O turn");
                            chanceFlag++;
                            matchCheck();
                        }
                    } else {
                        if (bton[i].getText().equals("")) {
                            bton[i].setForeground(new Color(0, 0, 255));
                            bton[i].setText("O");
                            bton[i].setEnabled(false);
                            bton[i].setBackground(Color.GREEN);
                            pl1Chance = true;
                            player = false;
                            textfield.setText("X turn");
                            chanceFlag++;
                            matchCheck();

                        }
                    }
                }
            }
        }
        while (!player) {
            for (int i = 0; i < 9; i++) {
                Random randomNumber = new Random();

                if (pl1Chance) {
                    if (e.getSource() == bton[randomNumber.nextInt(9)]) {
                        if (bton[i].getText().equals("")) {
                            bton[i].setForeground(new Color(255, 0, 0));
                            bton[i].setText("X");
                            bton[i].setEnabled(false);
                            bton[i].setBackground(Color.GREEN);
                            pl1Chance = false;
                            player = true;
                            textfield.setText("O turn");
                            textfield1.setText("Player's turn");
                            chanceFlag++;
                            matchCheck();
                            break;

                        }
                    }
                } else {
                    if (e.getSource() == bton[randomNumber.nextInt(9)]) {
                        if (bton[i].getText().equals("")) {
                            bton[i].setForeground(new Color(0, 0, 255));
                            bton[i].setText("O");
                            bton[i].setEnabled(false);
                            bton[i].setBackground(Color.GREEN);
                            pl1Chance = true;
                            player = true;
                            textfield.setText("X turn");
                            textfield1.setText("Player's turn");
                            chanceFlag++;
                            matchCheck();
                            break;
                        }
                    }
                }

            }
        }

    }

    public void setVisible(boolean b) {
    }

}

/*
 * public static boolean isValidMove(String position) {
 * switch (position) {
 * case "1":
 * return (bton[0].getText().equals(""));
 * case "2":
 * return (bton[1].getText().equals(""));
 * case "3":
 * return (bton[2].getText().equals(""));
 * case "4":
 * return (bton[3].getText().equals(""));
 * case "5":
 * return (bton[4].getText().equals(""));
 * case "6":
 * return (bton[5].getText().equals(""));
 * case "7":
 * return (bton[6].getText().equals(""));
 * case "8":
 * return (bton[7].getText().equals(""));
 * case "9":
 * return (bton[8].getText().equals(""));
 * default:
 * return false;
 * }
 * }
 */