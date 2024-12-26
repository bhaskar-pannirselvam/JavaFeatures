package com.bhaskar.java.features.testutil;

import com.bhaskar.java.features.switchcase.model.BeanPackage;
import com.bhaskar.java.features.switchcase.model.CupPackage;

public class DeliveryTestUtils {

    public static final String SEPARATOR = ";";

    public static BeanPackage beanPackageFromString(String source) {
        String[] parts = source.replace("BeanPackage(", "").replace(")", "").split(SEPARATOR);
        String origin = parts[0];
        int weight = Integer.parseInt(parts[1].strip());
        return new BeanPackage(origin, weight);
    }

    public static CupPackage cupPackageFromString(String source) {
        String[] parts = source.replace("CupPackage(", "").replace(")", "").split(SEPARATOR);
        int quantity;
        if (parts[0].equals("Integer.MAX_VALUE")) {
            quantity = Integer.MAX_VALUE;
        } else if (parts[0].equals("Integer.MIN_VALUE")) {
            quantity = Integer.MIN_VALUE;
        } else {
            quantity = Integer.parseInt(parts[0]);
        }
        return new CupPackage(quantity);
    }
}
