import java.awt.*;
import java.net.URI;
import java.net.URL;
import javax.swing.*;

public class BankingPortal {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Banking Transaction Portal");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700, 500);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        
        // Background Panel with Light Blue Shade Effect
        JPanel backgroundPanel = new JPanel() {
            private Image backgroundImage;
            {
                try {
                    URI bgUri = new URI("https://vna.works/wp-content/uploads/2023/09/02-2.jpg");
                    URL bgUrl = bgUri.toURL();
                    backgroundImage = new ImageIcon(bgUrl).getImage();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                if (backgroundImage != null) {
                    Graphics2D g2d = (Graphics2D) g.create();
                    g2d.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
                    
                    // Apply light blue shade overlay
                    g2d.setColor(new Color(173, 216, 230, 150)); // Light Blue with transparency
                    g2d.fillRect(0, 0, getWidth(), getHeight());
                    g2d.dispose();
                }
            }
        };
        backgroundPanel.setBounds(0, 0, frame.getWidth(), frame.getHeight());
        backgroundPanel.setLayout(null);
        frame.setContentPane(backgroundPanel);
        
        JLabel logo = new JLabel();
        try {
            ImageIcon logoIcon = new ImageIcon("Img2.png");
            Image logoImage = logoIcon.getImage().getScaledInstance(105, 63, Image.SCALE_SMOOTH);
            logo.setIcon(new ImageIcon(logoImage));
        } catch (Exception ex) {
            ex.printStackTrace();
            logo.setIcon(new ImageIcon("default-logo.png"));
        }
        logo.setBounds(10, 10, 105, 63);
        backgroundPanel.add(logo);

        JLabel title = new JLabel("Banking Transaction Portal");
        title.setFont(new Font("Verdana", Font.BOLD, 36)); // Updated with a cooler font
        title.setHorizontalAlignment(SwingConstants.CENTER);
        backgroundPanel.add(title);

        JPanel cardPanel = new JPanel();
        cardPanel.setLayout(null);
        cardPanel.setBackground(new Color(240, 248, 255, 230)); // Light blue panel background
        cardPanel.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));
        backgroundPanel.add(cardPanel);

        JLabel loginLabel = new JLabel("LOGIN");
        loginLabel.setFont(new Font("Arial", Font.BOLD, 18));
        loginLabel.setForeground(new Color(90, 120, 242));
        loginLabel.setBounds(120, 5, 100, 25);
        cardPanel.add(loginLabel);

        JLabel userLabel = new JLabel("Username:");
        userLabel.setBounds(30, 40, 100, 25);
        cardPanel.add(userLabel);
        
        JTextField userField = new JTextField();
        userField.setBounds(120, 40, 140, 25);
        userField.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
        userField.setBackground(new Color(240, 240, 240));
        userField.setFont(new Font("Arial", Font.PLAIN, 14));
        cardPanel.add(userField);

        JLabel passLabel = new JLabel("Password:");
        passLabel.setBounds(30, 80, 100, 25);
        cardPanel.add(passLabel);

        JPasswordField passField = new JPasswordField();
        passField.setBounds(120, 80, 140, 25);
        passField.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
        passField.setBackground(new Color(240, 240, 240));
        passField.setFont(new Font("Arial", Font.PLAIN, 14));
        cardPanel.add(passField);

        JButton loginButton = new JButton("Sign In");
        loginButton.setBounds(45, 130, 200, 30);
        cardPanel.add(loginButton);

        JCheckBox rememberMe = new JCheckBox("Remember me");
        rememberMe.setBounds(90, 170, 120, 20);
        rememberMe.setOpaque(false);
        cardPanel.add(rememberMe);

        JLabel forgetPassword = new JLabel("Forget Password?");
        forgetPassword.setBounds(100, 200, 120, 20);
        forgetPassword.setForeground(new Color(90, 120, 242)); // Light blue color
        forgetPassword.setFont(new Font("Arial", Font.PLAIN, 12));
        forgetPassword.setCursor(new Cursor(Cursor.HAND_CURSOR));
        cardPanel.add(forgetPassword);

        forgetPassword.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
                JOptionPane.showMessageDialog(frame, "Redirecting to password recovery...");
            }
        });

        loginButton.addActionListener(e -> {
            String user = userField.getText();
            String pass = new String(passField.getPassword());
            if (user.equals("system") && pass.equals("kiit")) {
                frame.dispose();
                NewPage.main(null);
            } else {
                JOptionPane.showMessageDialog(frame, "Invalid username or password");
            }
        });

        // Copyright Label
        JLabel copyrightLabel = new JLabel("© 2020 All Rights Reserved", SwingConstants.CENTER);
        copyrightLabel.setFont(new Font("Arial", Font.BOLD, 12)); // Make the label bold
        backgroundPanel.add(copyrightLabel);

        // Adjust component positions dynamically on resize
        frame.addComponentListener(new java.awt.event.ComponentAdapter() {
            @Override
            public void componentResized(java.awt.event.ComponentEvent e) {
                int frameWidth = frame.getWidth();
                int frameHeight = frame.getHeight();
                title.setBounds((frameWidth - 700) / 2, 80, 700, 50);
                cardPanel.setBounds((frameWidth - 300) / 2, (frameHeight - 250) / 2, 300, 250);
                copyrightLabel.setBounds((frameWidth - 300) / 2, cardPanel.getY() + cardPanel.getHeight() + 10, 300, 20); // Position below portal box
            }
        });

        // Ensure the background panel is repainted
        frame.addWindowStateListener(e -> backgroundPanel.repaint());

        frame.setVisible(true);
    }
}
