package com.wewebu.ow.server.ecmimpl.alfresco.bpm.rest.beans;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

/**
 *<p>
 * A JSON list of ProcessDefinitions as returned by the /process-definition API call.
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
 *@since 4.2.0.0
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProcessDefinitions extends BasicListResponse<ProcessDefinition>
{

}
