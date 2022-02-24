package nerds.utils.Math;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Math {
    
    public double round(double num, int place) {
        if (place < 0) throw new IllegalArgumentException();
        BigDecimal bd = new BigDecimal(num);
        bd = bd.setScale((int) place, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }

    public double distanceTo(double x, double y) {
        return x - y;
    }

    public double distanceTo(double x1, double x2, double y1, double y2) {
        return java.lang.Math.sqrt(squared(x2 - x1) + squared(y2 - y1));
    }

    public double exponent(double x, int power) {
        for (int i = 0; i < power; i++) {
            x *= power;
        }
        return x;
    }

    public double squared(double x) {
        return exponent(x, 2);
    }
}
