package model;

import java.util.Objects;

public class Monomial {
    public Integer degree;
    public Number coefficient;

    public Monomial() {
    }

    public Monomial(Integer degree, Number coefficient) {
        this.degree = degree;
        this.coefficient = coefficient;
    }

    public Integer getDegree() {
        return degree;
    }

    public Number getCoefficient() {
        return coefficient;
    }

    public void setDegree(Integer degree) {
        this.degree = degree;
    }

    public void setCoefficient(Number coefficient) {
        this.coefficient = coefficient;
    }

    public Monomial copy() {
        return new Monomial(this.degree, this.coefficient);
    }

    @Override
    public String toString() {
        return coefficient +"*x^" +degree;
    }
    @Override
    public int hashCode() {
        return Objects.hash(coefficient, degree);
    }
    @Override
    public boolean equals(Object obj) {
        if ( this == obj ) return true;
        if( obj == null || getClass()!= obj.getClass()) return false;
        Monomial monom= (Monomial) obj;
        return Objects.equals(coefficient,monom.coefficient) && Objects.equals(degree,monom.degree);
    }

}
