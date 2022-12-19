package dashboard;

import javax.swing.*;
import java.awt.*;

public class SearchPanel extends JPanel {


    private JTextField search;
    private JButton addPassword;
    public SearchPanel() {

        setLayout(new FlowLayout(FlowLayout.RIGHT,10,7));

        search = new JTextField("Ricerca",20);
        addPassword = new JButton("+ Nuova Password");
        add(search);
        add(Box.createHorizontalStrut(180));
        add(addPassword);


    }
}
