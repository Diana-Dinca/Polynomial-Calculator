#### Different situations might occur in our daily lives, where we require quick answers to polynomial operations. A student might need to verify their math assignment, an engineer could be designing a mechanical system that involves polynomial modeling, or a researcher may need to involve polynomial expressions to gain a better understanding of their data.
#### This project relies on two main classes: Polynomial and Monomial. The Polynomial class represents a polynomial expression, consisting of one or more monomials. Each Monomial object contains a coefficient and an exponent. The Polynomial and Monomial classes work together to enable users to input, manipulate, and perform operations on polynomial expressions efficiently.
#### The application's implementation is organized into four distinct packages:
###### • *gui package* : this package houses the CalculatorGui class, which manages the graphical user interface for the application;
###### • *model package* : within this package, you'll find the Monomial and Polynomial classes, essential for representing and manipulating polynomial data;
###### • *operations package* : this package includes the OperationInterface, Operations and PolynomialConvertor classes, providing the necessary methods for executing polynomial operations and the conversion from a string to a polynomial using pattern matching;
###### • *testing package* : this package contains the OperationsTest and ParsingTest classes, designed to conduct JUnit tests to verify the calculator's functionality.
#### For an improved functionality, I used a TreeMap<Integer, Monomial> structure to store the monomials of the polynomial. These monomials, containing only a coefficient and a degree, are sorted in ascending order in the TreeMap, based on their exponents, facilitating printing from the greatest exponent to the smallest.
#### The challenge I encountered during the implementation of this project was correctly creating the mathematical operations. The polynomial calculator is capable of performing various mathematical operations on one or two polynomials, including addition, subtraction, division, multiplication, differentiation and integration. 
Some examples of how i implemented the most complex functions in my code:
###### The method below (integration method) accepts a single polynomial as input and computes its integral:
```java
 public Polynomial integration(Polynomial p1) {
        Polynomial pFinal = new Polynomial();

        for (Map.Entry<Integer, Monomial> entry : p1.getMonomials().entrySet()) {
            if(entry.getValue() != null) {
                Integer degree = entry.getValue().getDegree();
                degree= degree+1;
                Monomial newMonomial = new Monomial(degree, (
                        Double)entry.getValue().getCoefficient()/ degree.doubleValue());
                pFinal.getMonomials().put(degree,newMonomial);
            }
        }
        return pFinal;
    }
```

###### The method below (division method) is given two polynomials and returns their division:
```java
 public Polynomial[] division(Polynomial p1, Polynomial p2) {
        Polynomial divider = new Polynomial();
        Polynomial quotient = new Polynomial();
        Polynomial remainder = new Polynomial(); //the one that is divided
        Integer p1degree= p1.getMonomials().firstEntry().getKey();
        Integer p2degree= p2.getMonomials().firstEntry().getKey();

        if(p1degree>= p2degree) {  //swap so we divide the polynomial with bigger power
            for (Map.Entry<Integer, Monomial> entry : p1.getMonomials().entrySet())
                remainder.addMonomials(entry.getValue().copy());
            for (Map.Entry<Integer, Monomial> entry : p2.getMonomials().entrySet())
                divider.addMonomials(entry.getValue().copy());
        }
        else {
            for (Map.Entry<Integer, Monomial> entry : p2.getMonomials().entrySet())
                remainder.addMonomials(entry.getValue().copy());
            for (Map.Entry<Integer, Monomial> entry : p1.getMonomials().entrySet())
                divider.addMonomials(entry.getValue().copy());
        }

        while(remainder.getMonomials().firstEntry()!=null &&
                remainder.getMonomials().firstEntry().getValue().getDegree() >= divider.getMonomials().firstEntry().getValue().getDegree()) {

            Integer degree1 = remainder.getMonomials().firstEntry().getKey();
            Number coef1 = remainder.getMonomials().firstEntry().getValue().getCoefficient();
            Integer degree2 = divider.getMonomials().firstEntry().getKey();
            Number coef2 = divider.getMonomials().firstEntry().getValue().getCoefficient();

            Integer degreeFinal = degree1 - degree2;
            Number coefFinal = (Double) coef1 / (Double) coef2;

            Monomial m = new Monomial(degreeFinal, coefFinal);
            Polynomial p = new Polynomial();
            p.getMonomials().put(degreeFinal, m);
            quotient.getMonomials().put(degreeFinal, m);
            remainder = sub(remainder, multiplication(divider, p));

            if(remainder.getMonomials().firstEntry()!=null)
                if ((Double)remainder.getMonomials().firstEntry().getValue().getCoefficient()== 0.0) {
                    System.out.println(remainder.getMonomials().firstEntry().getValue().getCoefficient());
                    remainder.getMonomials().remove(remainder.getMonomials().firstEntry().getKey());
                }
        }
        return new Polynomial[]{quotient, remainder};

    }
```
#### Besides gaining proficiency in polynomial operations, working with the TreeMap structure helped me organize and manage data efficiently. Moreover, the project helped me understand better OOP concepts and application of design patterns, especially in the context of creating graphical user interfaces.
#### In the end, I have conducted two tests for each operation and two tests for parsing the polynomial. All my tests have passed successfully, indicating that the functionality is working as expected.
