package company.fourleafclover.TwitterClient;

import twitter4j.*;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;
import twitter4j.conf.ConfigurationBuilder;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        System.out.println("Started!");


        final JFrame frame = new JFrame("Keturahs Twitter Client");

        JLabel lblKey = new JLabel("API Key:");
        JTextField tfKey = new JTextField(20);
        lblKey.setLabelFor(tfKey);

        JLabel lblSecret = new JLabel("API Secret:");
        JTextField tfSecret = new JTextField(20);
        lblSecret.setLabelFor(tfSecret);

        JLabel lblToken = new JLabel("Access Token:");
        JTextField tfToken = new JTextField(20);
        lblToken.setLabelFor(tfToken);

        JLabel lblASecret = new JLabel("Access Secret:");
        JTextField tfAsecret = new JTextField(20);
        lblASecret.setLabelFor(tfAsecret);

        JLabel lblmsg = new JLabel("Message:");
        JTextField tfmsg = new JTextField(20);
        lblmsg.setLabelFor(tfmsg);

        JButton btnGet = new JButton("Send tweet");

        btnGet.addActionListener(
                new ActionListener() {

                    public void actionPerformed(ActionEvent e) {
                        String consumerKey = new String(tfKey.getText());
                        String consumerSecret = new String(tfSecret.getText());
                        String oAuthAccessToken = new String(tfToken.getText());
                        String oAuthAccessTokenSecret = new String(tfAsecret.getText());
                        String Msg = new String(tfmsg.getText());


                        ConfigurationBuilder cb = new ConfigurationBuilder();
                        cb.setDebugEnabled(true)
                                .setOAuthConsumerKey(consumerKey)
                                .setOAuthConsumerSecret(consumerSecret)
                                .setOAuthAccessToken(oAuthAccessToken)
                                .setOAuthAccessTokenSecret(oAuthAccessTokenSecret);
                        TwitterFactory tf = new TwitterFactory(cb.build());
                        Twitter twitter = tf.getInstance();


                        try {


                            Status status = twitter.updateStatus(Msg);
                            System.out.println("Successfully updated the status to [" + status.getText() + "].");


                        } catch (Exception te) {
                            te.printStackTrace();
                        }



                        JOptionPane.showMessageDialog(frame,
                                "Tweet sent!");
                    }
                });

        JButton btnLogin = new JButton("Close");

        btnLogin.addActionListener(
                new ActionListener() {

                    public void actionPerformed(ActionEvent e) {

                        System.exit(0);
                    }
                });



        JPanel panel = new JPanel();
        panel.setLayout(new SpringLayout());

        panel.add(lblKey);//API Key
        panel.add(tfKey);//Api Key
        panel.add(lblSecret);//Access Secret
        panel.add(tfSecret);panel.add(lblToken);//API Token
        panel.add(tfToken);//API Token
        panel.add(lblASecret);
        panel.add(tfAsecret);
        panel.add(lblmsg);
        panel.add(tfmsg);
        panel.add(btnLogin);
        panel.add(btnGet);

        jtextfielddemo.SpringUtilities.makeCompactGrid(panel,
                6, 2, //rows, cols
                6, 6, //initX, initY
                6, 6); //xPad, yPad

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(470, 200);
        frame.getContentPane().add(panel);
        frame.setVisible(true);









    }

}



