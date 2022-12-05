package dashboard;

import javax.swing.*;
import java.awt.*;

public class NavigationPanel extends JPanel {

    private  JLabel iconArchivio;
    private JLabel labelArchivio;
    private JLabel labelGeneratore;
    private JLabel iconGeneratore;
    private JLabel iconSettings;
    private JLabel labelSettings;



    public NavigationPanel() {


        setLayout(new GridBagLayout());

        ImageIcon image = new ImageIcon("/home/wikilucio/IdeaProjects/MyPasswordManager/PasswordManager/src/main/resources/home.png");
        Image scaleimage = image.getImage().getScaledInstance(21,21,Image.SCALE_DEFAULT);

        iconArchivio = new JLabel(new ImageIcon(scaleimage));
        iconGeneratore = new JLabel(new ImageIcon(scaleimage));
        iconSettings = new JLabel(new ImageIcon(scaleimage));
        labelArchivio = new JLabel("Archivio");
        labelArchivio.setFont(new Font(null,0,18));
        labelGeneratore = new JLabel("Generatore");
        labelGeneratore.setFont(new Font(null,0,18));
        labelSettings = new JLabel("Impostazioni");
        labelSettings.setFont(new Font(null,0,18));



        GridBagConstraints gbc = new GridBagConstraints();


        gbc.gridx = 0;
        gbc.gridy = 0;

        gbc.weightx = 0.01;
        gbc.weighty = 0.01;
        gbc.anchor = GridBagConstraints.LINE_END;
        gbc.insets = new Insets(0,5,0,5);

        add(iconArchivio,gbc);


        gbc.gridx = 1;
        gbc.gridy = 0;

        gbc.weightx = 0.01;
        gbc.weighty = 0.01;
        gbc.anchor = GridBagConstraints.LINE_START;

        add(labelArchivio,gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;

        gbc.weightx = 0.01;
        gbc.weighty = 0.01;
        gbc.anchor = GridBagConstraints.LINE_END;
        gbc.insets = new Insets(0,5,0,5);

        add(iconGeneratore,gbc);


        gbc.gridx = 1;
        gbc.gridy = 1;

        gbc.weightx = 0.01;
        gbc.weighty = 0.01;
        gbc.anchor = GridBagConstraints.LINE_START;

        add(labelGeneratore,gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;

        gbc.weightx = 0.01;
        gbc.weighty = 0.01;
        gbc.anchor = GridBagConstraints.LINE_END;
        gbc.insets = new Insets(0,5,0,5);

        add(iconSettings,gbc);


        gbc.gridx = 1;
        gbc.gridy = 2;

        gbc.weightx = 0.5;
        gbc.weighty = 0.5;
        gbc.anchor = GridBagConstraints.LINE_START;

        add(labelSettings,gbc);




    }
}
