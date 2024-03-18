package operations;

import model.Polynomial;

import java.util.HashMap;

public interface OperationsInterface {
    Polynomial add(Polynomial p1, Polynomial p2);
    Polynomial sub(Polynomial p1, Polynomial p2);
    Polynomial multiplication(Polynomial p1, Polynomial p2);
    Polynomial[] division(Polynomial p1, Polynomial p2);
    Polynomial differentiation(Polynomial p1);
    Polynomial integration(Polynomial p1);
}
