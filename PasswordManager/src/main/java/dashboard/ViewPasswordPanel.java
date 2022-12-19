package dashboard;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class ViewPasswordPanel extends JPanel {


    private List<MyPassword> passwordList;
    private List<String> passwordJList;
    private JList listPassword;
    public ViewPasswordPanel(List<MyPassword> passwordList) {

        setLayout(new BorderLayout());
        this.passwordList = passwordList;

        passwordJList = new ArrayList<>();
        for (MyPassword i : passwordList){
            passwordJList.add(i.getNome());
        }

        listPassword = new JList<>(passwordJList.toArray());


        add(listPassword,BorderLayout.CENTER);
    }
}
