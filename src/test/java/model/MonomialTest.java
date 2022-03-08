package model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MonomialTest {

    @Test
    void add() {

        Monomial monomial = new Monomial(3, 4);
        Monomial monomial2 = new Monomial(-3, 4);
        assertNull(monomial.add(new Monomial(4, 3)));
        assertEquals(new Monomial(5, 4), monomial.add(new Monomial(2, 4)));
        assertEquals(new Monomial(0, 4), monomial.add(new Monomial(-3, 4)));
        assertEquals(new Monomial(-6, 4), monomial2.add(new Monomial(-3, 4)));
    }

    @Test
    void subtract() {

        Monomial monomial = new Monomial(3, 4);
        Monomial monomial2 = new Monomial(-3, 4);
        assertNull(monomial.subtract(new Monomial(4, 3)));
        assertEquals(new Monomial(1, 4), monomial.subtract(new Monomial(2, 4)));
        assertEquals(new Monomial(6, 4), monomial.subtract(new Monomial(-3, 4)));
        assertEquals(new Monomial(0, 4), monomial2.subtract(new Monomial(-3, 4)));
    }

    @Test
    void multiply() {

        Monomial monomial = new Monomial(3, 4);
        assertEquals(new Monomial(6, 6), monomial.multiply(new Monomial(2, 2)));
        assertEquals(new Monomial(-6, 6), monomial.multiply(new Monomial(-2, 2)));
        assertEquals(new Monomial(6, 4), monomial.multiply(new Monomial(2, 0)));
        assertEquals(new Monomial(-6, 4), monomial.multiply(new Monomial(-2, 0)));
        assertEquals(new Monomial(0, 4), monomial.multiply(new Monomial(0, 0)));

        Monomial monomial2 = new Monomial(2, 0);
        assertEquals(new Monomial(0, 0), monomial2.multiply(new Monomial(0, 0)));
        assertEquals(new Monomial(-4, 0), monomial2.multiply(new Monomial(-2, 0)));

    }

    @Test
    void derive() {

        Monomial monomial = new Monomial(3, 4);
        assertEquals(new Monomial(12, 3), monomial.derive());

        Monomial monomial1 = new Monomial(3, 0);
        assertEquals(new Monomial(0,0), monomial1.derive());

        Monomial monomial2 = new Monomial(0, 0);
        assertEquals(new Monomial(0,0), monomial2.derive());
    }

    @Test
    void integrate() {

        Monomial monomial = new Monomial(3, 4);
        assertEquals(new Monomial(0.6, 5), monomial.integrate());

        Monomial monomial1 = new Monomial(3, 0);
        assertEquals(new Monomial(3, 1), monomial1.integrate());

        Monomial monomial2 = new Monomial(0, 0);
        assertEquals(new Monomial(0, 1), monomial2.integrate());

    }
}