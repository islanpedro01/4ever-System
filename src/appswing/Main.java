package appswing;

import javax.swing.*;

public class Main extends JFrame {
    private JLabel nome;
    private JTextField textField1;

    public Main() {
        super("4Ever System");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Main();
    }
}
