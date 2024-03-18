package testing;

import model.Monomial;
import model.Polynomial;
import operations.Operations;
import operations.OperationsInterface;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class OperationsTest {

    @Test
    public void addTest(){
        OperationsInterface op= new Operations();

        Monomial m1= new Monomial(1,1.0);
        Monomial m2= new Monomial(4, 2.0);
        Monomial m3= new Monomial(4,2.0);

        Polynomial p1= new Polynomial();
        p1.addMonomials(m1);
        p1.addMonomials(m2); //p1= x^1 + 2x^4
        Polynomial p2= new Polynomial();
        p2.addMonomials(m3); //p2= 2x^4

        Monomial m1r= new Monomial(1,1.0);
        Monomial m2r= new Monomial(4, 2.0);
        Monomial m3r= new Monomial(4,2.0);

        Polynomial p3= new Polynomial();
        p3.addMonomials(m1r);
        p3.addMonomials(m2r);
        p3.addMonomials(m3r);

        assertEquals( op.add(p1,p2).toString(), p3.toString());
    }


    @Test
    public void addTest2(){
        OperationsInterface op= new Operations();

        Monomial m1= new Monomial(1,1.0);
        Monomial m2= new Monomial(4, -2.0);
        Monomial m3= new Monomial(4,-2.0);

        Polynomial p1= new Polynomial();
        p1.addMonomials(m1);
        p1.addMonomials(m2); //p1= x^1 - 2x^4
        Polynomial p2= new Polynomial();
        p2.addMonomials(m3); //p2= - 2x^4

        Monomial m1r= new Monomial(1,1.0);
        Monomial m2r= new Monomial(4, -2.0);
        Monomial m3r= new Monomial(4,-2.0);

        Polynomial p3= new Polynomial();
        p3.addMonomials(m1r);
        p3.addMonomials(m2r);
        p3.addMonomials(m3r);//p1 + p2= x^1 - 4x^4

        assertEquals( op.add(p1,p2).toString(), p3.toString());
    }


    @Test
    public void subTest(){
        OperationsInterface op= new Operations();

        Monomial m1= new Monomial(1,1.0);
        Monomial m2= new Monomial(4, 2.0);
        Monomial m3= new Monomial(4,2.0);

        Polynomial p1= new Polynomial();
        p1.addMonomials(m1);
        p1.addMonomials(m2); //p1= x^1 + 2x^4
        Polynomial p2= new Polynomial();
        p2.addMonomials(m3); //p2= 2x^4

        Monomial m1r= new Monomial(1,1.0);

        Polynomial p3= new Polynomial();
        p3.addMonomials(m1r);// p1 - p2= x^1

        assertEquals( op.sub(p1,p2).toString(), p3.toString());
    }


    @Test
    public void subTest2(){
        OperationsInterface op= new Operations();

        Monomial m1= new Monomial(1,1.0);
        Monomial m2= new Monomial(4, 2.0);
        Monomial m3= new Monomial(4,2.0);

        Polynomial p2= new Polynomial();
        p2.addMonomials(m1);
        p2.addMonomials(m2); //p2= x^1 + 2x^4
        Polynomial p1= new Polynomial();
        p1.addMonomials(m3); //p1= 2x^4

        Monomial m1r= new Monomial(1,-1.0);

        Polynomial p3= new Polynomial();
        p3.addMonomials(m1r); //p1 - p2= -x^1

        assertEquals( op.sub(p1,p2), p3);
    }

    @Test
    public void multiplicationTest(){
        OperationsInterface op= new Operations();

        Monomial m1= new Monomial(1,1.0);
        Monomial m2= new Monomial(4, 2.0);
        Monomial m3= new Monomial(4,2.0);

        Polynomial p1= new Polynomial();
        p1.addMonomials(m1);
        p1.addMonomials(m2); //p1= x^1 + 2x^4
        Polynomial p2= new Polynomial();
        p2.addMonomials(m3); //p2= 2x^4

        Monomial m1r= new Monomial(5,2.0);
        Monomial m2r= new Monomial(8,4.0);

        Polynomial p3= new Polynomial();
        p3.addMonomials(m1r); //p1 * p2= 2*x^5 +4*x^8
        p3.addMonomials(m2r);

        assertEquals( op.multiplication(p1,p2).toString(), p3.toString());
    }

    @Test
    public void multiplicationTest2(){
        OperationsInterface op= new Operations();

        Monomial m1 = new Monomial(3, 2.0);
        Monomial m2 = new Monomial(2, -3.0);
        Monomial m3 = new Monomial(1, 4.0);
        Monomial m4 = new Monomial(0, -5.0);

        Polynomial p1 = new Polynomial();
        p1.addMonomials(m1);
        p1.addMonomials(m2);
        p1.addMonomials(m3);
        p1.addMonomials(m4); // p1 = 2x^3 - 3x^2 + 4x - 5

        Monomial n1 = new Monomial(2, 1.0);
        Monomial n2 = new Monomial(1, 2.0);
        Monomial n3 = new Monomial(0, 3.0);

        Polynomial p2 = new Polynomial();
        p2.addMonomials(n1);
        p2.addMonomials(n2);
        p2.addMonomials(n3); // p2 = x^2 + 2x + 3

        Monomial r1 = new Monomial(5, 2.0);
        Monomial r2 = new Monomial(4, 1.0);
        Monomial r3 = new Monomial(3, 4.0);
        Monomial r4 = new Monomial(2, -6.0);
        Monomial r5 = new Monomial(1, 2.0);
        Monomial r6 = new Monomial(0, -15.0);

        Polynomial expected = new Polynomial();
        expected.addMonomials(r1);
        expected.addMonomials(r2);
        expected.addMonomials(r3);
        expected.addMonomials(r4);
        expected.addMonomials(r5);
        expected.addMonomials(r6); // p1 * p2 = 2x^5 + 4x^4 + x^3 + 2x^2 + 3x + 9

        assertEquals(op.multiplication(p1, p2).toString(), expected.toString());
    }


    @Test
    public void divisionTest(){
        OperationsInterface op= new Operations();

        Monomial x3= new Monomial(3,1.0);
        Monomial x2= new Monomial(2,-2.0);
        Monomial x1= new Monomial(1,6.0);
        Monomial x0= new Monomial(0,-5.0);

        Polynomial p1= new Polynomial();
        p1.addMonomials(x3);  //p1= x^3 -2x^2 +6x -5
        p1.addMonomials(x2);
        p1.addMonomials(x1);
        p1.addMonomials(x0);

        Monomial x11= new Monomial(2,1.0);
        Monomial x01= new Monomial(0,-1.0);

        Polynomial p2= new Polynomial();
        p2.addMonomials(x11);  //p2= x^2 -x
        p2.addMonomials(x01);

        Monomial x1r= new Monomial(1,1.0);
        Monomial x2r= new Monomial(0,-2.0);

        Polynomial p3q= new Polynomial();
        p3q.addMonomials(x1r);
        p3q.addMonomials(x2r); //p3 quotient = x – 2

        Monomial x1q= new Monomial(1,7.0);
        Monomial x2q= new Monomial(0,-7.0);

        Polynomial p3r= new Polynomial();
        p3r.addMonomials(x1q);
        p3r.addMonomials(x2q); //p3 remainder = 7*x-7

        Polynomial[] p3={p3q, p3r};
        Polynomial[] p4= op.division(p1,p2);

        assertTrue(p4[0].equals(p3[0]) && p4[1].equals(p3[1]));
    }

    @Test
    public void divisionTest2(){
        OperationsInterface op= new Operations();

        Monomial x2= new Monomial(2,5.0);
        Monomial x1= new Monomial(1,5.0);
        Monomial x0= new Monomial(0,-10.0);

        Polynomial p1= new Polynomial();
        p1.addMonomials(x2);
        p1.addMonomials(x1);
        p1.addMonomials(x0);//p1= 5x^2 +5x^1 -10

        Monomial x12= new Monomial(2,1.0);
        Monomial x11= new Monomial(1,1.0);
        Monomial x01= new Monomial(0,-2.0);

        Polynomial p2= new Polynomial();
        p2.addMonomials(x12); //p2= x^2 +x^1 -2
        p2.addMonomials(x11);
        p2.addMonomials(x01);

        Monomial x1r= new Monomial(0,5.0);

        Polynomial p3q= new Polynomial();
        p3q.addMonomials(x1r); //p3 quotient = 5

        Monomial x1q= new Monomial(0,0.0);

        Polynomial p3r= new Polynomial();//p3 remainder = 0
        Polynomial[] p3={p3q, p3r};
        Polynomial[] p4= op.division(p1,p2);

        assertTrue(p4[0].equals(p3[0]) && p4[1].equals(p3[1]));
    }

    @Test
    public void differentiationTest(){
        OperationsInterface op= new Operations();

        Monomial m1= new Monomial(1,1.0);
        Monomial m2= new Monomial(4, 2.0);
        Monomial m3= new Monomial(4,2.0);

        Polynomial p1= new Polynomial();
        p1.addMonomials(m1);
        p1.addMonomials(m2); //p1= x^1 + 2x^4

        Monomial m1r= new Monomial(0,1.0);
        Monomial m2r= new Monomial(3,8.0);

        Polynomial p2= new Polynomial();
        p2.addMonomials(m1r);
        p2.addMonomials(m2r); //p1'= 1*x^0 + 8*x^3

        assertEquals( op.differentiation(p1).toString(), p2.toString());
    }

    @Test
    public void differentiationTest2(){
        OperationsInterface op = new Operations();

        Monomial m1 = new Monomial(5, 3.0);
        Monomial m2 = new Monomial(3, -2.0);
        Monomial m3 = new Monomial(2, 6.0);
        Monomial m4 = new Monomial(1, -10.0);
        Monomial m5 = new Monomial(0, 7.0);

        Polynomial p1 = new Polynomial();
        p1.addMonomials(m1);
        p1.addMonomials(m2);
        p1.addMonomials(m3);
        p1.addMonomials(m4);
        p1.addMonomials(m5); // p1 = 3x^5 - 2x^3 + 6x^2 - 10x + 7

        Monomial m1r = new Monomial(4, 15.0);
        Monomial m2r = new Monomial(2, -6.0);
        Monomial m3r = new Monomial(1, 12.0);
        Monomial m4r = new Monomial(0, -10.0);

        Polynomial p2 = new Polynomial();
        p2.addMonomials(m1r);
        p2.addMonomials(m2r);
        p2.addMonomials(m3r);
        p2.addMonomials(m4r); // p2 = 15x^4 - 6x^2 + 12x - 10

        assertEquals(op.differentiation(p1).toString(), p2.toString());
    }

    @Test
    public void integrationTest(){
        OperationsInterface op= new Operations();

        Monomial m1= new Monomial(1,1.0);
        Monomial m2= new Monomial(4, 2.0);

        Polynomial p1= new Polynomial();
        p1.addMonomials(m1);
        p1.addMonomials(m2); //p1= x^1 + 2x^4

        Monomial m1r= new Monomial(2,0.5);
        Monomial m2r= new Monomial(5,0.4);

        Polynomial p2= new Polynomial();
        p2.addMonomials(m1r);
        p2.addMonomials(m2r); //p1'= 1/2x^2 + 2/5x^5

        assertEquals( op.integration(p1).toString(), p2.toString());
    }

    @Test
    public void integrationTest2(){
        OperationsInterface op= new Operations();

        Monomial m1 = new Monomial(3, 2.0);
        Monomial m2 = new Monomial(2, 3.0);
        Monomial m3 = new Monomial(1, -5.0);
        Monomial m4 = new Monomial(0, 6.0);

        Polynomial polynomial = new Polynomial();
        polynomial.addMonomials(m1);
        polynomial.addMonomials(m2);
        polynomial.addMonomials(m3);
        polynomial.addMonomials(m4); //2x^3 + 3x^2 - 5x + 6

        Monomial m1r = new Monomial(4, 0.5); // 1/2x^4
        Monomial m2r = new Monomial(3, 1.0); // x^3
        Monomial m3r = new Monomial(2, -2.5); // -5/2x^2
        Monomial m4r = new Monomial(1, 6.0); // 6x

        Polynomial expectedResult = new Polynomial();
        expectedResult.addMonomials(m1r);
        expectedResult.addMonomials(m2r);
        expectedResult.addMonomials(m3r);
        expectedResult.addMonomials(m4r);

        assertEquals(op.integration(polynomial).toString(), expectedResult.toString());
    }

}