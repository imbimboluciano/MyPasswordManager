package login;

import javax.swing.*;
import java.awt.*;

public class LoginFrame extends JFrame {

    private LoginPanel loginPanel;
    private LogoPanel logoPanel;
    private CopyrightPanel copyrightPanel;
    public LoginFrame() throws HeadlessException {
        super("MyPasswordManager");

        setLayout(new BorderLayout());

        loginPanel = new LoginPanel();
        logoPanel = new LogoPanel();
        copyrightPanel = new CopyrightPanel();

        add(copyrightPanel,BorderLayout.PAGE_END);
        add(loginPanel,BorderLayout.CENTER);
        add(logoPanel,BorderLayout.PAGE_START);

        setSize(1000,700);

        setLocationRelativeTo(null); //posizionare la finestra al centro del centro dello schermo, deve essere richiamata dopo setSize
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setResizable(false); // rendere la finestra non resizable

        setVisible(true); // per rendere visibile la finestra
    }
}
