package org.example.Model;


import java.util.HashMap;
import java.util.Map;

public class Polynomial  {
    private Map<Integer,Monomial> monomials;

    public Polynomial(Map<Integer, Monomial> monomials) {
        this.monomials = monomials;
    }
    public Polynomial(){
    monomials = new HashMap<Integer,Monomial>();
    }

    public Map<Integer, Monomial> getMonomials() {
        return monomials;
    }

    public void setMonomials(Map<Integer, Monomial> monomials) {
        this.monomials = monomials;
    }

    public void addMonomial(Monomial monomial)
    {
        int deg = monomial.getDegree();
        if (this.monomials.containsKey(deg)){                    // if the polynomial already contains a monomial of that degree it adds the coefficient of the existent one with the new one
            Monomial auxMonomial = this.monomials.get(deg);
            auxMonomial.setCoef(auxMonomial.getCoef() + monomial.getCoef());            // ex: x^2 + 3x^2 in the same polynomial becomes => 4x^2
            this.monomials.put(deg,auxMonomial);
        }
        else{
            this.monomials.put(deg,monomial);
        }
    }
}
