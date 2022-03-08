import controller.CalculatorController;
import model.Monomial;
import model.Polynomial;
import view.Calculator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {

        ArrayList<Polynomial> model = new ArrayList<>();
        Calculator view = new Calculator(model);
        CalculatorController controller = new CalculatorController(view, model);

        //view.readData();
    }

    private static ArrayList<Polynomial> test() {

        ArrayList<Polynomial> polynomials = new ArrayList<>();

        Monomial m1 = new Monomial(2, 3);
        Monomial m2 = new Monomial(2, 2);
        Monomial m3 = new Monomial(2, 1);

        ArrayList<Monomial> monomials = new ArrayList<>();

        monomials.add(m1);
        monomials.add(m2);
        monomials.add(m3);

        /*Monomial m4 = new Monomial(5, 2, 'x');
        Monomial m5 = new Monomial(5, 1, 'x');
        Monomial m6 = new Monomial(5, 0, 'x');
*/
        ArrayList<Monomial> monomials2 = new ArrayList<>();
/*
        monomials2.add(m4);
        monomials2.add(m5);
        monomials2.add(m6);*/

        monomials2.add(new Monomial(0, 0));

        Polynomial polynomial = new Polynomial(monomials);
        Polynomial polynomial2 = new Polynomial(monomials2);

        polynomials.add(polynomial);
        polynomials.add(polynomial2);

        return polynomials;
    }

}
