package org.example.Control;

import org.example.*;
import org.example.Logic.Operations;
import org.example.Model.Monomial;
import org.example.Model.Polynomial;
import org.example.View.View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class Controller implements ActionListener {
    private Operations op = new Operations();
    private Polynomial polynomial1 = new Polynomial();
    private Polynomial polynomial2 = new Polynomial();
    private static View gui;

    public Controller(Polynomial polynomial1, Polynomial polynomial2) {
        this.polynomial1 = polynomial1;
        this.polynomial2 = polynomial2;
    }

    public Controller(View gui) {
        this.gui = gui;
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == gui.calculateButton) {
            String text = gui.poly1.getText();
            polynomial1 = op.buildPolynomial(text);                      // extracts the first polynomial from the text field

            String text2 = gui.poly2.getText();
            polynomial2 = op.buildPolynomial(text2);                    // extracts the second polynomial from the text field

            if (gui.operations.getSelectedItem() == "Add") {
                Polynomial add = op.add(polynomial1, polynomial2);
                String rez = op.polynomialToString(add);
                gui.result.setText(rez);
            } else if (gui.operations.getSelectedItem() == "Subtract") {
                Polynomial sub = op.sub(polynomial1, polynomial2);
                String rez = op.polynomialToString(sub);
                gui.result.setText(rez);
            } else if (gui.operations.getSelectedItem() == "Multiply") {
                Polynomial mult = op.multiply(polynomial1, polynomial2);
                String rez = op.polynomialToString(mult);
                gui.result.setText(rez);
            } else if (gui.operations.getSelectedItem() == "Derivative") {
                Polynomial deriv = op.derivative(polynomial1);
                String rez = op.polynomialToString(deriv);
                gui.result.setText(rez);
            } else if (gui.operations.getSelectedItem() == "Integrate") {
                Polynomial integ = op.integrate(polynomial1);
                String rez = op.polynomialToString(integ);
                gui.result.setText(rez);
            }
        }
    }

}
