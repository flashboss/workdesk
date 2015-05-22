package com.wewebu.ow.csqlc.ast;

import java.util.List;

/**
 *<p>
 * SQL AST node : &lt;table reference&gt; syntax non-terminal as defined by the SQL grammar.<br/>
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
 *@since 3.2.0.0
 */
public interface OwTableReference
{
    /**
     * 
     * @return a {@link StringBuilder} filled with the String representation of this table reference
     */
    StringBuilder createTableReferenceSQLString();

    List<OwColumnQualifier> getColumnQualifiers();

    OwColumnQualifier getMainTableQualifier();

}
