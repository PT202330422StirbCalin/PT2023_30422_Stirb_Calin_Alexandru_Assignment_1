package org.example;

import org.example.Logic.Operations;
import org.example.Model.Monomial;
import org.example.Model.Polynomial;
import org.example.View.View;
import java.util.HashMap;
import java.util.Map;


public class App 
{
    public static void main( String[] args )
    {
        View gui = new View();
        /*
        Operations op = new Operations();
        Polynomial p = new Polynomial();
        Polynomial q = new Polynomial();
            String[] test = op.splitToMonomials("-10x^2 +21x +12");
            String[] test2= op.splitToMonomials("15x^4 +6x^3 -2x^2 -11x +1");
        for(String it:test) {
            Monomial monomial = op.extractData(it);
            p.addMonomial(monomial);
            //System.out.printf(monomial.getCoef()+" "+ monomial.getDegree()+ "  ");
        }
        //.out.println("\n");
        for(String it:test2){
            Monomial monomial = op.extractData(it);
            q.addMonomial(monomial);
            //System.out.printf(monomial.getCoef()+" "+ monomial.getDegree()+ "  ");
        }
        //System.out.println("\n\n");
        Polynomial ad = op.add(p,q);
        HashMap<Integer,Monomial>table = (HashMap<Integer, Monomial>) ad.getMonomials();
        for(Map.Entry<Integer,Monomial> entry: table.entrySet()) {
            System.out.printf(entry.getValue().getCoef()+"x^"+ entry.getKey()+" + ");
        }

        System.out.println("\n");
        Polynomial sub = op.sub(p,q);
        HashMap<Integer,Monomial> table1 = (HashMap<Integer, Monomial>) sub.getMonomials();
        for(Map.Entry<Integer,Monomial> entry: table1.entrySet()) {
            System.out.printf(entry.getValue().getCoef()+"x^"+ entry.getKey()+" + ");
        }
         */
        }
    }

