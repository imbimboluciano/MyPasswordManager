package dashboard;

import javax.swing.*;
import java.awt.*;

public class DashboardFrame extends JFrame {


    private String actualUser;

    private LeftPanel leftPanel;

    private PasswordPanel passwordPanel;
    private GeneratorePanel generatorePanel;
    private int actualPanel;
    public DashboardFrame(String actualUser) throws HeadlessException {

        super("MyPasswordManager");
        this.actualUser = actualUser;


        setLayout(new BorderLayout());

        leftPanel = new LeftPanel(actualUser);
        passwordPanel = new PasswordPanel();

        add(leftPanel,BorderLayout.LINE_START);
        add(passwordPanel,BorderLayout.CENTER);

        actualPanel = 0;

        leftPanel.setLeftPanelEvent(new LeftPanelListener() {
            @Override
            public void LeftPanelEventListener(String text) {
                if(text.equals("Archivio")){
                    passwordPanel = new PasswordPanel();
                    add(passwordPanel,BorderLayout.CENTER);
                    validate();

                } else if (text.equals("Generatore")) {
                    generatorePanel = new GeneratorePanel();
                    add(generatorePanel,BorderLayout.CENTER);
                    validate();
                    
                } else if (text.equals("Settings")) {
                    
                }
            }
        });








        setSize(1200,800);

        setLocationRelativeTo(null); //posizionare la finestra al centro del centro dello schermo, deve essere richiamata dopo setSize
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setResizable(false); // rendere la finestra non resizable

        setVisible(true); // per rendere visibile la finestra
    }
}
