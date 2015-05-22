package com.wewebu.ow.server.ecmimpl.opencmis.propertyclass;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;

import org.apache.chemistry.opencmis.commons.definitions.PropertyIntegerDefinition;

import com.wewebu.ow.server.ecmimpl.opencmis.converter.OwCMISSameTypeConverter;
import com.wewebu.ow.server.ecmimpl.opencmis.converter.OwCMISValueConverter;
import com.wewebu.ow.server.ecmimpl.opencmis.field.OwCMISBigIntegerTextFormat;
import com.wewebu.ow.server.ecmimpl.opencmis.field.OwCMISFormat;
import com.wewebu.ow.server.ecmimpl.opencmis.field.OwCMISJavaTextFormat;
import com.wewebu.ow.server.ecmimpl.opencmis.objectclass.OwCMISNativeObjectClass;
import com.wewebu.ow.server.field.OwSearchOperator;

/**
 *<p>
 * OwCMISIntegerPropertyClassImpl.
 *</p>
 *
 *<p><font size="-2">
 * Alfresco Workdesk<br/>
 * Copyright (c) Alfresco Software, Inc.<br/>
 * All rights reserved.<br/>
 * <br/>
 * For licensing information read the license.txt file or<br/>
 * go to: http://wiki.alfresco.com<br/>
 *</font></p>
 */
public class OwCMISIntegerPropertyClassImpl extends OwCMISAbstractNativePropertyClass<BigInteger, BigInteger, PropertyIntegerDefinition> implements OwCMISIntegerPropertyClass
{

    private static final List<Integer> OPERATORS = Arrays.asList(OwSearchOperator.CRIT_OP_EQUAL, OwSearchOperator.CRIT_OP_NOT_EQUAL, OwSearchOperator.CRIT_OP_LESS, OwSearchOperator.CRIT_OP_LESS_EQUAL, OwSearchOperator.CRIT_OP_GREATER,
            OwSearchOperator.CRIT_OP_GREATER_EQUAL, OwSearchOperator.CRIT_OP_IS_IN, OwSearchOperator.CRIT_OP_IS_NOT_IN);

    public OwCMISIntegerPropertyClassImpl(String className, PropertyIntegerDefinition propertyDefinition, OwCMISNativeObjectClass<?, ?> objectClass)
    {
        this(className, propertyDefinition, new OwCMISSameTypeConverter<BigInteger>(BigInteger.class), objectClass);
    }

    public OwCMISIntegerPropertyClassImpl(String className, PropertyIntegerDefinition propertyDefinition, OwCMISValueConverter<BigInteger, BigInteger> converter, OwCMISNativeObjectClass<?, ?> objectClass)
    {
        super(className, propertyDefinition, converter, BigInteger.class, OPERATORS, objectClass);

    }

    @Override
    public Object getMaxValue() throws Exception
    {
        return getNativeType().getMaxValue();
    }

    @Override
    public Object getMinValue() throws Exception
    {
        return getNativeType().getMinValue();
    }

    @Override
    public OwCMISFormat getFormat()
    {
        return new OwCMISJavaTextFormat(new OwCMISBigIntegerTextFormat(), BigInteger.class);
    }

}