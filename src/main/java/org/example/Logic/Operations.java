package org.example.Logic;

import org.example.Model.Monomial;
import org.example.Model.Polynomial;

import java.util.HashMap;
import java.util.Map;

public class Operations {

    public String[] splitToMonomials(String inString)
    {
        String aux = inString.replaceAll("\\s+", "");
        String[] outString = aux.split("((?=[+-]))");
        return outString;
    }

    public static String splitToCoef(String inString)
    {
        String[] outString = inString.split("[xX]");
        return outString[0];
    }

    public static String splitToDegree(String inString)
    {
            String[] outString = inString.split("[xX]");
        return outString[1];
    }
    public Monomial extractData(String inString)
    {
        Monomial monomial = new Monomial();
        String degree;
        String coef;
        if(inString.matches("[+-]\\d.*"))
         coef = splitToCoef(inString);
        else if(inString.matches("\\d.*"))
            coef = splitToCoef(inString);
        else if(inString.matches("-.*"))
            coef = "-1";
        else
            coef ="1";

        if (inString.matches(".*[\"^\"].*")) {
            degree = splitToDegree(inString);
            degree = degree.replaceAll("[\"^\"\\s+]","");
        }
        else if (inString.matches(".*[Xx].*"))
            degree = "1";
        else
            degree = "0";
        double coefficient = Double.parseDouble(coef);
        int deg = Integer.parseInt(degree);
        monomial.setCoef(coefficient);
        monomial.setDegree(deg);
        return monomial;
    }
    public Polynomial add(Polynomial p, Polynomial q)
    {

        HashMap<Integer,Monomial> mapP = new HashMap<>();
        mapP.putAll(p.getMonomials());
        HashMap<Integer,Monomial> mapQ = (HashMap<Integer, Monomial>) q.getMonomials();
        Polynomial rez = new Polynomial(mapP);
        for(Map.Entry<Integer,Monomial> entry: mapQ.entrySet()) {
            Monomial aux = entry.getValue();
            int deg = entry.getKey();
            rez.addMonomial(aux);
        }
        return rez;
    }

    public Polynomial sub(Polynomial p, Polynomial q)
    {
        HashMap<Integer,Monomial> mapP = new HashMap<>();
        mapP.putAll(p.getMonomials());
        HashMap<Integer,Monomial> mapQ = (HashMap<Integer, Monomial>) q.getMonomials();
        Polynomial rez = new Polynomial(mapP);
        for(Map.Entry<Integer,Monomial> entry: mapQ.entrySet()) {
            Monomial aux = entry.getValue();
            int deg = entry.getKey();
            double auxVal = -1*aux.getCoef();
            aux.setCoef(auxVal);
            rez.addMonomial(aux);
        }
        return rez;
    }

    public Polynomial multiply(Polynomial p, Polynomial q)
    {
        Polynomial rez = p;
        return rez;
    }

}
