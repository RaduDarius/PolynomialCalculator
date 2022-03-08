package model;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class PolynomialTest {

    @Test
    void add1() {

        ArrayList<Monomial> monomials = new ArrayList<>();
        monomials.add(new Monomial(2, 5));
        monomials.add(new Monomial(-2, 3));
        monomials.add(new Monomial(5, 1));
        monomials.add(new Monomial(12, 0));
        Polynomial polynomial = new Polynomial(monomials);

        ArrayList<Monomial> monomials1 = new ArrayList<>();
        monomials1.add(new Monomial(2, 5));
        monomials1.add(new Monomial(-2, 4));
        monomials1.add(new Monomial(10, 1));
        monomials1.add(new Monomial(-12, 0));

        ArrayList<Monomial> result = new ArrayList<>();
        result.add(new Monomial(4, 5));
        result.add(new Monomial(-2, 4));
        result.add(new Monomial(-2, 3));
        result.add(new Monomial(15, 1));

        assertIterableEquals(result, polynomial.add(new Polynomial(monomials1)).getMonomials());

    }

    @Test
    void add2() {

        ArrayList<Monomial> monomials = new ArrayList<>();
        monomials.add(new Monomial(2, 5));
        monomials.add(new Monomial(-2, 3));
        monomials.add(new Monomial(5, 1));
        monomials.add(new Monomial(12, 0));
        Polynomial polynomial = new Polynomial(monomials);

        ArrayList<Monomial> monomials1 = new ArrayList<>();
        monomials1.add(new Monomial(-12, 0));

        ArrayList<Monomial> result = new ArrayList<>();
        result.add(new Monomial(2, 5));
        result.add(new Monomial(-2, 3));
        result.add(new Monomial(5, 1));

        assertIterableEquals(result, polynomial.add(new Polynomial(monomials1)).getMonomials());

    }

    @Test
    void add3() {

        ArrayList<Monomial> monomials = new ArrayList<>();
        monomials.add(new Monomial(2, 5));
        monomials.add(new Monomial(-2, 3));
        monomials.add(new Monomial(5, 1));
        monomials.add(new Monomial(12, 0));
        Polynomial polynomial = new Polynomial(monomials);

        ArrayList<Monomial> monomials1 = new ArrayList<>();
        monomials1.add(new Monomial(0, 0));

        ArrayList<Monomial> result = new ArrayList<>();
        result.add(new Monomial(2, 5));
        result.add(new Monomial(-2, 3));
        result.add(new Monomial(5, 1));
        result.add(new Monomial(12, 0));


        assertIterableEquals(result, polynomial.add(new Polynomial(monomials1)).getMonomials());

    }

    @Test
    void subtract1() {
        ArrayList<Monomial> monomials = new ArrayList<>();
        monomials.add(new Monomial(2, 5));
        monomials.add(new Monomial(-2, 3));
        monomials.add(new Monomial(5, 1));
        monomials.add(new Monomial(12, 0));
        Polynomial polynomial = new Polynomial(monomials);

        ArrayList<Monomial> monomials1 = new ArrayList<>();
        monomials1.add(new Monomial(2, 5));
        monomials1.add(new Monomial(-2, 4));
        monomials1.add(new Monomial(10, 1));
        monomials1.add(new Monomial(-12, 0));

        ArrayList<Monomial> result = new ArrayList<>();
        result.add(new Monomial(2, 4));
        result.add(new Monomial(-2, 3));
        result.add(new Monomial(-5, 1));
        result.add(new Monomial(24, 0));

        assertIterableEquals(result, polynomial.subtract(new Polynomial(monomials1)).getMonomials());
    }


    @Test
    void subtract2() {
        ArrayList<Monomial> monomials = new ArrayList<>();
        monomials.add(new Monomial(2, 5));
        monomials.add(new Monomial(-2, 3));
        monomials.add(new Monomial(5, 1));
        monomials.add(new Monomial(12, 0));
        Polynomial polynomial = new Polynomial(monomials);

        ArrayList<Monomial> monomials1 = new ArrayList<>();

        ArrayList<Monomial> result = new ArrayList<>();
        result.add(new Monomial(2, 5));
        result.add(new Monomial(-2, 3));
        result.add(new Monomial(5, 1));
        result.add(new Monomial(12, 0));

        assertIterableEquals(result, polynomial.subtract(new Polynomial(monomials1)).getMonomials());
    }


    @Test
    void subtract3() {
        ArrayList<Monomial> monomials = new ArrayList<>();
        Polynomial polynomial = new Polynomial(monomials);

        ArrayList<Monomial> monomials1 = new ArrayList<>();
        monomials1.add(new Monomial(2, 5));
        monomials1.add(new Monomial(-2, 4));
        monomials1.add(new Monomial(10, 1));
        monomials1.add(new Monomial(-12, 0));

        ArrayList<Monomial> result = new ArrayList<>();
        result.add(new Monomial(-2, 5));
        result.add(new Monomial(2, 4));
        result.add(new Monomial(-10, 1));
        result.add(new Monomial(12, 0));

        assertIterableEquals(result, polynomial.subtract(new Polynomial(monomials1)).getMonomials());
    }

    @Test
    void multiply1() {
        ArrayList<Monomial> monomials = new ArrayList<>();
        monomials.add(new Monomial(2, 5));
        monomials.add(new Monomial(-2, 3));
        monomials.add(new Monomial(5, 1));
        monomials.add(new Monomial(12, 0));
        Polynomial polynomial = new Polynomial(monomials);

        ArrayList<Monomial> monomials1 = new ArrayList<>();
        monomials1.add(new Monomial(2, 5));
        monomials1.add(new Monomial(-2, 4));
        monomials1.add(new Monomial(10, 1));
        monomials1.add(new Monomial(-12, 0));

        ArrayList<Monomial> result = new ArrayList<>();
        result.add(new Monomial(4, 10));
        result.add(new Monomial(-4, 9));
        result.add(new Monomial(-4, 8));
        result.add(new Monomial(4, 7));
        result.add(new Monomial(30, 6));
        result.add(new Monomial(-10, 5));
        result.add(new Monomial(-44, 4));
        result.add(new Monomial(24, 3));
        result.add(new Monomial(50, 2));
        result.add(new Monomial(60, 1));
        result.add(new Monomial(-144, 0));

        assertIterableEquals(result, polynomial.multiply(new Polynomial(monomials1)).getMonomials());
    }

    @Test
    void multiply2() {
        ArrayList<Monomial> monomials = new ArrayList<>();
        monomials.add(new Monomial(2, 5));
        monomials.add(new Monomial(-2, 3));
        monomials.add(new Monomial(5, 1));
        monomials.add(new Monomial(12, 0));
        Polynomial polynomial = new Polynomial(monomials);

        ArrayList<Monomial> monomials1 = new ArrayList<>();
        monomials1.add(new Monomial(0, 0));

        ArrayList<Monomial> result = new ArrayList<>();
        result.add(new Monomial(0, 0));

        assertIterableEquals(result, polynomial.multiply(new Polynomial(monomials1)).getMonomials());
    }

    @Test
    void divide() {

        ArrayList<Monomial> monomials = new ArrayList<>();
        monomials.add(new Monomial(2, 5));
        monomials.add(new Monomial(-2, 3));
        monomials.add(new Monomial(5, 1));
        monomials.add(new Monomial(12, 0));
        Polynomial polynomial = new Polynomial(monomials);

        assertNull(polynomial.divide(new Polynomial(new Monomial(0,0))));
        assertNull(polynomial.divide(new Polynomial(new ArrayList<>())));

        ArrayList<Monomial> monomials2 = new ArrayList<>();
        monomials2.add(new Monomial(1, 2));
        monomials2.add(new Monomial(1, 1));

        ArrayList<Polynomial> pResult = new ArrayList<>();
        ArrayList<Monomial> l = new ArrayList<>();
        l.add(new Monomial(2, 3));
        l.add(new Monomial(-2, 2));

        pResult.add(new Polynomial(l));

        l = new ArrayList<>();
        l.add(new Monomial(5, 1));
        l.add(new Monomial(12, 0));
        pResult.add(new Polynomial(l));

        assertIterableEquals(pResult.get(0).getMonomials(), polynomial.divide(new Polynomial(monomials2)).get(0).getMonomials());
        assertIterableEquals(pResult.get(1).getMonomials(), polynomial.divide(new Polynomial(monomials2)).get(1).getMonomials());

        assertIterableEquals(new Polynomial(new Monomial(0,0)).getMonomials(), polynomial.divide(new Polynomial(new Monomial(1, 6))).get(0).getMonomials());
        assertIterableEquals(polynomial.getMonomials(), polynomial.divide(new Polynomial(new Monomial(1, 6))).get(1).getMonomials());

    }

    @Test
    void derive1() {

        ArrayList<Monomial> monomials = new ArrayList<>();
        monomials.add(new Monomial(2, 5));
        monomials.add(new Monomial(-2, 3));
        monomials.add(new Monomial(5, 1));
        monomials.add(new Monomial(12, 0));
        Polynomial polynomial = new Polynomial(monomials);

        ArrayList<Monomial> result = new ArrayList<>();
        result.add(new Monomial(10, 4));
        result.add(new Monomial(-6, 2));
        result.add(new Monomial(5, 0));

        assertIterableEquals(result, polynomial.derive().getMonomials());

    }

    @Test
    void derive2() {

        ArrayList<Monomial> monomials = new ArrayList<>();
        monomials.add(new Monomial(12, 0));
        monomials.add(new Monomial(24, 0));
        Polynomial polynomial = new Polynomial(monomials);

        ArrayList<Monomial> result = new ArrayList<>();
        result.add(new Monomial(0, 0));

        assertIterableEquals(result, polynomial.derive().getMonomials());

    }

    @Test
    void integrate1() {

        ArrayList<Monomial> monomials = new ArrayList<>();
        monomials.add(new Monomial(2, 5));
        monomials.add(new Monomial(-2, 3));
        monomials.add(new Monomial(5, 1));
        monomials.add(new Monomial(12, 0));
        Polynomial polynomial = new Polynomial(monomials);

        ArrayList<Monomial> result = new ArrayList<>();
        result.add(new Monomial(2/6.0, 6));
        result.add(new Monomial(-2/4.0, 4));
        result.add(new Monomial(5/2.0, 2));
        result.add(new Monomial(12, 1));

        assertIterableEquals(result, polynomial.integrate().getMonomials());

    }
}