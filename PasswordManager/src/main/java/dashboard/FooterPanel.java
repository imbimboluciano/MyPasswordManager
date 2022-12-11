package dashboard;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class FooterPanel extends JPanel {


    private JButton logout;
    public FooterPanel() {

        setPreferredSize(new Dimension(300,450));
        setLayout(new BorderLayout());

        setBorder(new EmptyBorder(new Insets(0,50,20,50)));

        logout = new JButton("Log out");

        add(logout,BorderLayout.PAGE_END);

    }
}
