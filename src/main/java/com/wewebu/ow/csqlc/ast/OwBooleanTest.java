package com.wewebu.ow.csqlc.ast;

/**
 *<p>
 * SQL AST node : &lt;boolean test&gt; syntax non-terminal as defined by the SQL grammar.<br/>
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
public abstract class OwBooleanTest extends OwBooleanFactor
{

    /**
     * 
     * @return a {@link StringBuilder} filled with the string representation of this non-terminal
     */
    public abstract StringBuilder createBooleanTestSQLString();

    public final StringBuilder createBooleanFactorSQLString()
    {
        return createBooleanTestSQLString();
    }

    public OwBooleanTest asBooleanTest()
    {
        return this;
    }
}
