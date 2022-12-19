package dashboard;

import login.User;
import utils.DBManager;

import javax.swing.*;
import java.awt.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class DashboardFrame extends JFrame {


    private String actualUser;

    private LeftPanel leftPanel;

    private PasswordPanel passwordPanel;
    private GeneratorePanel generatorePanel;
    private SettingsPanel settingsPanel;
    private int actualPanel;
    private List<JPanel> panels;

    private ResultSet passwords;
    public DashboardFrame(String actualUser) throws HeadlessException {

        super("MyPasswordManager");
        this.actualUser = actualUser;

        initData();


        panels = new ArrayList<>();

        setLayout(new BorderLayout());

        leftPanel = new LeftPanel(actualUser);
        passwordPanel = new PasswordPanel();
        generatorePanel = new GeneratorePanel();
        settingsPanel = new SettingsPanel();

        add(leftPanel,BorderLayout.LINE_START);
        add(passwordPanel,BorderLayout.CENTER);

        panels.add(passwordPanel);
        panels.add(generatorePanel);
        panels.add(settingsPanel);

        actualPanel = 0;

        leftPanel.setLeftPanelEvent(new LeftPanelListener() {
            @Override
            public void LeftPanelEventListener(String text) {
                if(text.equals("Archivio")){
                   if(actualPanel != 0){
                       remove(panels.get(actualPanel));
                       actualPanel = 0;
                       remove(panels.get(actualPanel));
                       passwordPanel = new PasswordPanel();
                       panels.add(actualPanel,passwordPanel);
                       add(panels.get(actualPanel),BorderLayout.CENTER);
                       revalidate();
                       repaint();
                   }
                } else if (text.equals("Generatore")) {
                    if(actualPanel != 1){
                        remove(panels.get(actualPanel));
                        actualPanel = 1;
                        remove(panels.get(actualPanel));
                        generatorePanel = new GeneratorePanel();
                        panels.add(actualPanel,generatorePanel);
                        add(panels.get(actualPanel),BorderLayout.CENTER);
                        revalidate();
                        repaint();
                    }

                    
                } else if (text.equals("Impostazioni")) {
                    if(actualPanel != 2){
                        remove(panels.get(actualPanel));
                        actualPanel = 2;
                        remove(panels.get(actualPanel));
                        settingsPanel = new SettingsPanel();
                        panels.add(actualPanel,settingsPanel);
                        add(panels.get(actualPanel),BorderLayout.CENTER);
                        revalidate();
                        repaint();
                    }
                }
            }
        });








        setSize(1200,800);

        setLocationRelativeTo(null); //posizionare la finestra al centro del centro dello schermo, deve essere richiamata dopo setSize
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setResizable(false); // rendere la finestra non resizable

        setVisible(true); // per rendere visibile la finestra
    }

    public void initData(){
        DBManager.setConnection(DBManager.JBDC_Driver_MariaDB,DBManager.JDBC_URL_MariaDB);
        PreparedStatement statement = null;
        try {
            String sql = "SELECT * FROM password";
            statement = DBManager.getConnection().prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
            passwords = statement.executeQuery();
            passwords.first();


            MyPassword p = new MyPassword(passwords.getInt(1),passwords.getString(2),passwords.getString(3),passwords.getString(4),passwords.getString(5));

            System.out.println(p.toString());

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
