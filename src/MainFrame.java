import javax.swing.*;

public class MainFrame extends JFrame {

    public MainFrame() {
        setTitle("Ứng dụng với hai tab");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1400, 800);

        // Tạo JTabbedPane
        JTabbedPane tabbedPane = new JTabbedPane();

        // Thêm Tab 1
        tabbedPane.addTab("Tab 1", new CompareForm());

        // Thêm Tab 2
        tabbedPane.addTab("Tab 2", new MainForm());

        // Thêm JTabbedPane vào JFrame
        add(tabbedPane);

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(MainFrame::new);
    }

}