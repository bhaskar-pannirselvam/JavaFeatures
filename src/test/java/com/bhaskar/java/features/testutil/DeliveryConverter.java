package com.bhaskar.java.features.testutil;

import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.params.converter.ArgumentConversionException;
import org.junit.jupiter.params.converter.ArgumentConverter;


public class DeliveryConverter implements ArgumentConverter {
    @Override
    public Object convert(Object source, ParameterContext context) throws ArgumentConversionException {
        if (source == null) {
            throw new ArgumentConversionException("Source is null");
        }
        if (!(source instanceof String)) {
            throw new ArgumentConversionException("Source is not a String");
        }
        String sourceString = (String) source;
        if (sourceString.startsWith("BeanPackage")) {
            return DeliveryTestUtils.beanPackageFromString(sourceString);
        } else if (sourceString.startsWith("CupPackage")) {
            return DeliveryTestUtils.cupPackageFromString(sourceString);
        } else {
            throw new ArgumentConversionException("Unknown delivery type: " + sourceString);
        }
    }
}