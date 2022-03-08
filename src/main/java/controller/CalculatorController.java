package controller;

import model.Monomial;
import model.Polynomial;
import view.Calculator;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;

public class CalculatorController {

    private Calculator view;
    private ArrayList<Polynomial> model;

    public CalculatorController(Calculator view, ArrayList<Polynomial> model) {
        this.view = view;
        this.model = model;

        view.addClearBtnListener(new ClearBtnListener());
        view.addDeleteBtnListener(new DeleteBtnListener());
        view.adda0BtnListener(new A0BtnListener());
        view.adda1BtnListener(new A1BtnListener());
        view.adda2BtnListener(new A2BtnListener());
        view.adda3BtnListener(new A3BtnListener());
        view.adda4BtnListener(new A4BtnListener());
        view.adda5BtnListener(new A5BtnListener());
        view.adda6BtnListener(new A6BtnListener());
        view.adda7BtnListener(new A7BtnListener());
        view.adda8BtnListener(new A8BtnListener());
        view.adda9BtnListener(new A9BtnListener());
        view.addMinusBtnListener(new MinusBtnListener());
        view.addPlusBtnListener(new PlusBtnListener());
        view.addXBtnListener(new XBtnListener());
        view.addPowBtnListener(new PowBtnListener());

        view.addAddBtnListener(new AddBtnListener());
        view.addSubtractBtnListener(new SubtractBtnListener());
        view.addMultiplyBtnListener(new MultiplyBtnListener());
        view.addDivideBtnListener(new DivideBtnListener());
        view.addDeriveBtnListener(new DeriveBtnListener());
        view.addIntegrateBtnListener(new IntegrateBtnListener());

        view.addResultBtnListener(new ResultBtnListener());
    }

    //Inner Classes

    class ClearBtnListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            view.getTxtResult().setText("");
            view.getLblRest().setText("");
            model.removeAll(model);
        }
    }

    class DeleteBtnListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            view.getLblRest().setText("");
            String txt = view.getTxtResult().getText();

            if (txt.length() != 0) {
                String newTxt = txt.substring(0, txt.length() - 1);

                view.getTxtResult().setText(newTxt);
                if (newTxt.length() == 0) {
                    model.removeAll(model);
                }
            }
        }
    }

    class A0BtnListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            view.getLblRest().setText("");
            String txt = view.getTxtResult().getText();

            if (txt.isBlank() || txt.charAt(txt.length() - 1) != 'X' && !txt.equals("0")) {
                txt += "0";

                view.getTxtResult().setText(txt);
            }

        }
    }

    class A1BtnListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            view.getLblRest().setText("");
            String txt = view.getTxtResult().getText();

            if (txt.equals("0") || txt.isBlank()) {
                view.getTxtResult().setText("1");
            } else {

                if (txt.charAt(txt.length() - 1) != 'X' && !(txt.charAt(txt.length() - 1) == '0' && txt.charAt(txt.length() - 2) == '^') ) {

                    txt += "1";
                    view.getTxtResult().setText(txt);
                }
            }
        }

    }

    class A2BtnListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            view.getLblRest().setText("");
            String txt = view.getTxtResult().getText();

            if (txt.equals("0") || txt.isBlank()) {
                view.getTxtResult().setText("2");
            } else {

                if (txt.charAt(txt.length() - 1) != 'X' && !(txt.charAt(txt.length() - 1) == '0' && txt.charAt(txt.length() - 2) == '^') ) {

                    txt += "2";

                    view.getTxtResult().setText(txt);
                }
            }
        }

    }

    class A3BtnListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            view.getLblRest().setText("");
            String txt = view.getTxtResult().getText();

            if (txt.equals("0") || txt.isBlank()) {
                view.getTxtResult().setText("3");
            } else {

                if (txt.charAt(txt.length() - 1) != 'X' && !(txt.charAt(txt.length() - 1) == '0' && txt.charAt(txt.length() - 2) == '^') ) {

                    txt += "3";

                    view.getTxtResult().setText(txt);
                }
            }
        }

    }

    class A4BtnListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            view.getLblRest().setText("");
            String txt = view.getTxtResult().getText();

            if (txt.equals("0") || txt.isBlank()) {
                view.getTxtResult().setText("4");
            } else {

                if (txt.charAt(txt.length() - 1) != 'X' && !(txt.charAt(txt.length() - 1) == '0' && txt.charAt(txt.length() - 2) == '^') ) {

                    txt += "4";

                    view.getTxtResult().setText(txt);
                }
            }
        }

    }

    class A5BtnListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            view.getLblRest().setText("");
            String txt = view.getTxtResult().getText();

            if (txt.equals("0") || txt.isBlank()) {
                view.getTxtResult().setText("5");
            } else {

                if (txt.charAt(txt.length() - 1) != 'X' && !(txt.charAt(txt.length() - 1) == '0' && txt.charAt(txt.length() - 2) == '^') ) {

                    txt += "5";

                    view.getTxtResult().setText(txt);
                }
            }
        }

    }

    class A6BtnListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            view.getLblRest().setText("");
            String txt = view.getTxtResult().getText();

            if (txt.equals("0") || txt.isBlank()) {
                view.getTxtResult().setText("6");
            } else {

                if (txt.charAt(txt.length() - 1) != 'X' && !(txt.charAt(txt.length() - 1) == '0' && txt.charAt(txt.length() - 2) == '^') ) {

                    txt += "6";

                    view.getTxtResult().setText(txt);
                }
            }
        }

    }

    class A7BtnListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            view.getLblRest().setText("");
            String txt = view.getTxtResult().getText();

            if (txt.equals("0") || txt.isBlank()) {
                view.getTxtResult().setText("7");
            } else {

                if (txt.charAt(txt.length() - 1) != 'X' && !(txt.charAt(txt.length() - 1) == '0' && txt.charAt(txt.length() - 2) == '^') ) {

                    txt += "7";

                    view.getTxtResult().setText(txt);
                }
            }
        }

    }

    class A8BtnListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            view.getLblRest().setText("");
            String txt = view.getTxtResult().getText();

            if (txt.equals("0") || txt.isBlank()) {
                view.getTxtResult().setText("8");
            } else {

                if (txt.charAt(txt.length() - 1) != 'X' && !(txt.charAt(txt.length() - 1) == '0' && txt.charAt(txt.length() - 2) == '^') ) {

                    txt += "8";

                    view.getTxtResult().setText(txt);
                }
            }
        }

    }

    class A9BtnListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            view.getLblRest().setText("");
            String txt = view.getTxtResult().getText();

            if (txt.equals("0") || txt.isBlank()) {
                view.getTxtResult().setText("9");
            } else {

                if (txt.charAt(txt.length() - 1) != 'X' && !(txt.charAt(txt.length() - 1) == '0' && txt.charAt(txt.length() - 2) == '^') ) {

                    txt += "9";

                    view.getTxtResult().setText(txt);
                }
            }
        }

    }

    class MinusBtnListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            view.getLblRest().setText("");
            String txt = view.getTxtResult().getText();

            if (txt.isBlank()) {
                view.getTxtResult().setText("-");
            } else {
                if (txt.charAt(txt.length() - 1) != '+' && txt.charAt(txt.length() - 1) != '^' && txt.charAt(txt.length() - 1) != '-') {
                    txt += "-";

                    view.getTxtResult().setText(txt);
                }
            }

        }

    }

    class PlusBtnListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            view.getLblRest().setText("");
            String txt = view.getTxtResult().getText();

            if (txt.isBlank()) {
                view.getTxtResult().setText("+");
            } else {
                if (txt.charAt(txt.length() - 1) != '+' && txt.charAt(txt.length() - 1) != '^' && txt.charAt(txt.length() - 1) != '-') {
                    txt += "+";

                    view.getTxtResult().setText(txt);
                }
            }

        }

    }

    class XBtnListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            view.getLblRest().setText("");
            String txt = view.getTxtResult().getText();

            if (txt.isBlank() || txt.equals("0")) {
                view.getTxtResult().setText("X");
            } else {
                if (txt.charAt(txt.length() - 1) != 'X' && txt.charAt(txt.length() - 1) != '^') {
                    txt += "X";

                    view.getTxtResult().setText(txt);
                }
            }

        }
    }

    class PowBtnListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            view.getLblRest().setText("");
            String txt = view.getTxtResult().getText();

            if (!txt.isBlank() && txt.charAt(txt.length() - 1) == 'X') {
                txt += "^";
                view.getTxtResult().setText(txt);
            }

        }
    }

    class AddBtnListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            view.getLblRest().setText("");
            Polynomial polynomial = view.readData();

            if (polynomial.getMonomials().size() != 0) {

                if (model.size() == 0) {
                    model.add(polynomial);
                    view.getTxtResult().setText("");
                    view.setOp('+');
                } else if (model.size() == 1) {
                    executeOperation(polynomial);
                    view.setOp('+');
                    view.getTxtResult().setText("");
                }
            }
        }
    }

    class SubtractBtnListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            view.getLblRest().setText("");
            Polynomial polynomial = view.readData();

            if (polynomial.getMonomials().size() != 0) {
                if (model.size() == 0) {
                    model.add(polynomial);
                    view.getTxtResult().setText("");
                    view.setOp('-');
                } else if (model.size() == 1) {
                    executeOperation(polynomial);
                    view.setOp('-');
                    view.getTxtResult().setText("");
                }
            }
        }
    }

    class MultiplyBtnListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            view.getLblRest().setText("");
            Polynomial polynomial = view.readData();

            if (polynomial.getMonomials().size() != 0) {
                if (model.size() == 0) {
                    model.add(polynomial);
                    view.getTxtResult().setText("");
                    view.setOp('*');
                } else if (model.size() == 1) {
                    executeOperation(polynomial);
                    view.setOp('*');
                    view.getTxtResult().setText("");
                }
            }
        }
    }

    class DivideBtnListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            view.getLblRest().setText("");
            Polynomial polynomial = view.readData();

            if (polynomial.getMonomials().size() != 0) {
                if (model.size() == 0) {
                    model.add(polynomial);
                    view.getTxtResult().setText("");
                    view.setOp('/');
                } else if (model.size() == 1) {
                    executeOperation(polynomial);
                    view.setOp('/');
                    view.getTxtResult().setText("");
                }
            }
        }
    }

    class DeriveBtnListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            view.getLblRest().setText("");
            Polynomial polynomial = view.readData();

            if (polynomial.getMonomials().size() != 0) {
                Polynomial result = polynomial.derive();
                if (model.size() > 0) {
                    model.remove(0);
                }
                model.add(result);
                view.setOp(' ');
                printResult(model.get(0));
            }
        }
    }

    class IntegrateBtnListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            view.getLblRest().setText("");
            Polynomial polynomial = view.readData();

            if (polynomial.getMonomials().size() != 0) {
                Polynomial result = polynomial.integrate();
                if (model.size() > 0) {
                    model.remove(0);
                }
                model.add(result);
                view.setOp(' ');
                printResult(result);
            }
        }
    }

    class ResultBtnListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            view.getLblRest().setText("");
            Polynomial polynomial = view.readData();

            if (polynomial.getMonomials().size() != 0) {

                if (model.size() == 1) {
                    view.getLblRest().setText("");
                    executeOperation(polynomial);
                    if (model.size() != 0) {
                        printResult(model.get(0));
                    }
                }
            } else if (model.size() > 0) {
                printResult(model.get(0));
            }
        }
    }

    private void executeOperation(Polynomial polynomial) {
        switch (view.getOp()) {
            case '+' -> {
                Polynomial result = model.get(0).add(polynomial);
                model.remove(0);
                model.add(result);
            }
            case '-' -> {
                Polynomial result = model.get(0).subtract(polynomial);
                model.remove(0);
                model.add(result);
            }
            case '*' -> {
                Polynomial result = model.get(0).multiply(polynomial);
                model.remove(0);
                model.add(result);
            }
            case '/' -> {
                ArrayList<Polynomial> result = model.get(0).divide(polynomial);
                if (result == null) {
                    JOptionPane.showMessageDialog(null, "Impartire invalida !");
                    model.remove(0);
                } else {
                    model.remove(0);
                    model.add(result.get(0));

                    StringBuilder txt = new StringBuilder();

                    for (Monomial m: result.get(1).getMonomials()) {
                        if (m.getCoefficient() < 0) {
                            txt.deleteCharAt(txt.length() - 1);
                        }
                        txt.append(m.toString());
                        txt.append("+");
                    }

                    txt.deleteCharAt(txt.length() - 1);

                    //System.out.println(txt.toString());

                    view.getLblRest().setText(txt.toString());

                }
            }
        }
    }

    public void printResult(Polynomial toPrint) {
        StringBuilder txt = new StringBuilder();

        for (Monomial m: toPrint.getMonomials()) {
            if (m.getCoefficient() < 0) {
                txt.deleteCharAt(txt.length() - 1);
            }
            txt.append(m.toString());
            txt.append("+");
        }

        txt.deleteCharAt(txt.length() - 1);
        view.getTxtResult().setText(txt.toString());
    }

    //Setters and Getters:

    public Calculator getView() {
        return view;
    }

    public void setView(Calculator view) {
        this.view = view;
    }

    public ArrayList<Polynomial> getModel() {
        return model;
    }

    public void setModel(ArrayList<Polynomial> model) {
        this.model = model;
    }
}
