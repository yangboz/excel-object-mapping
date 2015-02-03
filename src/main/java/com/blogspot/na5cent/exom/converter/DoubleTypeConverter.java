/*
 * code https://github.com/jittagornp/excel-object-mapping
 */
package com.blogspot.na5cent.exom.converter;

import java.math.BigDecimal;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @author redcrow
 */
public class DoubleTypeConverter implements TypeConverter<Double>
{

    // private static final Logger LOG = LoggerFactory.getLogger(DoubleTypeConverter.class);
    private static Logger LOG = LogManager.getLogger(DoubleTypeConverter.class);

    @Override
    public Double convert(Object value, String... pattern)
    {
        if (value == null) {
            return null;
        }

        if (value instanceof Double) {
            return (Double) value;
        }

        if (value instanceof String) {
            try {
                return Double.valueOf(((String) value).trim());
            } catch (Exception ex) {
                LOG.warn(ex.toString());
                return null;
            }
        }

        if (value instanceof BigDecimal) {
            return ((BigDecimal) value).doubleValue();
        }

        return null;
    }

}
