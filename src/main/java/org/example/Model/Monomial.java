package org.example.Model;

public class Monomial {
    private double coef;
    private int degree;

    public Monomial(double coef, int degree) {
        this.coef = coef;
        this.degree = degree;
    }
    public Monomial(){

    }

    public double getCoef() {
        return coef;
    }

    public void setCoef(double coef) {
        this.coef = coef;
    }

    public int getDegree() {
        return degree;
    }

    public void setDegree(int degree) {
        this.degree = degree;
    }
}
