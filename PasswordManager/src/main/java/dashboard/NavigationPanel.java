package dashboard;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class NavigationPanel extends JPanel {

    private  JLabel iconArchivio;
    private JLabel labelArchivio;
    private JLabel labelGeneratore;
    private JLabel iconGeneratore;
    private JLabel iconSettings;
    private JLabel labelSettings;

    private NavigationListener navigationListener;



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

        labelArchivio.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
               if (navigationListener != null){
                   navigationListener.NavigationEventListener(labelArchivio.getText());
               }
            }
        });

        labelGeneratore.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (navigationListener != null){
                    navigationListener.NavigationEventListener(labelGeneratore.getText());
                }
            }
        });

        labelSettings.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(navigationListener != null){
                    navigationListener.NavigationEventListener(labelSettings.getText());
                }
            }
        });



        GridBagConstraints gbc = new GridBagConstraints();


        gbc.gridx = 0;
        gbc.gridy = 0;

        gbc.anchor = GridBagConstraints.LINE_END;
        gbc.insets = new Insets(0,5,10,5);

        add(iconArchivio,gbc);


        gbc.gridx = 1;
        gbc.gridy = 0;


        gbc.anchor = GridBagConstraints.LINE_START;
        gbc.insets = new Insets(0,0,10,0);

        add(labelArchivio,gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;

        gbc.anchor = GridBagConstraints.LINE_END;
        gbc.insets = new Insets(0,5,10,5);

        add(iconGeneratore,gbc);


        gbc.gridx = 1;
        gbc.gridy = 1;

        gbc.anchor = GridBagConstraints.LINE_START;
        gbc.insets = new Insets(0,0,10,0);

        add(labelGeneratore,gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;

        gbc.anchor = GridBagConstraints.LINE_END;
        gbc.insets = new Insets(0,5,10,5);

        add(iconSettings,gbc);


        gbc.gridx = 1;
        gbc.gridy = 2;

        gbc.anchor = GridBagConstraints.LINE_START;
        gbc.insets = new Insets(0,0,10,0);
        add(labelSettings,gbc);



    }

    public void setNavigationEvent(NavigationListener navigationListener){
        this.navigationListener  = navigationListener;
    }
}
