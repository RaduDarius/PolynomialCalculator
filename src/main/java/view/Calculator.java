package view;

import model.Monomial;
import model.Polynomial;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator extends JFrame{
    private JPanel mainPanel;
    private JPanel buttonsPanel;
    private JButton a1Button;
    private JButton a4Button;
    private JButton a7Button;
    private JButton a2Button;
    private JButton a3Button;
    private JButton a5Button;
    private JButton a6Button;
    private JButton a8Button;
    private JButton a9Button;
    private JButton a0Button;
    private JButton resultButton;
    private JTextField txtResult;
    private JButton clearButton;
    private JButton addButton;
    private JButton multiplyButton;
    private JButton divideButton;
    private JButton deriveButton;
    private JButton integrateButton;
    private JButton subtractButton;
    private JButton xButton;
    private JButton minusButton;
    private JButton powButton;
    private JButton deleteButton;
    private JButton plusButton;
    private JLabel lblRest;

    private char op;

    private ArrayList<Polynomial> model;

    public Calculator(ArrayList<Polynomial> model) {

        this.model = model;

        this.setSize(350, 400);
        this.setTitle("Polynomial calculator");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);

        txtResult.setEditable(false);

        this.setContentPane(mainPanel);
        this.setVisible(true);
    }

    public Polynomial readData() {

        String input = txtResult.getText();

        Polynomial polynomial = new Polynomial(new ArrayList<>());

        Pattern allPattern = Pattern.compile("-?(\\d*)?[a-zA-Z]?(\\^\\d*)?");
        Matcher allMatcher = allPattern.matcher(input);

        while (allMatcher.find()) {

            if (!allMatcher.group(0).isBlank()) {
                String txt = allMatcher.group(0);

                if (!txt.contains("X")) {

                    polynomial.getMonomials().add(new Monomial(Double.parseDouble(txt), 0));

                }
                else {

                    Pattern pattern = Pattern.compile("-?\\d*");
                    Matcher matcher = pattern.matcher(txt);

                    ArrayList<String> list = new ArrayList<>();

                    while (matcher.find()) {
                        if (!matcher.group(0).isBlank()) {
                            list.add(matcher.group(0));
                        }
                    }

                    if (list.size() == 2) {
                        if (list.get(0).equals("-")) {
                            polynomial.getMonomials().add(new Monomial(-1, Integer.parseInt(list.get(1))));
                        } else {
                            polynomial.getMonomials().add(new Monomial(Double.parseDouble(list.get(0)), Integer.parseInt(list.get(1))));
                        }
                    }
                    else {
                        if (txt.charAt(0) == 'X') {

                            if (!txt.equals("X")) {
                                polynomial.getMonomials().add(new Monomial(1, Integer.parseInt(list.get(0))));
                            } else {
                                polynomial.getMonomials().add(new Monomial(1, 1));
                            }

                        } else {
                            if (txt.equals("-X")) {
                                polynomial.getMonomials().add(new Monomial(-1, 1));
                            } else {
                                polynomial.getMonomials().add(new Monomial(Double.parseDouble(list.get(0)), 1));
                            }
                        }
                    }

                }
            }
        }

        Polynomial newPolynomial = new Polynomial(new ArrayList<>());

        for (Monomial monomial: polynomial.getMonomials()) {

            if (monomial.getCoefficient() != 0) {

                boolean found = false;
                Monomial aux = new Monomial(0, 0);

                for (Monomial m: newPolynomial.getMonomials()) {
                    if (monomial.getDegree() == m.getDegree()) {
                        found = true;
                        aux = m;
                    }
                }

                if (found) {
                    double newCoefficient = aux.getCoefficient() + monomial.getCoefficient();
                    if (newCoefficient != 0) {
                        aux.setCoefficient(newCoefficient);
                    } else {
                        newPolynomial.getMonomials().remove(aux);
                    }
                } else {
                    newPolynomial.getMonomials().add(monomial);
                }

            }

        }

        newPolynomial.getMonomials().sort((o1, o2) -> Integer.signum(o2.getDegree() - o1.getDegree()) );

        if (newPolynomial.getMonomials().size() == 0) {
            newPolynomial.getMonomials().add(new Monomial(0, 0));
        }

        for (Monomial m: newPolynomial.getMonomials()) {
            System.out.println(m);
        }

        return newPolynomial;

    }

    //Methods for adding ActionListeners for buttons

    public void adda0BtnListener(ActionListener a) {
        a0Button.addActionListener(a);
    }

    public void adda1BtnListener(ActionListener a) {
        a1Button.addActionListener(a);
    }

    public void adda2BtnListener(ActionListener a) {
        a2Button.addActionListener(a);
    }

    public void adda3BtnListener(ActionListener a) {
        a3Button.addActionListener(a);
    }

    public void adda4BtnListener(ActionListener a) {
        a4Button.addActionListener(a);
    }

    public void adda5BtnListener(ActionListener a) {
        a5Button.addActionListener(a);
    }

    public void adda6BtnListener(ActionListener a) {
        a6Button.addActionListener(a);
    }

    public void adda7BtnListener(ActionListener a) {
        a7Button.addActionListener(a);
    }

    public void adda8BtnListener(ActionListener a) {
        a8Button.addActionListener(a);
    }

    public void adda9BtnListener(ActionListener a) {
        a9Button.addActionListener(a);
    }

    public void addMinusBtnListener(ActionListener a) {
        minusButton.addActionListener(a);
    }

    public void addPlusBtnListener(ActionListener a) {
        plusButton.addActionListener(a);
    }

    public void addPowBtnListener(ActionListener a) {
        powButton.addActionListener(a);
    }

    public void addXBtnListener(ActionListener a) {
        xButton.addActionListener(a);
    }

    public void addResultBtnListener(ActionListener a) {
        resultButton.addActionListener(a);
    }

    public void addClearBtnListener(ActionListener a) {
        clearButton.addActionListener(a);
    }

    public void addDeleteBtnListener(ActionListener a) {
        deleteButton.addActionListener(a);
    }

    public void addAddBtnListener(ActionListener a) {
        addButton.addActionListener(a);
    }

    public void addMultiplyBtnListener(ActionListener a) {
        multiplyButton.addActionListener(a);
    }

    public void addSubtractBtnListener(ActionListener a) {
        subtractButton.addActionListener(a);
    }

    public void addDivideBtnListener(ActionListener a) {
        divideButton.addActionListener(a);
    }

    public void addDeriveBtnListener(ActionListener a) {
        deriveButton.addActionListener(a);
    }

    public void addIntegrateBtnListener(ActionListener a) {
        integrateButton.addActionListener(a);
    }

    //Setters and Getters:


    public JLabel getLblRest() {
        return lblRest;
    }

    public char getOp() {
        return op;
    }

    public void setOp(char op) {
        this.op = op;
    }

    public JButton getA1Button() {
        return a1Button;
    }

    public JButton getA4Button() {
        return a4Button;
    }

    public JButton getA7Button() {
        return a7Button;
    }

    public JButton getA2Button() {
        return a2Button;
    }

    public JButton getA3Button() {
        return a3Button;
    }

    public JButton getA5Button() {
        return a5Button;
    }

    public JButton getA6Button() {
        return a6Button;
    }

    public JButton getA8Button() {
        return a8Button;
    }

    public JButton getA9Button() {
        return a9Button;
    }

    public JButton getA0Button() {
        return a0Button;
    }

    public JTextField getTxtResult() {
        return txtResult;
    }

    public ArrayList<Polynomial> getModel() {
        return model;
    }
}
