package solutions;

/**
 * Created by calabash on 2017/4/7.
 *
 */
public class ComplexNumberMultiplication_537 {

    public String complexNumberMultiply(String a, String b) {
        int a1, a2, b1, b2;
        a1 = Integer.valueOf(a.substring(0, a.indexOf('+')));
        a2 = Integer.valueOf(a.substring(a.indexOf('+') + 1, a.length() - 1));
        b1 = Integer.valueOf(b.substring(0, b.indexOf('+')));
        b2 = Integer.valueOf(b.substring(b.indexOf('+') + 1, b.length() - 1));
        return String.valueOf(a1 * b1 - a2 * b2) + "+" +String.valueOf(a1 * b2 + a2 * b1) + "i";
    }
}
