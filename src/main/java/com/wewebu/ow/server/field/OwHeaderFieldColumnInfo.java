package com.wewebu.ow.server.field;

/**
 *<p>
 * Header based Column Description.
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
public interface OwHeaderFieldColumnInfo extends OwFieldColumnInfo
{
    /**
     * 
     * @return String ID of the owner header
     */
    String getHeaderID();
}
