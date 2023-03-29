package org.example;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.example.Logic.Operations;
import org.example.Model.Monomial;
import org.example.Model.Polynomial;

import java.util.HashMap;
import java.util.Map;

/**
 * Unit test for simple App.
 */
public class AppTest
        extends TestCase {
    protected Operations op = new Operations();
    protected String text1 = "x^2 + 2x";
    protected String text2 = "3x - 5";
    protected Polynomial p = new Polynomial();
    protected Polynomial q = new Polynomial();

    /**
     * Create the test case
     *
     * @param testName name of the test case
     */

    public void testAdd() {
        Monomial m1 = new Monomial(-5, 0), m2 = new Monomial(5, 1), m3 = new Monomial(1, 2);
        HashMap<Integer, Monomial> map = new HashMap<>();
        map.put(0, m1);
        map.put(1, m2);
        map.put(2, m3);
        Polynomial rez = new Polynomial(map);
        p = op.buildPolynomial(text1);
        q = op.buildPolynomial(text2);
        Polynomial add = op.add(p, q);
        double addCoef1 = add.getMonomials().get(0).getCoef();
        double addCoef2 = add.getMonomials().get(1).getCoef();
        double addCoef3 = add.getMonomials().get(2).getCoef();
        double rezCoef1 = rez.getMonomials().get(0).getCoef();
        double rezCoef2 = rez.getMonomials().get(1).getCoef();
        double rezCoef3 = rez.getMonomials().get(2).getCoef();
        assertEquals(addCoef1, rezCoef1);
        assertEquals(addCoef2, rezCoef2);
        assertEquals(addCoef3, rezCoef3);
    }
    public void testSub() {
        Monomial m1 = new Monomial(5, 0), m2 = new Monomial(-1, 1), m3 = new Monomial(1, 2);
        HashMap<Integer, Monomial> map = new HashMap<>();
        map.put(0, m1);
        map.put(1, m2);
        map.put(2, m3);
        Polynomial rez = new Polynomial(map);
        p = op.buildPolynomial(text1);
        q = op.buildPolynomial(text2);
        Polynomial add = op.sub(p, q);
        double addCoef1 = add.getMonomials().get(0).getCoef();
        double addCoef2 = add.getMonomials().get(1).getCoef();
        double addCoef3 = add.getMonomials().get(2).getCoef();
        double rezCoef1 = rez.getMonomials().get(0).getCoef();
        double rezCoef2 = rez.getMonomials().get(1).getCoef();
        double rezCoef3 = rez.getMonomials().get(2).getCoef();
        assertEquals(addCoef1, rezCoef1);
        assertEquals(addCoef2, rezCoef2);
        assertEquals(addCoef3, rezCoef3);
    }

    public void testMultiply(){
        Monomial m1 = new Monomial(-10, 1), m2 = new Monomial(1, 2), m3 = new Monomial(3, 3);
        HashMap<Integer, Monomial> map = new HashMap<>();
        map.put(0, m1);
        map.put(1, m2);
        map.put(2, m3);
        Polynomial rez = new Polynomial(map);
        p = op.buildPolynomial(text1);
        q = op.buildPolynomial(text2);
        Polynomial add = op.multiply(p, q);
        double addCoef1 = add.getMonomials().get(1).getCoef();
        double addCoef2 = add.getMonomials().get(2).getCoef();
        double addCoef3 = add.getMonomials().get(3).getCoef();
        double rezCoef1 = rez.getMonomials().get(0).getCoef();
        double rezCoef2 = rez.getMonomials().get(1).getCoef();
        double rezCoef3 = rez.getMonomials().get(2).getCoef();
        assertEquals(addCoef1, rezCoef1);
        assertEquals(addCoef2, rezCoef2);
        assertEquals(addCoef3, rezCoef3);
    }

    public AppTest(String testName) {
        super(testName);
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite(AppTest.class);
    }

    /**
     * Rigourous Test :-)
     */

}
