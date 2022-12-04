package login;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class LogoPanel extends JPanel {

    private  JLabel logo;

    public LogoPanel() {


         setPreferredSize(new Dimension(100,100));

        FlowLayout flow = new FlowLayout(0,30,5);
        setLayout(flow);

        ImageIcon icon = new ImageIcon("/home/wikilucio/IdeaProjects/MyPasswordManager/PasswordManager/src/main/resources/logo.png");
        Image scaleimage = icon.getImage().getScaledInstance(150,80,Image.SCALE_DEFAULT);

        logo = new JLabel(new ImageIcon(scaleimage));
        // add(logo);


    }
}
