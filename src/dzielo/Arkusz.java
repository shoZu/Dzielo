package dzielo;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.math.BigDecimal;

public class Arkusz extends Frame implements WindowListener, ActionListener {
    String name, surname;
    double hour, wage, expanse;
    BigDecimal tax, gross, net;
    Button exit;

    Label titleLabel, nameLabel, hourLabel, wageLabel, grossLabel, netLabel, taxLabel;

    public Arkusz(String name, String surname, double hour, double wage, double expanse) {
        super("Wygenerowany arkusz");
        this.name = name;
        this.surname = surname;
        this.hour = hour;
        this.wage = wage;
        this.expanse = expanse;
        setVisible(true);
        setSize(400, 330);
        setLocation(430,0);
        this.addWindowListener(this);
        this.setLayout(null);

        titleLabel = new Label("Wygenerowany arkusz");
        add(titleLabel);
        titleLabel.setBounds(130, 50, 250, 25);

        nameLabel = new Label(name + " " + surname);
        add(nameLabel);
        nameLabel.setBounds(50, 100, 250, 25);

        hourLabel = new Label("Ilosc godzin: " + hour);
        add(hourLabel);
        hourLabel.setBounds(50, 125, 250, 25);

        wageLabel = new Label("Stawka godzinowa: " + new BigDecimal(wage).setScale(2,BigDecimal.ROUND_HALF_EVEN) + " zł");
        add(wageLabel);
        wageLabel.setBounds(50, 150, 250, 25);

        gross = BigDecimal.valueOf(wage * hour).setScale(2,BigDecimal.ROUND_HALF_EVEN);

        tax = gross.subtract(gross.multiply(new BigDecimal(expanse))).multiply(new BigDecimal("0.18")).setScale(0, BigDecimal.ROUND_HALF_EVEN);
        net = gross.subtract(tax).setScale(2, BigDecimal.ROUND_HALF_EVEN);

        grossLabel = new Label("Płaca brutto: " + gross + " zł");
        add(grossLabel);
        grossLabel.setBounds(50, 175, 250, 25);

        taxLabel = new Label("Podatek: " + tax + ".00 zł");
        add(taxLabel);
        taxLabel.setBounds(50, 200, 250, 25);

        netLabel = new Label("Płaca netto: " + net + " zł");
        add(netLabel);
        netLabel.setBounds(50, 225, 250, 25);

        exit = new Button("Zamknij arkusz");
        add(exit);
        exit.setBounds(130, 270, 150, 30);
        exit.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == exit) {
            dispose();
        }
    }

    @Override
    public void windowOpened(WindowEvent e) {

    }

    @Override
    public void windowClosing(WindowEvent e) {
        dispose();
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
