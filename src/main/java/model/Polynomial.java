package model;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Polynomial {
    TreeMap<Integer, Monomial> monomials;
    public Polynomial(){
            this.monomials= new TreeMap<>(Collections.reverseOrder());
    }

    public TreeMap<Integer, Monomial> getMonomials() {
        return monomials;
    }

    public void setMonomials(TreeMap<Integer, Monomial> monomial) {
        this.monomials = monomial;
    }

    @Override
    public String toString() {
        StringBuilder polynomialString = new StringBuilder();
        for (Map.Entry<Integer, Monomial> entry : monomials.entrySet()) {
            Monomial monomial = entry.getValue();
            Integer degree = entry.getKey();
            Number coef = monomial.getCoefficient();

            if (coef.doubleValue() > 0) {
                if (!polynomialString.isEmpty())
                    polynomialString.append("+");
            }
            if(coef.doubleValue()== coef.intValue())
                polynomialString.append(coef.intValue());
            else
                polynomialString.append(String.format("%.2f",coef.doubleValue()));

            if(degree != 0)
                polynomialString.append("x^").append(degree);
        }
        return polynomialString.toString();
    }

    public void addMonomials(Monomial monomial2){ //this.monomial + monomial2
        if(monomial2 != null)
        {
            int degree= monomial2.getDegree();
            Monomial result= monomials.get(degree); //monomial with the degree we desire to add

            if(result!= null) //add the coefficients
            {
                Double coefficient= (Double) result.getCoefficient() + (Double) monomial2.getCoefficient();
                result.setCoefficient(coefficient);
            }
            else //add only the new monomial
                monomials.put(degree,monomial2);
        }
    }
    public void subMonomials(Monomial monomial2){ //this.monomial - monomial2
        if(monomial2 != null)
        {
            int degree= monomial2.getDegree();
            Monomial result= monomials.get(degree); //monomial with the degree we desire to sub

            if(result!= null) //sub the coefficients
            {
                Double coefficient= (Double) result.getCoefficient() - (Double) monomial2.getCoefficient();
                result.setCoefficient(coefficient);
                if((Double) result.getCoefficient() == 0.0){
                    monomials.remove(degree, result);
                }
            }
            else //sub only the new monomial
            {
                Double coef= (Double)monomial2.getCoefficient();
                monomial2.setCoefficient((-1) *coef );
                monomials.put(degree, monomial2);
            }
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(monomials);
    }
    @Override
    public boolean equals(Object obj) {
        if ( this == obj ) return true;
        if( obj == null || getClass()!= obj.getClass()) return false;
        Polynomial poly= (Polynomial) obj;
        return Objects.equals(monomials, poly.monomials);
    }
}
