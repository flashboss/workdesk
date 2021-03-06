package com.wewebu.ow.csqlc.ast;

import java.util.List;

/**
 *<p>
 * SQL AST node :  &lt;select list&gt; syntax non-terminal as defined by the SQL grammar.<br/>
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
public interface OwSelectList
{
    /**
     * 
     * @return the SQL string representation of this select list
     */
    StringBuilder createSelectListSQLString();

    List<OwColumnQualifier> getColumnQualifiers();

    /**
     * @param tableName
     * @param columnReferenceName
     * @return true if tableName.columnName is part of this statement's select.
     */
    boolean containsColumnReference(String tableName, String columnReferenceName);
}
