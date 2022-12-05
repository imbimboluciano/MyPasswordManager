package dashboard;

import login.User;

import javax.swing.*;
import java.awt.*;

public class LeftPanel extends JPanel {

    private String actualUser;



    private UserPanel userPanel;
    private NavigationPanel navigationPanel;

    public LeftPanel(String actualUser) {

        this.actualUser = actualUser;

        setPreferredSize(new Dimension(300,800));

        setBorder(BorderFactory.createMatteBorder(0,0,0,1,Color.GRAY));

        setLayout(new BorderLayout());

        userPanel = new UserPanel(this.actualUser);
        navigationPanel = new NavigationPanel();


        add(userPanel,BorderLayout.PAGE_START);
        add(navigationPanel,BorderLayout.CENTER);



    }
}
