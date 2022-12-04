package login;

import com.formdev.flatlaf.FlatDarculaLaf;

import javax.swing.*;

public class TestLogin {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(new FlatDarculaLaf()); // Look and feel
                    UIManager.put("Button.arc",10);
                    UIManager.put("TextComponent.arc",0);
                } catch (UnsupportedLookAndFeelException e) {
                    e.printStackTrace();
                }
                new LoginFrame();
            }
        });
    }
}
