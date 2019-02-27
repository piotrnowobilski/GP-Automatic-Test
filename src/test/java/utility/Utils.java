package utility;

import java.math.BigDecimal;
import java.text.DecimalFormat;

public class Utils {

    static public double parse(String ratio) {
        if (ratio.contains("/")) {
            String[] rat = ratio.split("/");
            return Double.parseDouble(rat[0]) / Double.parseDouble(rat[1]);
        } else {
            return Double.parseDouble(ratio);
        }
    }

    public static float round(float d, int decimalPlace)
    {
        return BigDecimal.valueOf(d).setScale(decimalPlace, BigDecimal.ROUND_DOWN).floatValue();
    }
}
