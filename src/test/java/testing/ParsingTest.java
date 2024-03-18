package testing;

import model.Monomial;
import model.Polynomial;
import org.junit.jupiter.api.Test;

import static operations.PolynomialConvertor.parsePolynomial;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ParsingTest {

    @Test
    public void parseTest(){
        Polynomial p1= new Polynomial();
        p1= parsePolynomial("x^4+2x^2+3");

        Monomial m1= new Monomial(4,1.0);
        Monomial m2= new Monomial(2, 2.0);
        Monomial m3= new Monomial(0,3.0);

        Polynomial p2= new Polynomial();
        p2.addMonomials(m1);
        p2.addMonomials(m2);
        p2.addMonomials(m3);

        assertEquals(p1.toString(), p2.toString());
    }

    @Test
    public void parseTest2(){
        Polynomial p1 = parsePolynomial("4x^8 - 3x^5 + 2x^4 - 7x^3 + 5x^2 - 2x + 1");

        Monomial m1 = new Monomial(8, 4.0);
        Monomial m2 = new Monomial(5, -3.0);
        Monomial m3 = new Monomial(4, 2.0);
        Monomial m4 = new Monomial(3, -7.0);
        Monomial m5 = new Monomial(2, 5.0);
        Monomial m6 = new Monomial(1, -2.0);
        Monomial m7 = new Monomial(0, 1.0);

        Polynomial p2 = new Polynomial();
        p2.addMonomials(m1);
        p2.addMonomials(m2);
        p2.addMonomials(m3);
        p2.addMonomials(m4);
        p2.addMonomials(m5);
        p2.addMonomials(m6);
        p2.addMonomials(m7);

        assertEquals(p1.toString(), p2.toString());
    }

}
