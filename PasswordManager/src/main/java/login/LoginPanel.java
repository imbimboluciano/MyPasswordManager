package login;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.Random;
import java.util.random.RandomGenerator;

public class LoginPanel extends JPanel {

    private JButton logIn;
    private JTextField fieldEmail;
    private JPasswordField fieldPassword;
    private JLabel icon;

    private LoginListener loginListener;

    public LoginPanel() {

        setLayout(new GridBagLayout());


        logIn = new JButton("Log In");

        logIn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String password  = String.valueOf(fieldPassword.getPassword());
                User actualUser = new User(this, RandomGenerator.getDefault().nextInt(), fieldEmail.getText(),password);
                fieldEmail.setText("email@example.it");
                fieldPassword.setText("");

                if(loginListener != null){
                    loginListener.LoginEventListener(actualUser);
                }
            }
        });
        fieldEmail = new JTextField("email@example.it",20);
        fieldPassword = new JPasswordField("",20);

        fieldEmail.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if(fieldEmail.getText().equals("email@example.it")){
                    fieldEmail.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if(fieldEmail.getText().isEmpty()){
                    fieldEmail.setText("email@example.it");
                }
            }
        });

        ImageIcon image = new ImageIcon("/home/wikilucio/IdeaProjects/MyPasswordManager/PasswordManager/src/main/resources/logo.png");
        Image scaleimage = image.getImage().getScaledInstance(350,250,Image.SCALE_DEFAULT);

        icon = new JLabel(new ImageIcon(scaleimage));



        GridBagConstraints gbc = new GridBagConstraints();

        gbc.gridx = 0;
        gbc.gridy = 0;

        gbc.weightx = 0.01;
        gbc.weighty = 0.01;

        gbc.anchor = GridBagConstraints.PAGE_START;
        gbc.insets = new Insets(0,0,30,0);

        add(icon,gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;

        gbc.weightx = 0.01;
        gbc.weighty = 0.01;

        gbc.anchor = GridBagConstraints.PAGE_START;
        gbc.insets = new Insets(0,0,10,0);

        add(fieldEmail,gbc);


        gbc.gridx = 0;
        gbc.gridy = 2;

        gbc.weightx = 0.01;
        gbc.weighty = 0.01;

        gbc.anchor = GridBagConstraints.PAGE_START;
        gbc.insets = new Insets(0,0,10,0);

        add(fieldPassword,gbc);
        fieldPassword.setText("Password");

        gbc.gridx = 0;
        gbc.gridy = 3;

        // peso dell'oggetto
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;

        gbc.gridwidth = 2; // il bottone occupa due colonne
        gbc.gridheight = 1;

        gbc.anchor = GridBagConstraints.PAGE_START;

        gbc.ipadx = 20;


        add(logIn,gbc);

    }

    public void setLoginEvent(LoginListener loginListener){
        this.loginListener = loginListener;
    }
}
