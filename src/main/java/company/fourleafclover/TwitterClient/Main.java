package company.fourleafclover.TwitterClient;

import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

import java.io.IOException;
import java.lang.Exception;
import io.sentry.Sentry;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.Desktop;
import java.net.URI;
import java.net.URISyntaxException;

public class Main {



    public static void main(String[] args) {
        Sentry.init(options -> {
            options.setDsn("https://6ed02058198b475ea5c08ee012467b5b@o561860.ingest.sentry.io/5851198");
            // Set traces_sample_rate to 1.0 to capture 100% of transactions for performance monitoring.
            // We recommend adjusting this value in production.
            options.setTracesSampleRate(1.0);
            // When first trying Sentry it's good to see what the SDK is doing:
            options.setDebug(false);
        });
        System.out.println("Started!");


        final JFrame frame = new JFrame("Charkoal Twitter Client");
        final JFrame frame2 = new JFrame("Charkoal Twitter Client Feedback");

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


                        } catch (Exception er) {
                            Sentry.captureException(er);
                            System.out.println("Logged exception!");
                        }



                        JOptionPane.showMessageDialog(frame,
                                "Tweet sent!");
                    }
                });

        JButton btnLogin = new JButton("Feedback");






        btnLogin.addActionListener(
                new ActionListener() {

                    public void actionPerformed(ActionEvent e) {
                        if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
                            try {
                                Desktop.getDesktop().browse(new URI("https://github.com/TheBozzz34/CharkoalClient/issues/new"));
                            } catch (IOException ex) {
                                ex.printStackTrace();
                                Sentry.captureException(ex);
                            } catch (URISyntaxException ex) {
                                Sentry.captureException(ex);
                                ex.printStackTrace();
                            }
                        }



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



