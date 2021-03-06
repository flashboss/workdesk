package com.wewebu.ow.server.ecmimpl.opencmis.users.alfresco;

import org.restlet.resource.ClientProxy;
import org.restlet.resource.Get;

import com.wewebu.ow.server.ecmimpl.opencmis.users.alfresco.dao.GroupsList;

/**
 *<p>
 * Model of the /service/api/groups resource.
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
 *@since 4.1.1.0
 */
public interface ListGroupsResource extends ClientProxy
{
    @Get
    GroupsList list();
}
