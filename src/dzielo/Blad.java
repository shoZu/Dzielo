package dzielo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class Blad extends Frame implements WindowListener, ActionListener {

    String error;
    JTextArea errorLabel;
    Button exit;

    public Blad(String error) {
        super("Blad");
        this.error = error;
        setVisible(true);
        setSize(380, 200);
        this.addWindowListener(this);
        this.setLayout(null);
        setLocation(500, 300);
        errorLabel = new JTextArea(error);
        add(errorLabel);
        errorLabel.setBounds(40, 50, 340, 70);

        exit = new Button("Zamknij blad");
        add(exit);
        exit.setBounds(120, 140, 100, 30);
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
