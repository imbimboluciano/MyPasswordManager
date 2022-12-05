package dashboard;

import javax.swing.*;
import java.awt.*;

public class UserPanel extends JPanel {


    private JLabel icon;

    private JLabel labelUser;
    private String actualUser;

    public UserPanel(String actualUser) {

        this.actualUser = actualUser;

        setPreferredSize(new Dimension(300,200));

        setLayout(new GridBagLayout());

        ImageIcon image = new ImageIcon("/home/wikilucio/IdeaProjects/MyPasswordManager/PasswordManager/src/main/resources/user.png");
        Image scaleimage = image.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);

        icon = new JLabel(new ImageIcon(scaleimage));
        labelUser = new JLabel(this.actualUser);


        GridBagConstraints gbc = new GridBagConstraints();

        gbc.gridx = 0;
        gbc.gridy = 0;

        gbc.weightx = 0.01;
        gbc.weighty = 0.01;

        gbc.anchor = GridBagConstraints.PAGE_END;
        gbc.insets = new Insets(0,0,0,0);


        add(icon,gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;

        gbc.weightx = 0.01;
        gbc.weighty = 0.01;
        gbc.anchor = GridBagConstraints.PAGE_START;

        add(labelUser,gbc);
    }
}
