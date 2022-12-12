package dashboard;

import org.passay.CharacterData;
import org.passay.CharacterRule;
import org.passay.EnglishCharacterData;
import org.passay.PasswordGenerator;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.tools.Tool;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import static org.passay.DigestDictionaryRule.ERROR_CODE;

public class GeneratorePanel extends JPanel {

    private JLabel title;

    private JPanel optionPanel;
    private JPanel newPasswordPanel;
    private JPanel titlePanel;
    private JSlider sliderLunghezza;
    private JLabel labelLunghezza;
    private JLabel labelValueSlider;

    private JLabel labelLettereMaiuscole;
    private JCheckBox lettereMaiuscole;

    private JLabel labelLettereMinuscole;
    private JCheckBox lettereMinuscole;

    private JLabel labelNumeri;
    private JCheckBox numeri;

    private JLabel labelSimboli;
    private JCheckBox simboli;

    private JLabel labelQuantitaLettereMaiuscole;
    private JSpinner spinnerQuantitaLettereMaiuscole;

    private JLabel labelQuantitaNumeri;
    private JSpinner spinnerQuantitaNumeri;

    private JLabel labelQuantitaSimboli;
    private JSpinner spinnerQuantitaSimboli;

    private JButton btGenera;
    private JButton btCopiaPassword;

    private JTextArea newPassword;

    private final String errorPass = "Errore:Non è stato possibile generare la password";
    public GeneratorePanel() {


        setLayout(new BorderLayout());

        titlePanel = new JPanel();
        optionPanel = new JPanel();
        newPasswordPanel = new JPanel();


        optionPanel.setLayout(new GridBagLayout());
        newPasswordPanel.setLayout(new GridBagLayout());
        titlePanel.setLayout(new GridBagLayout());

        optionPanel.setPreferredSize(new Dimension(300,250));
        newPasswordPanel.setPreferredSize(new Dimension(300,300));

        add(optionPanel,BorderLayout.CENTER);
        add(newPasswordPanel,BorderLayout.PAGE_END);
        add(titlePanel,BorderLayout.PAGE_START);

        newPasswordPanel.setBorder(new EmptyBorder(new Insets(0,0,80,0)));

        sliderLunghezza = new JSlider(SwingConstants.HORIZONTAL,5,65,8);
        labelLunghezza = new JLabel("Lunghezza Password");

        labelLettereMaiuscole = new JLabel("Lettere Maiuscole (A-Z)");
        labelLettereMinuscole = new JLabel("Lettere Minuscole (a-z)");
        labelNumeri = new JLabel("Numeri (0-9)");
        labelSimboli = new JLabel("Caratteri speciali (!@#$%^&*()_+)");
        labelQuantitaLettereMaiuscole = new JLabel("Numero di lettere maiuscole:");
        labelQuantitaNumeri = new JLabel("Numero di cifre:");
        labelQuantitaSimboli = new JLabel("Numero di caratter speciali:");
        title = new JLabel("Generatore Password");
        title.setFont(new Font("Serif",Font.BOLD,30));
        labelValueSlider = new JLabel("Value: " + sliderLunghezza.getValue());



        labelQuantitaLettereMaiuscole.setVisible(false);
        labelQuantitaSimboli.setVisible(false);
        labelQuantitaNumeri.setVisible(false);


        lettereMaiuscole = new JCheckBox();
        lettereMinuscole = new JCheckBox("",true);
        numeri = new JCheckBox();
        simboli = new JCheckBox();

        lettereMinuscole.setEnabled(false);

        spinnerQuantitaLettereMaiuscole = new JSpinner(new SpinnerNumberModel(1,1,sliderLunghezza.getValue() - 1,1));
        spinnerQuantitaNumeri = new JSpinner(new SpinnerNumberModel(1,1,sliderLunghezza.getValue() ,1));
        spinnerQuantitaSimboli = new JSpinner(new SpinnerNumberModel(1,1,sliderLunghezza.getValue(),1));


        spinnerQuantitaLettereMaiuscole.setVisible(false);
        spinnerQuantitaNumeri.setVisible(false);
        spinnerQuantitaSimboli.setVisible(false);

        btGenera = new JButton("Genera Password");
        btCopiaPassword = new JButton("Copia Password");

        newPassword = new JTextArea(generatePassayPassword());
        newPassword.setFont(new Font("Serif",Font.BOLD,20));

        btGenera.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    String newPass = generatePassayPassword();
                    if(newPass.equals("")){
                        newPassword.setText(errorPass);
                        newPassword.setFont(new Font("Serif",Font.BOLD,15));
                    }else{
                        newPassword.setText(newPass);
                        newPassword.setFont(new Font("Serif",Font.BOLD,20));
                    }

            }
        });

        btCopiaPassword.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!newPassword.getText().equals(errorPass)){
                    copyStringToClipboard(newPassword.getText());
                }
            }
        });

        sliderLunghezza.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                labelValueSlider.setText("Value:" + ((JSlider) e.getSource()).getValue());
                spinnerQuantitaLettereMaiuscole.setModel(new SpinnerNumberModel(1,1,(((JSlider) e.getSource()).getValue() - 1),1));
            }
        });


        checkBoxEvent();




        GridBagConstraints gbc = new GridBagConstraints();


        gbc.gridx = 1;
        gbc.gridy = 0;

        gbc.anchor = GridBagConstraints.CENTER;

        optionPanel.add(labelValueSlider,gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;

        gbc.anchor = GridBagConstraints.LINE_START;
        gbc.insets = (new Insets(0,0,25,0));

        optionPanel.add(labelLunghezza,gbc);


        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = (new Insets(0,0,25,0));

        optionPanel.add(sliderLunghezza,gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.LINE_START;
        gbc.insets = (new Insets(5,0,5,0));

        optionPanel.add(labelLettereMinuscole,gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = (new Insets(5,0,5,0));

        optionPanel.add(lettereMinuscole,gbc);


        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.LINE_START;
        gbc.insets = (new Insets(5,0,5,0));

        optionPanel.add(labelLettereMaiuscole,gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = (new Insets(5,0,5,0));

        optionPanel.add(lettereMaiuscole,gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.anchor = GridBagConstraints.LINE_START;
        gbc.insets = (new Insets(5,0,8,0));

        optionPanel.add(labelQuantitaLettereMaiuscole,gbc);

        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = (new Insets(5,0,8,0));

        optionPanel.add(spinnerQuantitaLettereMaiuscole,gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.anchor = GridBagConstraints.LINE_START;
        gbc.insets = (new Insets(5,0,5,0));

        optionPanel.add(labelNumeri,gbc);

        gbc.gridx = 1;
        gbc.gridy = 5;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = (new Insets(5,0,5,0));

        optionPanel.add(numeri,gbc);

        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.anchor = GridBagConstraints.LINE_START;
        gbc.insets = (new Insets(5,0,8,0));

        optionPanel.add(labelQuantitaNumeri,gbc);

        gbc.gridx = 1;
        gbc.gridy = 6;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = (new Insets(5,0,5,0));

        optionPanel.add(spinnerQuantitaNumeri,gbc);

        gbc.gridx = 0;
        gbc.gridy = 7;
        gbc.anchor = GridBagConstraints.LINE_START;
        gbc.insets = (new Insets(5,0,5,0));

        optionPanel.add(labelSimboli,gbc);

        gbc.gridx = 1;
        gbc.gridy = 7;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = (new Insets(5,0,5,0));

        optionPanel.add(simboli,gbc);

        gbc.gridx = 0;
        gbc.gridy = 8;
        gbc.anchor = GridBagConstraints.LINE_START;
        gbc.insets = (new Insets(5,0,8,0));

        optionPanel.add(labelQuantitaSimboli,gbc);

        gbc.gridx = 1;
        gbc.gridy = 8;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = (new Insets(5,0,8,0));

        optionPanel.add(spinnerQuantitaSimboli,gbc);


        gbc.gridx = 0;
        gbc.gridy = 9;
        gbc.anchor = GridBagConstraints.PAGE_START;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(10,0,10,0);

        optionPanel.add(btGenera,gbc);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.PAGE_START;
        gbc.insets = new Insets(0,0,10,0);
        gbc.ipady = 30;


        newPasswordPanel.add(newPassword,gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.PAGE_START;
        gbc.insets = new Insets(10,0,10,0);
        gbc.ipady = 0;
        gbc.ipadx = 0;

        newPasswordPanel.add(btCopiaPassword,gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(60,0,0,0);
        gbc.ipady = 0;
        gbc.ipadx = 0;

        titlePanel.add(title,gbc);

    }


    public void checkBoxEvent(){
        lettereMaiuscole.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                labelQuantitaLettereMaiuscole.setVisible(lettereMaiuscole.isSelected());
                spinnerQuantitaLettereMaiuscole.setVisible(lettereMaiuscole.isSelected());
            }
        });

        numeri.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                labelQuantitaNumeri.setVisible(numeri.isSelected());
                spinnerQuantitaNumeri.setVisible(numeri.isSelected());
            }
        });

        simboli.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                labelQuantitaSimboli.setVisible(simboli.isSelected());
                spinnerQuantitaSimboli.setVisible(simboli.isSelected());
            }
        });
    }


    public String generatePassayPassword() {

        List<CharacterRule> rules = new ArrayList<>();
        int nMaiuscole = 0;
        int nNumeri = 0;
        int nSimboli = 0;

        PasswordGenerator gen = new PasswordGenerator();

        if(lettereMaiuscole.isSelected()){
            CharacterData upperCaseChars = EnglishCharacterData.UpperCase;
            CharacterRule upperCaseRule = new CharacterRule(upperCaseChars);
            nMaiuscole = (Integer) spinnerQuantitaLettereMaiuscole.getValue();
            upperCaseRule.setNumberOfCharacters(nMaiuscole);
            rules.add(upperCaseRule);


        }

        if(numeri.isSelected()){
            CharacterData digitChars = EnglishCharacterData.Digit;
            CharacterRule digitRule = new CharacterRule(digitChars);
            nNumeri = (Integer) spinnerQuantitaNumeri.getValue();
            digitRule.setNumberOfCharacters(nNumeri);
            rules.add(digitRule);
        }

        if(simboli.isSelected()){
            CharacterData specialChars = new CharacterData() {
                public String getErrorCode() {
                    return ERROR_CODE;
                }

                public String getCharacters() {
                    return "!@#$%^&*()_+";
                }
            };
            CharacterRule splCharRule = new CharacterRule(specialChars);
            nSimboli = (Integer) spinnerQuantitaSimboli.getValue();
            splCharRule.setNumberOfCharacters(nSimboli);
            rules.add(splCharRule);
        }


        CharacterData lowerCaseChars = EnglishCharacterData.LowerCase;
        CharacterRule lowerCaseRule = new CharacterRule(lowerCaseChars);
        lowerCaseRule.setNumberOfCharacters(sliderLunghezza.getValue() - nMaiuscole - nNumeri - nSimboli);
        rules.add(lowerCaseRule);



        return gen.generatePassword(sliderLunghezza.getValue(),rules);

    }


    public static void copyStringToClipboard(String str){
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(new StringSelection(str),null);
    }

}
