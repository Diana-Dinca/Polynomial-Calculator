package operations;

import model.Monomial;
import model.Polynomial;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PolynomialConvertor {

    public static Polynomial parsePolynomial(String polynomial) {
        Polynomial pol = new Polynomial();

        Pattern pattern = Pattern.compile("(\\+|\\-)?(\\s*)(\\d*)(x)?(\\^)?(\\d*)");
        Matcher matcher = pattern.matcher(polynomial);

        while (matcher.find()) {
            String sign = matcher.group(1);
            String coef = matcher.group(3);
            String x = matcher.group(4);
            String degree = matcher.group(6);
            Double c1;
            Integer p1;

            if(x != null) {
                c1= (coef == null || coef.isEmpty()) ? 1.0 : Double.parseDouble(coef);
                p1= (degree == null || degree.isEmpty()) ? 1 : Integer.parseInt(degree);
            }
            else{
                c1= (coef == null || coef.isEmpty()) ? 0.0 : Double.parseDouble(coef);
                p1 = 0;
            }

            if (sign != null && sign.equals("-")){
                c1 = -c1;
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
