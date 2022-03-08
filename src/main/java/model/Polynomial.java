package model;

import java.util.ArrayList;

public class Polynomial {

    private ArrayList<Monomial> monomials;

    public Polynomial(ArrayList<Monomial> monomials) {
        this.monomials = monomials;
    }

    public Polynomial(Monomial monomial) {
        ArrayList<Monomial> list = new ArrayList<>();
        list.add(monomial);
        this.monomials = list;
    }

    public Polynomial add(Polynomial polynomial) {
        Polynomial newPolynomial = new Polynomial(new ArrayList<>());

        for (Monomial mFirst: this.monomials) {
            boolean exists = false;
            Monomial aux = new Monomial(0, 0);

            for (Monomial mSecond: polynomial.monomials) {
                if (mFirst.getDegree() == mSecond.getDegree()) {
                    exists = true;
                    aux = mSecond;
                    break;
                }
            }

            if (exists) {
                Monomial monomial = mFirst.add(aux);
                if (monomial.getCoefficient() != 0) {
                    newPolynomial.getMonomials().add(monomial);
                }
            } else {
                newPolynomial.getMonomials().add(mFirst);
            }
        }

        for (Monomial mFirst: polynomial.monomials) {
            boolean exists = false;

            for (Monomial mSecond: this.monomials) {
                if (mFirst.getDegree() == mSecond.getDegree()) {
                    exists = true;
                    break;
                }
            }

            if (!exists) {
                newPolynomial.getMonomials().add(mFirst);
            }
        }

        newPolynomial.getMonomials().sort((o1, o2) -> Integer.signum(o2.getDegree() - o1.getDegree()) );

        if (newPolynomial.getMonomials().size() == 0) {
            newPolynomial.getMonomials().add(new Monomial(0, 0));
        }
        return newPolynomial;
    }

    public Polynomial subtract(Polynomial polynomial) {
        Polynomial newPolynomial = new Polynomial(new ArrayList<>());

        for (Monomial mFirst: this.monomials) {
            boolean exists = false;
            Monomial aux = new Monomial(0, 0);

            for (Monomial mSecond: polynomial.monomials) {
                if (mFirst.getDegree() == mSecond.getDegree()) {
                    exists = true;
                    aux = mSecond;
                    break;
                }
            }

            if (exists) {
                Monomial monomial = mFirst.subtract(aux);
                if (monomial.getCoefficient() != 0) {
                    newPolynomial.getMonomials().add(monomial);
                }
            } else {
                newPolynomial.getMonomials().add(mFirst);
            }
        }

        for (Monomial mFirst: polynomial.monomials) {
            boolean exists = false;

            for (Monomial mSecond: this.monomials) {
                if (mFirst.getDegree() == mSecond.getDegree()) {
                    exists = true;
                    break;
                }
            }

            if (!exists) {
                mFirst.setCoefficient(-mFirst.getCoefficient());
                newPolynomial.getMonomials().add(mFirst);
            }
        }

        newPolynomial.getMonomials().sort((o1, o2) -> Integer.signum(o2.getDegree() - o1.getDegree()) );

        if (newPolynomial.getMonomials().size() == 0) {
            newPolynomial.getMonomials().add(new Monomial(0, 0));
        }

        return newPolynomial;
    }

    public Polynomial multiply(Polynomial polynomial) {
        Polynomial newPolynomial = new Polynomial(new ArrayList<>());

        for (Monomial mFirst: monomials) {
            for (Monomial mSecond: polynomial.monomials) {
                Monomial monomial = mFirst.multiply(mSecond);

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

        }

        newPolynomial.getMonomials().sort((o1, o2) -> Integer.signum(o2.getDegree() - o1.getDegree()) );

        if (newPolynomial.getMonomials().size() == 0) {
            newPolynomial.getMonomials().add(new Monomial(0, 0));
        }

        return newPolynomial;
    }

    public ArrayList<Polynomial> divide(Polynomial polynomial) {

        if (polynomial.getMonomials().size() == 0) {
            return null;
        }

        if (polynomial.getMonomials().get(0).getCoefficient() == 0) {
            return null;
        }

        this.getMonomials().sort((o1, o2) -> Integer.signum(o2.getDegree() - o1.getDegree()));
        polynomial.getMonomials().sort((o1, o2) -> Integer.signum(o2.getDegree() - o1.getDegree()));

        int degreeFirst = this.getMonomials().get(0).getDegree();
        int degreeSecond = polynomial.getMonomials().get(0).getDegree();

        if (degreeFirst < degreeSecond) {
            ArrayList<Polynomial> ans = new ArrayList<>();
            ans.add(new Polynomial(new Monomial(0, 0)));
            ans.add(this);
            return ans;
        }

        ArrayList<Monomial> result = new ArrayList<>();

        double coefficient = this.getMonomials().get(0).getCoefficient() / polynomial.getMonomials().get(0).getCoefficient();
        int degree = degreeFirst - degreeSecond;

        Monomial monomial = new Monomial(coefficient, degree);
        result.add(monomial);

        Polynomial rest = polynomial.multiply(new Polynomial(monomial));
        rest = this.subtract(rest);

        int degreeRest = rest.getMonomials().get(0).getDegree();

        while (!rest.getMonomials().get(0).equals(new Monomial(0,0)) && degreeRest >= degreeSecond) {

            coefficient = rest.getMonomials().get(0).getCoefficient() / polynomial.getMonomials().get(0).getCoefficient();
            degree = rest.getMonomials().get(0).getDegree() - polynomial.getMonomials().get(0).getDegree();

            monomial = new Monomial(coefficient, degree);
            result.add(monomial);

            Polynomial newP = polynomial.multiply(new Polynomial(monomial));
            rest = rest.subtract(newP);

            degreeRest = rest.getMonomials().get(0).getDegree();

        }

        ArrayList<Polynomial> listResult = new ArrayList<>();
        listResult.add(new Polynomial(result));
        listResult.add(rest);

        return listResult;
    }

    public Polynomial derive() {

        Polynomial result = new Polynomial(new ArrayList<>());

        for (Monomial m: this.monomials) {
            Monomial monomial = m.derive();

            if (monomial.getCoefficient() != 0) {
                result.getMonomials().add(monomial);
            }
        }

        result.getMonomials().sort((o1, o2) -> Integer.signum(o2.getDegree() - o1.getDegree()) );

        if (result.getMonomials().size() == 0) {
            result.getMonomials().add(new Monomial(0, 0));
        }

        return result;
    }

    public Polynomial integrate() {
        Polynomial result = new Polynomial(new ArrayList<>());

        for (Monomial m: this.monomials) {
            Monomial monomial = m.integrate();
            if (monomial.getCoefficient() != 0.0) {
                result.getMonomials().add(monomial);
            }
        }

        result.getMonomials().sort((o1, o2) -> Integer.signum(o2.getDegree() - o1.getDegree()) );

        if (result.getMonomials().size() == 0) {
            result.getMonomials().add(new Monomial(0, 0));
        }

        return result;
    }

    //Setters and Getters:

    public ArrayList<Monomial> getMonomials() {
        return monomials;
    }

    public void setMonomials(ArrayList<Monomial> monomials) {
        this.monomials = monomials;
    }

}
