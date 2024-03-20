package operations;

import model.Monomial;
import model.Polynomial;

import java.util.Map;

public class Operations implements OperationsInterface{
    @Override
    public Polynomial add(Polynomial p1, Polynomial p2) {
        Polynomial pFinal = new Polynomial();

        for (Map.Entry<Integer, Monomial> entry : p1.getMonomials().entrySet())
            pFinal.addMonomials(entry.getValue().copy());
        for (Map.Entry<Integer, Monomial> entry : p2.getMonomials().entrySet())
            pFinal.addMonomials(entry.getValue().copy());

        return pFinal;
    }
    @Override
    public Polynomial sub(Polynomial p1, Polynomial p2) {
        Polynomial pFinal = new Polynomial();

        for (Map.Entry<Integer, Monomial> entry : p1.getMonomials().entrySet())
            pFinal.addMonomials(entry.getValue().copy());
        for (Map.Entry<Integer, Monomial> entry : p2.getMonomials().entrySet())
            pFinal.subMonomials(entry.getValue());

        return pFinal;
    }
    @Override
    public Polynomial multiplication(Polynomial p1, Polynomial p2) {
        Polynomial pFinal = new Polynomial();

        for (Map.Entry<Integer, Monomial> entry2 : p2.getMonomials().entrySet())
            if(entry2.getValue() != null) {
                for (Map.Entry<Integer, Monomial> entry1 : p1.getMonomials().entrySet())
                    if(entry1.getValue() != null)
                    {
                        Integer degree1 = entry1.getValue().getDegree();
                        Number coef1 = entry1.getValue().getCoefficient();
                        Integer degree2 = entry2.getValue().getDegree();
                        Number coef2 = entry2.getValue().getCoefficient();

                        Integer degreeFinal = degree1 + degree2;
                        Number coefFinal = (Double) coef1 * (Double) coef2;

                        if(pFinal.getMonomials().containsKey(degreeFinal)) //if the monom already exists, we add the coefficients
                        {
                            pFinal.getMonomials().get(degreeFinal).setCoefficient (
                                    (Double)pFinal.getMonomials().get(degreeFinal).getCoefficient() + (Double)coefFinal);
                        } else //we add the new monom into the map
                        {
                            Monomial newMonomial = new Monomial(degreeFinal, coefFinal);
                            pFinal.getMonomials().put(degreeFinal,newMonomial);
                        }
                    }
            }
        return pFinal;
    }

    @Override
    public Polynomial[] division(Polynomial p1, Polynomial p2) {
        Polynomial divider = new Polynomial();
        Polynomial quotient = new Polynomial();
        Polynomial remainder = new Polynomial(); //the one that is divided
        Integer p1degree= p1.getMonomials().firstEntry().getKey();
        Integer p2degree= p2.getMonomials().firstEntry().getKey();

        if(p1degree>= p2degree) {  //swap so we divide the p with bigger power
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

    @Override
    public Polynomial differentiation(Polynomial p1) {
        Polynomial pFinal = new Polynomial();

        for (Map.Entry<Integer, Monomial> entry : p1.getMonomials().entrySet()) {
            if(entry.getValue() != null) {
               Integer degree = entry.getValue().getDegree() -1;
               Double value = (Double)entry.getValue().getCoefficient() * entry.getValue().getDegree();

                if(degree+1!= 0){
                    Monomial newMonomial = new Monomial(degree, value);
                    pFinal.getMonomials().put(degree,newMonomial);
                }
            }
        }
        return pFinal;
    }

    @Override
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
}
