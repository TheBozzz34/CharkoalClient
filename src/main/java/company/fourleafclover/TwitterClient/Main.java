package company.fourleafclover.TwitterClient;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {

    public static void main(String[] args) {
        System.out.println("Started!");


        final JFrame frame = new JFrame("Twitter Client");

        JLabel lblKey = new JLabel("API Token:");
        JTextField tfKey = new JPasswordField(20);
        lblKey.setLabelFor(tfKey);

        JLabel lblSecret = new JLabel("API Secret:");
        JTextField tfSecret = new JPasswordField(20);
        lblSecret.setLabelFor(tfSecret);

        JLabel lblToken = new JLabel("Access Token:");
        final JPasswordField pfToken = new JPasswordField(20);
        lblToken.setLabelFor(pfToken);

        JLabel lblASecret = new JLabel("Access Secret:");
        final JPasswordField pfASecret = new JPasswordField(20);
        lblASecret.setLabelFor(pfASecret);

        JButton btnGet = new JButton("Send tweet");
        btnGet.addActionListener(
                new ActionListener() {

                    public void actionPerformed(ActionEvent e) {
                        String password = new String(pfToken.getPassword());
                        JOptionPane.showMessageDialog(frame,
                                "Tweet sent!");
                    }
                });

        JButton btnLogin = new JButton("Login");

        JPanel panel = new JPanel();
        panel.setLayout(new SpringLayout());

        panel.add(lblKey);//API Key
        panel.add(tfKey);//Api Key
        panel.add(lblSecret);//Access Secret
        panel.add(tfSecret);
        panel.add(lblToken);//API Token
        panel.add(pfToken);//API Token
        panel.add(lblASecret);
        panel.add(pfASecret);
        panel.add(btnLogin);
        panel.add(btnGet);

        jtextfielddemo.SpringUtilities.makeCompactGrid(panel,
                5, 2, //rows, cols
                6, 6, //initX, initY
                6, 6); //xPad, yPad

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);
        frame.getContentPane().add(panel);
        frame.setVisible(true);









    }

}



