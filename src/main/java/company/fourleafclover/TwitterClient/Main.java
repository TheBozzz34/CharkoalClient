package company.fourleafclover.TwitterClient;


import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {

    public static void main(String[] args) {
        System.out.println("Started!");


        final JFrame frame = new JFrame("Keturahs Twitter Client");

        JLabel lblKey = new JLabel("API Key:");
        final JPasswordField pfKey = new JPasswordField(20);
        lblKey.setLabelFor(pfKey);

        JLabel lblSecret = new JLabel("API Secret:");
        final JPasswordField pfSecret = new JPasswordField(20);
        lblSecret.setLabelFor(pfSecret);

        JLabel lblToken = new JLabel("Access Token:");
        final JPasswordField pfToken = new JPasswordField(20);
        lblToken.setLabelFor(pfToken);

        JLabel lblASecret = new JLabel("Access Secret:");
        final JPasswordField pfASecret = new JPasswordField(20);
        lblASecret.setLabelFor(pfASecret);

        JLabel lblmsg = new JLabel("Message:");
        JTextField tfmsg = new JTextField(20);
        lblmsg.setLabelFor(tfmsg);

        JButton btnGet = new JButton("Send tweet");

        btnGet.addActionListener(
                new ActionListener() {

                    public void actionPerformed(ActionEvent e) {
                        String APIKey = new String(pfKey.getPassword());
                        String APISecret = new String(pfASecret.getPassword());
                        String AccessToken = new String(pfToken.getPassword());
                        String AccessSecret = new String(pfASecret.getPassword());
                        String Msg = new String(tfmsg.getText());


                        try {
                            Twitter twitter = new TwitterFactory().getInstance();

                            twitter.setOAuthConsumer(APIKey, APISecret);
                            AccessToken accessToken = new AccessToken(AccessToken,
                                    AccessSecret);

                            twitter.setOAuthAccessToken(accessToken);

                            twitter.updateStatus(Msg);

                            System.out.println("Successfully updated the status in Twitter.");
                        } catch (TwitterException te) {
                            te.printStackTrace();
                        }



                        JOptionPane.showMessageDialog(frame,
                                "Tweet sent!");
                    }
                });

        JButton btnLogin = new JButton("Login");

        JPanel panel = new JPanel();
        panel.setLayout(new SpringLayout());

        panel.add(lblKey);//API Key
        panel.add(pfKey);//Api Key
        panel.add(lblSecret);//Access Secret
        panel.add(pfSecret);
        panel.add(lblToken);//API Token
        panel.add(pfToken);//API Token
        panel.add(lblASecret);
        panel.add(pfASecret);
        panel.add(lblmsg);
        panel.add(tfmsg);
        panel.add(btnLogin);
        panel.add(btnGet);

        jtextfielddemo.SpringUtilities.makeCompactGrid(panel,
                6, 2, //rows, cols
                6, 6, //initX, initY
                6, 6); //xPad, yPad

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);
        frame.getContentPane().add(panel);
        frame.setVisible(true);









    }

}



