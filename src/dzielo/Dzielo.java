package dzielo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class Dzielo extends Frame implements WindowListener, ActionListener {
    double expanse = 0.2;
    Button generate, clear;
    TextField name, surname, hour, wage;
    Label titleLabel, nameLabel, surnameLabel, hourLabel, wageLabel, wageLabel2, expanseLabel;
    JRadioButton option1, option2;
    ButtonGroup buttonGroup;

    public Dzielo() {
        super("Umowa o dzielo");
        setVisible(true);
        setSize(430, 350);
        this.addWindowListener(this);
        this.setLayout(null);

        titleLabel = new Label("Arkusz umowy o dzieło");
        add(titleLabel);
        titleLabel.setBounds(130, 50, 250, 25);

        nameLabel = new Label("Imie: ");
        add(nameLabel);
        nameLabel.setBounds(50, 100, 100, 25);

        name = new TextField();
        add(name);
        name.setBounds(200, 100, 180, 25);

        surnameLabel = new Label("Nazwisko: ");
        add(surnameLabel);
        surnameLabel.setBounds(50, 125, 150, 25);

        surname = new TextField();
        add(surname);
        surname.setBounds(200, 125, 180, 25);

        hourLabel = new Label("Ilosc godzin: ");
        add(hourLabel);
        hourLabel.setBounds(50, 150, 150, 25);

        hour = new TextField();
        add(hour);
        hour.setBounds(200, 150, 180, 25);

        wageLabel = new Label("Stawka godzinowa: ");
        add(wageLabel);
        wageLabel.setBounds(50, 175, 150, 25);

        wage = new TextField();
        add(wage);
        wage.setBounds(200, 175, 160, 25);

        wageLabel2 = new Label("zł");
        add(wageLabel2);
        wageLabel2.setBounds(360, 175, 20, 25);

        expanseLabel = new Label("Koszt uzyskania przychodu");
        add(expanseLabel);
        expanseLabel.setBounds(50, 200, 150, 25);

        option1 = new JRadioButton();
        option1.setText("20%");
        option1.setBounds(220, 200, 80, 25);
        add(option1);

        option2 = new JRadioButton();
        option2.setText("50%");
        option2.setBounds(300, 200, 80, 25);
        add(option2);

        buttonGroup = new ButtonGroup();
        buttonGroup.add(option1);
        buttonGroup.add(option2);
        option1.setSelected(true);

        generate = new Button("Generuj arkusz pracownika");
        add(generate);
        generate.setBounds(50, 250, 330, 25);
        generate.addActionListener(this);

        clear = new Button("Wyczyść dane");
        add(clear);
        clear.setBounds(50, 290, 330, 25);
        clear.addActionListener(this);
        repaint();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == clear) {
            name.setText(" ");
            surname.setText(" ");
            wage.setText(" ");
            hour.setText(" ");
        }

        if (option2.isSelected()) expanse = 0.5;
        else expanse = 0.2;

        if (e.getSource() == generate) {
            int counter = 0;
            StringBuilder string = new StringBuilder();
            if (name.getText().equals("")) {
                string.append("Podaj imie prcowanika \n");
                counter++;
            }
            if (surname.getText().equals("")) {
                string.append("Podaj nazwisko pracownika \n");
                counter++;
            }
            if (hour.getText().equals("")) {
                string.append("Podaj ilosc przepracowanych godzin pracownika \n");
                counter++;
            }
            if (!isNumeric(hour.getText()) && !hour.getText().equals("")) {
                string.append("Podaj poprawna ilosc przepracowanych godzin pracownika \n");
                counter++;
            }
            if (isNumeric(hour.getText())) {
                if ((Double.parseDouble(hour.getText()) < 0)) {
                    string.append("Ilosc godzin musi byc liczba wieszka od 0 \n");
                    counter++;
                }
            }
            if (wage.getText().equals("")) {
                string.append("Podaj stawke godzinowa pracownika \n");
                counter++;
            }
            if (!isNumeric(wage.getText()) && !wage.getText().equals("")) {
                string.append("Podaj poprawna stawke godzinowa pracownika ( Wyłącznie liczby ) \n");
                counter++;
            }
            if (isNumeric(wage.getText())) {
                if (Double.parseDouble(wage.getText()) < 0) {
                    string.append("Stawka musi byc liczba wieszka od 0 \n");
                    counter++;
                }
            }

            if (counter > 0) new Blad(string.toString());
            else
                new Arkusz(name.getText(), surname.getText(), Double.parseDouble(hour.getText()), Double.parseDouble(wage.getText()), expanse);
        }
    }

    public static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            double i = Double.parseDouble(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    @Override
    public void windowOpened(WindowEvent e) {

    }

    @Override
    public void windowClosing(WindowEvent e) {
        System.exit(0);
    }

    @Override
    public void windowClosed(WindowEvent e) {

    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }
}
