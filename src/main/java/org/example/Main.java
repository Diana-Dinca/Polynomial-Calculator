package org.example;

import gui.CalculatorGUI;
import model.Monomial;
import model.Polynomial;
import operations.Operations;
import operations.OperationsInterface;

import javax.swing.*;
import static operations.PolynomialConvertor.parsePolynomial;
import static operations.PolynomialConvertor.parsePolynomial;

public class Main {
    public static void main(String[] args) {

        /*Monomial m1= new Monomial(1,1.0);
        Monomial m2= new Monomial(4, 2.6);
        Monomial m3= new Monomial(4,2.0);

        Polynomial p1= new Polynomial();
        p1.addMonomials(m1);
        p1.addMonomials(m2); //p1= x^1 + 2.6x^4
        Polynomial p2= new Polynomial();
        p2.addMonomials(m3); //p2= 2x^4

        OperationsInterface op= new Operations();

        Polynomial pSum= op.add(p1,p2);
        System.out.println("p1+p2: "+ pSum);

        Polynomial pDif= op.sub(p1,p2);
        System.out.println("p1-p2: "+ pDif);

        Polynomial pDeriv= op.differentiation(p1);
        System.out.println("p1`: "+ pDeriv); //pDeriv= 1*x^0 + 8*x^3

        Polynomial pSumDeriv= op.add(pDeriv,p1);
        System.out.println("p1+p1`: "+ pSumDeriv);

        Polynomial pIntegr= op.integration(p1);  //p1= x^1 + 2x^4
        System.out.println("integrala(p1): "+ pIntegr); //pIntegr= 1/2x^2 + 2/5x^5

        Polynomial pIntegr1= op.integration(pDeriv);
        System.out.println("integrala(p1'): "+ pIntegr1);

        Polynomial pMul= op.multiplication(p1,p2);
        System.out.println("MULTIPLICATION");
        System.out.println("p1*p2: "+ pMul); //pMul= 2*x^5 +4*x^8

        Monomial x3= new Monomial(3,1.0);
        Monomial x2= new Monomial(2,-2.0);
        Monomial x1= new Monomial(1,6.0);
        Monomial x0= new Monomial(0,-5.0);
        Polynomial pdiv1= new Polynomial();
        pdiv1.addMonomials(x3);
        pdiv1.addMonomials(x2);
        pdiv1.addMonomials(x1);
        pdiv1.addMonomials(x0);
        Monomial x11= new Monomial(2,1.0);
        Monomial x01= new Monomial(0,-1.0);
        Polynomial pdiv2= new Polynomial();
        pdiv2.addMonomials(x11);
        pdiv2.addMonomials(x01);
        Polynomial[] result= op.division(pdiv2,pdiv1);
        //x^3-2x^2+6x-5
        //x^2-1
        System.out.println("DIVISION");
        System.out.println(result[0] +" "+ result[1] );
        //System.out.println("p1*p2: "+ pMul);

        Polynomial newP= new Polynomial();
        newP= parsePolynomial("x^2+x^2+3");
        System.out.println(newP);*/

        JFrame frame = new CalculatorGUI();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // frame.pack();
        frame.setVisible(true);
    }
}