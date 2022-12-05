package login;

import com.formdev.flatlaf.FlatDarculaLaf;
import dashboard.DashboardFrame;
import utils.DBManager;

import javax.swing.*;
import java.awt.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginFrame extends JFrame {

    private LoginPanel loginPanel;
    private LogoPanel logoPanel;
    private CopyrightPanel copyrightPanel;

    private ResultSet users;
    public LoginFrame() throws HeadlessException {


        super("MyPasswordManager");
        try {
            UIManager.setLookAndFeel(new FlatDarculaLaf()); // Look and feel
        } catch (UnsupportedLookAndFeelException e) {
            throw new RuntimeException(e);
        }
        UIManager.put("Button.arc",10);
        UIManager.put("TextComponent.arc",0);




        setLayout(new BorderLayout());

        loginPanel = new LoginPanel();

        loginPanel.setLoginEvent(new LoginListener() {
            @Override
            public void LoginEventListener(User e) {
                PreparedStatement statement = null;
                User u;
                try {
                    String sql = "SELECT email,password FROM utenti WHERE email= ?";
                    statement = DBManager.getConnection().prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
                    statement.setString(1,e.getEmail());
                    users = statement.executeQuery();
                    users.first();
                    u = new User(this,1, users.getString(1),users.getString(2) );

                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }

                if(u.equals(e)){
                    SwingUtilities.invokeLater(new Runnable() {
                        @Override
                        public void run() {
                            new DashboardFrame(u.getEmail());
                            dispose();
                        }
                    });
                }

            }
        });
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


        try {
            initData();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public void initData() throws SQLException {

        DBManager.setConnection(DBManager.JBDC_Driver_MariaDB,DBManager.JDBC_URL_MariaDB);




    }
}
