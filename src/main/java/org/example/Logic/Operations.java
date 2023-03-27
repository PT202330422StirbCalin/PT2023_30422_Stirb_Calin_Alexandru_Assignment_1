package org.example.Logic;

import org.example.Model.Monomial;
import org.example.Model.Polynomial;

import java.util.HashMap;
import java.util.Map;

public class Operations {

    public String[] splitToMonomials(String inString) {
        String aux = inString.replaceAll("\\s+", "");
        String[] outString = aux.split("((?=[+-]))");
        return outString;
    }

    public static String splitToCoef(String inString) {
        String[] outString = inString.split("[xX]");
        return outString[0];
    }

    public static String splitToDegree(String inString) {
        String[] outString = inString.split("[xX]");
        return outString[1];
    }

    public Monomial extractData(String inString) {
        Monomial monomial = new Monomial();
        String degree;
        String coef;
        if (inString.matches("[+-]\\d.*"))
            coef = splitToCoef(inString);
        else if (inString.matches("\\d.*"))
            coef = splitToCoef(inString);
        else if (inString.matches("-.*"))
            coef = "-1";
        else
            coef = "1";

        if (inString.matches(".*[\"^\"].*")) {
            degree = splitToDegree(inString);
            degree = degree.replaceAll("[\"^\"\\s+]", "");
        } else if (inString.matches(".*[Xx].*"))
            degree = "1";
        else
            degree = "0";
        double coefficient = Double.parseDouble(coef);
        int deg = Integer.parseInt(degree);
        monomial.setCoef(coefficient);
        monomial.setDegree(deg);
        return monomial;
    }

    public Polynomial add(Polynomial p, Polynomial q) {
        HashMap<Integer, Monomial> mapP = new HashMap<>();
        mapP.putAll(p.getMonomials());
        HashMap<Integer, Monomial> mapQ = (HashMap<Integer, Monomial>) q.getMonomials();
        Polynomial rez = new Polynomial(mapP);
        for (Map.Entry<Integer, Monomial> entry : mapQ.entrySet()) {
            Monomial aux = entry.getValue();
            rez.addMonomial(aux);
        }
        return rez;
    }

    public Polynomial sub(Polynomial p, Polynomial q) {
        HashMap<Integer, Monomial> mapP = new HashMap<>();
        mapP.putAll(p.getMonomials());
        HashMap<Integer, Monomial> mapQ = (HashMap<Integer, Monomial>) q.getMonomials();
        Polynomial rez = new Polynomial(mapP);
        for (Map.Entry<Integer, Monomial> entry : mapQ.entrySet()) {
            Monomial aux = entry.getValue();
            double auxVal = -1 * aux.getCoef();
            aux.setCoef(auxVal);
            rez.addMonomial(aux);
        }
        return rez;
    }

    public Polynomial multiply(Polynomial p, Polynomial q) {
        Polynomial rez = new Polynomial();
        HashMap<Integer, Monomial> tableP = (HashMap<Integer, Monomial>) p.getMonomials();
        HashMap<Integer, Monomial> tableQ = (HashMap<Integer, Monomial>) q.getMonomials();
        for (Map.Entry<Integer, Monomial> entry : tableP.entrySet()) {
            for (Map.Entry<Integer, Monomial> ent : tableQ.entrySet()) {
                int degree = entry.getKey() + ent.getKey();
                Monomial auxP = entry.getValue();
                Monomial auxQ = ent.getValue();
                double coef = auxP.getCoef() * auxQ.getCoef();
                Monomial mult = new Monomial();
                mult.setCoef(coef);
                mult.setDegree(degree);
                rez.addMonomial(mult);
            }
        }
        return rez;
    }

    public Polynomial derivative(Polynomial p) {
        Polynomial rez = new Polynomial();
        HashMap<Integer, Monomial> tableP = (HashMap<Integer, Monomial>) p.getMonomials();
        tableP.put(0, null);
        for (Map.Entry<Integer, Monomial> entry : tableP.entrySet()) {
            if (entry.getKey() > 0) {
                int degree = entry.getKey() - 1;
                Monomial aux = entry.getValue();
                double coef = aux.getCoef() * entry.getKey();
                Monomial deriv = new Monomial();
                deriv.setCoef(coef);
                deriv.setDegree(degree);
                rez.addMonomial(deriv);
            }
        }
        return rez;
    }

    public Polynomial integrate(Polynomial p) {
        Polynomial rez = new Polynomial();
        HashMap<Integer, Monomial> tableP = (HashMap<Integer, Monomial>) p.getMonomials();
        for (Map.Entry<Integer, Monomial> entry : tableP.entrySet()) {
            int degree = entry.getKey() + 1;
            Monomial aux = entry.getValue();
            double coef = aux.getCoef() / degree;
            Monomial deriv = new Monomial();
            deriv.setCoef(coef);
            deriv.setDegree(degree);
            rez.addMonomial(deriv);
        }
        return rez;
    }

    public String polynomialToString(Polynomial p) {
        String rez = new String();
        HashMap<Integer, Monomial> table = (HashMap<Integer, Monomial>) p.getMonomials();
        for (Map.Entry<Integer, Monomial> entry : table.entrySet()) {
            String coef = Double.toString(entry.getValue().getCoef());
            String degree = Double.toString(entry.getKey());
            if (entry.getKey() > 1) {
                if (entry.getValue().getCoef() > 0)
                    rez = rez + " + " + coef + "x^" + degree + " ";
                else rez = rez + " " + coef + "x^" + degree + " ";
            } else if (entry.getKey() == 0) {
                if (entry.getValue().getCoef() > 0)
                    rez = rez + " " + coef;
                else rez = rez + " " + coef;
            } else {
                if (entry.getValue().getCoef() > 0)
                    rez = rez + " + " + coef + "x";
                else rez = rez + " " + coef + "x";
            }
        }
        return rez;
    }

}