
import java.awt.event.*;
import javax.swing.*;

class text extends JFrame implements ActionListener {

    static JTextField t;

    static JButton b;
    static JButton b1;

    static JLabel l;
    public static JFrame f;
    static JLabel l1;
    static JTextField t1;
    public static JComboBox<String> cb;

    static String picked;

    text() {
    }

    public static void main(String[] args) {

        JFrame f = new JFrame("textfield");
        l = new JLabel("nothing entered");
        l1 = new JLabel("Pick X or O");
        b = new JButton("submit");
        b1 = new JButton("Play");
        String[] items = { "X", "O" };
        JComboBox<String> cb = new JComboBox<>(items);
        text te = new text();
        text te1 = new text();

        b.addActionListener(te);
        b1.addActionListener(te1);

        t = new JTextField(16);
        t1 = new JTextField(4);

        JPanel p = new JPanel();

        p.add(t);
        p.add(cb);
        p.add(b);
        p.add(b1);
        p.add(l);
        p.add(l1);

        f.add(p);

        f.setSize(300, 300);

        f.setVisible(true);
        cb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                l1.setText(cb.getSelectedItem().toString());
                picked = cb.getSelectedItem().toString();
                l1.setText("");
                
            }
        });

    }

    public void actionPerformed(ActionEvent e) {
        String s = e.getActionCommand();
        String d = e.getActionCommand();

        if (s.equals("submit")) {
            l.setText(t.getText()+ " "+"picked"+" "+picked);

            t.setText(" ");

           
        }
        if (d.equals("Play")) {
            TicTacToeGame second = new TicTacToeGame();
            second.setVisible(true);

        }
    }

}
