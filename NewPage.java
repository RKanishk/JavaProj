import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class NewPage {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Transaction History");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 500);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new BorderLayout());

        // Title Label
        JLabel title = new JLabel("Transaction History");
        title.setFont(new Font("Arial", Font.BOLD, 24));        
        title.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
        frame.add(title, BorderLayout.NORTH);

        // Table Data
        String[] columns = {"Date", "Name", "Transaction Type", "Amount", "Balance"};
        Object[][] data = {
            {"2025-03-20", "Kanishk", "Deposit", "$500", "$1500"},
            {"2025-03-18", "Hitesh", "Withdrawal", "$200", "$800"},
            {"2025-03-15", "Amrut", "Deposit", "$300", "$1300"},
            {"2025-03-15", "Manish", "Withdrawal", "$400", "$3400"}    
        };
            // Creating Table
        DefaultTableModel model = new DefaultTableModel(data, columns);
        JTable table = new JTable(model);
        table.setFont(new Font("Arial", Font.PLAIN, 14));
        table.setRowHeight(25);
        table.getTableHeader().setFont(new Font("Arial", Font.BOLD, 14));
        table.getTableHeader().setBackground(new Color(30, 144, 255));
        table.getTableHeader().setForeground(Color.WHITE);

        // Scroll Pane
        JScrollPane scrollPane = new JScrollPane(table);
        frame.add(scrollPane, BorderLayout.CENTER);

        // Show Frame
        frame.setVisible(true);
    }
}
