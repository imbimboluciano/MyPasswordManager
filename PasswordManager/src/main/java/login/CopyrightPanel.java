package login;

import javax.swing.*;
import java.awt.*;

public class CopyrightPanel extends JPanel {

    private JLabel copyright;

    public CopyrightPanel() {

        setPreferredSize(new Dimension(100,30));

        FlowLayout flow = new FlowLayout(FlowLayout.LEFT,7,6);
        setLayout(flow);


        copyright = new JLabel("Legal for Digital © Copyright 2021 by Luciano Imbimbo");

        add(copyright);
    }
}
