package login;

import com.formdev.flatlaf.FlatDarculaLaf;

import javax.swing.*;

public class TestLogin {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new LoginFrame();
            }
        });
    }
}
