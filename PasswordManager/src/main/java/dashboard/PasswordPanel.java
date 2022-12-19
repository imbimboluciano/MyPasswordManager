package dashboard;

import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;
import java.util.List;

public class PasswordPanel extends JPanel {

    private List<MyPassword> passwords;
    private SearchPanel searchPanel;
    private ViewPasswordPanel viewPasswordPanel;


    public PasswordPanel(List<MyPassword> passwords) {

        this.passwords = passwords;
        setLayout(new BorderLayout(10,5));

        searchPanel = new SearchPanel();
        viewPasswordPanel = new ViewPasswordPanel(passwords);
        add(searchPanel,BorderLayout.PAGE_START);
        add(viewPasswordPanel,BorderLayout.CENTER);












    }

}
