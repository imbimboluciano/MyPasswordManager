package dashboard;

import javax.swing.*;
import java.awt.*;

public class DashboardFrame extends JFrame {


    private String actualUser;

    private LeftPanel leftPanel;
    public DashboardFrame(String actualUser) throws HeadlessException {

        super("MyPasswordManager");
        this.actualUser = actualUser;


        setLayout(new BorderLayout());

        leftPanel = new LeftPanel(actualUser);


        add(leftPanel,BorderLayout.LINE_START);

        setSize(1200,800);

        setLocationRelativeTo(null); //posizionare la finestra al centro del centro dello schermo, deve essere richiamata dopo setSize
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setResizable(false); // rendere la finestra non resizable

        setVisible(true); // per rendere visibile la finestra
    }
}
