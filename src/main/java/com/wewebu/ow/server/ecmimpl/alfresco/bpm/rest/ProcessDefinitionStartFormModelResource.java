package com.wewebu.ow.server.ecmimpl.alfresco.bpm.rest;

import org.restlet.resource.ClientProxy;

import com.wewebu.ow.server.ecmimpl.alfresco.bpm.rest.beans.VariablesDefinitions;

/**
 *<p>
 * Models the /process-definitions/{process-definition-id}/start-form-model resource.
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
 *@since 4.2.0.0.0
 */
public interface ProcessDefinitionStartFormModelResource extends ClientProxy, Listable<VariablesDefinitions>
{

}
