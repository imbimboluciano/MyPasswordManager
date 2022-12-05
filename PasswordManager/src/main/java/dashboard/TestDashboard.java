package dashboard;

import com.formdev.flatlaf.FlatDarculaLaf;

import javax.swing.*;

public class TestDashboard {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {

                try {
                    UIManager.setLookAndFeel(new FlatDarculaLaf()); // Look and feel
                } catch (UnsupportedLookAndFeelException e) {
                    throw new RuntimeException(e);
                }
                UIManager.put("Button.arc",10);
                UIManager.put("TextComponent.arc",0);
                new DashboardFrame("example@email.it");
            }
        });
    }
}
