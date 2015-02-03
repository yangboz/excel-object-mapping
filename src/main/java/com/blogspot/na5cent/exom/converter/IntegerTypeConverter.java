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
public class IntegerTypeConverter implements TypeConverter<Integer>
{

    // private static final Logger LOG = LoggerFactory.getLogger(IntegerTypeConverter.class);
    private static Logger LOG = LogManager.getLogger(IntegerTypeConverter.class);

    @Override
    public Integer convert(Object value, String... pattern)
    {
        if (value == null) {
            return null;
        }

        if (value instanceof Integer) {
            return (Integer) value;
        }

        if (value instanceof String) {
            try {
                return Integer.valueOf(((String) value).trim());
            } catch (Exception ex) {
                LOG.warn(ex.toString());
                return null;
            }
        }

        if (value instanceof BigDecimal) {
            return ((BigDecimal) value).intValue();
        }

        return null;
    }

}
