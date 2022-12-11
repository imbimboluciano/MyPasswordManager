package dashboard;

import org.passay.CharacterData;
import org.passay.CharacterRule;
import org.passay.EnglishCharacterData;
import org.passay.PasswordGenerator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import static org.passay.DigestDictionaryRule.ERROR_CODE;

public class GeneratorePanel extends JPanel {


    private JSlider sliderLunghezza;
    private JLabel labelLunghezza;

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

    private JLabel labelQuantitaLettereMinuscole;
    private JSpinner spinnerQuantitaLettereMinuscole;

    private JLabel labelQuantitaNumeri;
    private JSpinner spinnerQuantitaNumeri;

    private JLabel labelQuantitaSimboli;
    private JSpinner spinnerQuantitaSimboli;

    private JButton btGenera;

    private JLabel newPassword;

    public GeneratorePanel() {


        setLayout(new GridBagLayout());

        sliderLunghezza = new JSlider(SwingConstants.HORIZONTAL,5,100,8);
        labelLunghezza = new JLabel("Lunghezza Password");

        labelLettereMaiuscole = new JLabel("Lettere Maiuscole (A-Z)");
        labelLettereMinuscole = new JLabel("Lettere Minuscole (a-z)");
        labelNumeri = new JLabel("Numeri (0-9)");
        labelSimboli = new JLabel("Caratteri speciali (!@#$%^&*()_+)");
        labelQuantitaLettereMaiuscole = new JLabel("Numero di lettere maiuscole:");
        labelQuantitaLettereMinuscole = new JLabel("Numero di lettere minuscole:");
        labelQuantitaNumeri = new JLabel("Numero di cifre:");
        labelQuantitaSimboli = new JLabel("Numero di caratter speciali:");
        newPassword = new JLabel("");

        labelQuantitaLettereMaiuscole.setVisible(false);
        labelQuantitaLettereMinuscole.setVisible(false);
        labelQuantitaSimboli.setVisible(false);
        labelQuantitaNumeri.setVisible(false);


        lettereMaiuscole = new JCheckBox();
        lettereMinuscole = new JCheckBox();
        numeri = new JCheckBox();
        simboli = new JCheckBox();

        spinnerQuantitaLettereMaiuscole = new JSpinner(new SpinnerNumberModel(1,1,sliderLunghezza.getValue(),1));
        spinnerQuantitaLettereMinuscole = new JSpinner(new SpinnerNumberModel(1,1,sliderLunghezza.getValue(),1));
        spinnerQuantitaNumeri = new JSpinner(new SpinnerNumberModel(1,1,sliderLunghezza.getValue(),1));
        spinnerQuantitaSimboli = new JSpinner(new SpinnerNumberModel(1,1,sliderLunghezza.getValue(),1));

        spinnerQuantitaLettereMinuscole.setVisible(false);
        spinnerQuantitaLettereMaiuscole.setVisible(false);
        spinnerQuantitaNumeri.setVisible(false);
        spinnerQuantitaSimboli.setVisible(false);

        btGenera = new JButton("Genera Password");

        btGenera.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    String newPass = generatePassayPassword();
                    if(newPass.equals("")){
                        newPassword.setText("Non è stato possibile generare una password");
                    }else{
                        newPassword.setText(newPass);
                    }

            }
        });


        checkBoxEvent();


        GridBagConstraints gbc = new GridBagConstraints();

        gbc.gridx = 0;
        gbc.gridy = 0;

        gbc.anchor = GridBagConstraints.LINE_START;
        add(labelLunghezza,gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.CENTER;

        add(sliderLunghezza,gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.LINE_START;

        add(labelLettereMaiuscole,gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.CENTER;

        add(lettereMaiuscole,gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.LINE_START;

        add(labelQuantitaLettereMaiuscole,gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.CENTER;

        add(spinnerQuantitaLettereMaiuscole,gbc);


        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.LINE_START;

        add(labelLettereMinuscole,gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.CENTER;

        add(lettereMinuscole,gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.anchor = GridBagConstraints.LINE_START;

        add(labelQuantitaLettereMinuscole,gbc);

        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.anchor = GridBagConstraints.CENTER;

        add(spinnerQuantitaLettereMinuscole,gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.anchor = GridBagConstraints.LINE_START;

        add(labelNumeri,gbc);

        gbc.gridx = 1;
        gbc.gridy = 5;
        gbc.anchor = GridBagConstraints.CENTER;

        add(numeri,gbc);

        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.anchor = GridBagConstraints.LINE_START;

        add(labelQuantitaNumeri,gbc);

        gbc.gridx = 1;
        gbc.gridy = 6;
        gbc.anchor = GridBagConstraints.CENTER;

        add(spinnerQuantitaNumeri,gbc);

        gbc.gridx = 0;
        gbc.gridy = 7;
        gbc.anchor = GridBagConstraints.LINE_START;

        add(labelSimboli,gbc);

        gbc.gridx = 1;
        gbc.gridy = 7;
        gbc.anchor = GridBagConstraints.CENTER;

        add(simboli,gbc);

        gbc.gridx = 0;
        gbc.gridy = 8;
        gbc.anchor = GridBagConstraints.LINE_START;

        add(labelQuantitaSimboli,gbc);

        gbc.gridx = 1;
        gbc.gridy = 8;
        gbc.anchor = GridBagConstraints.CENTER;

        add(spinnerQuantitaSimboli,gbc);


        gbc.gridx = 0;
        gbc.gridy = 9;
        gbc.anchor = GridBagConstraints.PAGE_START;
        gbc.gridwidth = 2;

        add(btGenera,gbc);

        gbc.gridx = 0;
        gbc.gridy = 10;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.gridwidth = 2;

        add(newPassword,gbc);







    }


    public void checkBoxEvent(){
        lettereMaiuscole.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                labelQuantitaLettereMaiuscole.setVisible(lettereMaiuscole.isSelected());
                spinnerQuantitaLettereMaiuscole.setVisible(lettereMaiuscole.isSelected());
            }
        });

        lettereMinuscole.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                labelQuantitaLettereMinuscole.setVisible((lettereMinuscole.isSelected()));
                spinnerQuantitaLettereMinuscole.setVisible(lettereMinuscole.isSelected());
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

        PasswordGenerator gen = new PasswordGenerator();

        if(lettereMaiuscole.isSelected()){
            CharacterData upperCaseChars = EnglishCharacterData.UpperCase;
            CharacterRule upperCaseRule = new CharacterRule(upperCaseChars);
            upperCaseRule.setNumberOfCharacters((Integer) spinnerQuantitaLettereMaiuscole.getValue());
            rules.add(upperCaseRule);

        }

        if(lettereMinuscole.isSelected()){
            CharacterData lowerCaseChars = EnglishCharacterData.LowerCase;
            CharacterRule lowerCaseRule = new CharacterRule(lowerCaseChars);
            lowerCaseRule.setNumberOfCharacters((Integer) spinnerQuantitaLettereMinuscole.getValue());
            rules.add(lowerCaseRule);
        }


        if(numeri.isSelected()){
            CharacterData digitChars = EnglishCharacterData.Digit;
            CharacterRule digitRule = new CharacterRule(digitChars);
            digitRule.setNumberOfCharacters((Integer) spinnerQuantitaNumeri.getValue());
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
            splCharRule.setNumberOfCharacters((Integer) spinnerQuantitaSimboli.getValue());
            rules.add(splCharRule);
        }





        if(!rules.isEmpty()){
            return gen.generatePassword(sliderLunghezza.getValue(),rules);
        }

        return "";
    }


}
