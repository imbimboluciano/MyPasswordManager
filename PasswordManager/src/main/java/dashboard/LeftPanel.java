package dashboard;

import javax.swing.*;
import java.awt.*;

public class LeftPanel extends JPanel {

    private String actualUser;



    private UserPanel userPanel;
    private NavigationPanel navigationPanel;
    private FooterPanel footerPanel;

    private LeftPanelListener leftPanelListener;

    public LeftPanel(String actualUser) {

        this.actualUser = actualUser;

        setPreferredSize(new Dimension(300,800));

        setBorder(BorderFactory.createMatteBorder(0,0,0,1,Color.GRAY));

        setLayout(new BorderLayout());

        userPanel = new UserPanel(this.actualUser);
        navigationPanel = new NavigationPanel();
        footerPanel = new FooterPanel();

        navigationPanel.setNavigationEvent(new NavigationListener() {
            @Override
            public void NavigationEventListener(String text) {
                if(leftPanelListener != null){
                    leftPanelListener.LeftPanelEventListener(text);
                }

            }
        });


        add(userPanel,BorderLayout.PAGE_START);
        add(navigationPanel,BorderLayout.CENTER);
        add(footerPanel,BorderLayout.PAGE_END);




    }

    public void setLeftPanelEvent(LeftPanelListener leftPanelListener){
        this.leftPanelListener = leftPanelListener;
    }
}
