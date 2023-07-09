import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Home extends JFrame {

    private JPanel cardPanel;
    private CardLayout cardLayout;

    public Home() {
        setTitle("Form Switching Example");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1376, 750);
        setLocationRelativeTo(null);

        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);

        MainForm form1 = new MainForm();
        CompareForm form2 = new CompareForm();

        cardPanel.add(form1, "form1");
        cardPanel.add(form2, "form2");

        JButton switchButton1 = new JButton("Switch to Form 1");
        switchButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "form1");
            }
        });

        JButton switchButton2 = new JButton("Switch to Form 2");
        switchButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "form2");
            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(switchButton1);
        buttonPanel.add(switchButton2);

        getContentPane().add(cardPanel, BorderLayout.CENTER);
        getContentPane().add(buttonPanel, BorderLayout.SOUTH);

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Home();
            }
        });
    }
}