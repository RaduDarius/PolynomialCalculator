package model;

public class Monomial {

    private double coefficient;
    private int degree;

    public Monomial(double coefficient, int degree) {
        this.coefficient = coefficient;
        this.degree = degree;
    }

    public Monomial add(Monomial monomial) {

        if (this.degree == monomial.degree) {
            return new Monomial(this.coefficient + monomial.coefficient, this.degree);
        }
        return null;
    }

    public Monomial subtract(Monomial monomial) {

        if (this.degree == monomial.degree) {
            return new Monomial(this.coefficient - monomial.coefficient, this.degree);
        }
        return null;
    }

    public Monomial multiply(Monomial monomial) {

        return new Monomial(this.coefficient * monomial.coefficient, this.degree + monomial.degree);

    }

    public Monomial derive() {
        if (this.degree > 0) {
            return new Monomial(this.coefficient * this.degree, this.degree - 1);
        }
        return new Monomial(0, 0);
    }

    public Monomial integrate() {

        return new Monomial(this.coefficient / (this.degree + 1), this.degree + 1);

    }

    //Setters and Getters:

    public double getCoefficient() {
        return coefficient;
    }

    public void setCoefficient(double coefficient) {
        this.coefficient = coefficient;
    }

    public int getDegree() {
        return degree;
    }

    public void setDegree(int degree) {
        this.degree = degree;
    }

    @Override
    public String toString() {
        if (coefficient == 1) {
            return "X^" + degree;
        }
        if (degree == 0) {
            return String.format("%.2f", coefficient);
        }
        if (degree == 1) {
            return String.format("%.2f", coefficient) + "X";
        }
        return String.format("%.2f", coefficient) + "X^" + degree;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Monomial monomial = (Monomial) o;
        return coefficient == monomial.coefficient && degree == monomial.degree;
    }

}
