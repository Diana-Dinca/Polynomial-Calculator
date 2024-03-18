package operations;

import model.Monomial;
import model.Polynomial;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PolynomialConvertor {

    public static Polynomial parsePolynomial(String polynomial) {
        Polynomial pol = new Polynomial();
        Monomial mon = new Monomial();

        Pattern pattern = Pattern.compile("(\\+|\\-)?(\\s*)(\\d*)(x)?(\\^)?(\\d*)?");
        Matcher matcher = pattern.matcher(polynomial);

        while (matcher.find()) {
            String sign = matcher.group(1);
            String coef = matcher.group(3);
            String x = matcher.group(4);
            String degree = matcher.group(6);
            Double c1;
            Integer p1;

            if(x != null) {
                if (coef == null || coef.isEmpty()) {
                    c1 = 1.0;
                } else {
                    c1 = Double.parseDouble(coef);
                }
            }
            else{
                if (coef == null || coef.isEmpty()) {
                    c1 = 0.0;
                }else {
                    c1 = Double.parseDouble(coef);
                }
            }

            if (sign != null && sign.equals("-")){
                c1 = -c1;
            }

            if(x != null) {
                if (degree == null || degree.isEmpty()) {
                    p1 = 1;
                } else {
                    p1 = Integer.parseInt(degree);
                }
            } else{
                p1 = 0;
            }

            if(c1 != 0) {
                if (pol.getMonomials().containsKey(p1)) {
                    Double value = (Double) pol.getMonomials().get(p1).getCoefficient();
                    pol.getMonomials().get(p1).setCoefficient(value + c1);
                } else {
                    Monomial newMonomial= new Monomial(p1, c1);
                    pol.getMonomials().put(p1, newMonomial);
                }
            }
        }
        return pol;
    }
}
