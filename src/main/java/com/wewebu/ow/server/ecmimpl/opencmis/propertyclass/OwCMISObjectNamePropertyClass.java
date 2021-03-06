package com.wewebu.ow.server.ecmimpl.opencmis.propertyclass;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import com.wewebu.ow.server.ecm.OwResource;
import com.wewebu.ow.server.ecmimpl.opencmis.object.OwCMISObject;
import com.wewebu.ow.server.ecmimpl.opencmis.objectclass.OwCMISObjectClass;
import com.wewebu.ow.server.ecmimpl.opencmis.property.OwCMISStoredVirtualPropertyImpl;
import com.wewebu.ow.server.ecmimpl.opencmis.property.OwCMISVirtualProperty;
import com.wewebu.ow.server.exceptions.OwException;
import com.wewebu.ow.server.field.OwSearchOperator;

/**
 *<p>
 *  {@link OwResource#m_ObjectNamePropertyClass} virtual property class.
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
public class OwCMISObjectNamePropertyClass extends OwCMISAbstractStoredPropertyClass<String, OwCMISObjectClass>
{

    private static final List<Integer> OPERATORS = Arrays.asList(OwSearchOperator.CRIT_OP_LIKE, OwSearchOperator.CRIT_OP_NOT_LIKE, OwSearchOperator.CRIT_OP_EQUAL, OwSearchOperator.CRIT_OP_NOT_EQUAL);

    public OwCMISObjectNamePropertyClass(OwCMISObjectClass objectClass)
    {
        this(OwResource.m_ObjectNamePropertyClass.getClassName(), objectClass, OPERATORS);
    }

    public OwCMISObjectNamePropertyClass(String className, OwCMISObjectClass objectClass, Collection<Integer> operators)
    {
        super(className, OwResource.m_ObjectNamePropertyClass, operators, objectClass);
    }

    @Override
    public OwCMISVirtualProperty<String> from(OwCMISObject object_p) throws OwException
    {
        return new OwCMISStoredVirtualPropertyImpl<String>(this, object_p, object_p.getName());
    }

}
