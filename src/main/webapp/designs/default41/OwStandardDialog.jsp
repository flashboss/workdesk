<%@ page
    import="com.wewebu.ow.server.ui.*, com.wewebu.ow.server.app.*, com.wewebu.ow.server.util.*"
    autoFlush   ="true"
 pageEncoding="utf-8" contentType="text/html; charset=utf-8" language="java"

%><%
    // get a reference to the calling view
    OwLayout m_View = (OwLayout)request.getAttribute(OwView.CURRENT_MODULE_KEY);
%>
	<div id="OwStandardDialog">
		<div id="OwMainLayout_NAVIGATION"><%-- 
			<span class="OwMainLayout_edge OwMainLayout_topLeft"><!-- --></span>
			<span class="OwMainLayout_edge OwMainLayout_topRight"><!-- --></span>
		--%></div>

	    <div id="OwStandardDialog_Header">
	        <div id="OwStandardDialog_INFO_ICON"><% m_View.renderRegion(out,OwStandardDialog.INFO_ICON_REGION); %></div>

	        <div id="OwStandardDialog_BTN">
	        	<span class="OwStandardDialog_CLOSE_BTN"><% m_View.renderRegion(out,OwStandardDialog.CLOSE_BTN_REGION); %></span>

<%           if ( m_View.isRegion(OwStandardDialog.HELP_BTN_REGION) ) { %>
	        	<span class='OwStandardDialog_HELP_BTN'><% m_View.renderRegion(out,OwStandardDialog.HELP_BTN_REGION); %></span>

<%           } %>
			</div>
<%           if ( m_View.isRegion(OwStandardDialog.TITLE_REGION) ) { %>
	            <h1><% m_View.renderRegion(out,OwStandardDialog.TITLE_REGION); %></h1>

<%           } %>
            <div class="break"><!-- --></div>
    	</div>

      <div id="OwMainLayout_MAIN">
<%       if ( m_View.isRegion(OwStandardDialog.MENU_REGION) ) { %>
			<div class="OwStandardDialog_MENU">
<%                  m_View.renderRegion(out,OwStandardDialog.MENU_REGION); %>
			</div>
<%       } %>
		<div class="OwStandardDialog_MAIN">
<%           if ( m_View.isRegion(OwStandardDialog.LEFT_REGION) || m_View.isRegion(OwStandardDialog.RIGHT_REGION) ) { %>
				<div id="OwSubLayout_Div">
<%                  if ( m_View.isRegion(OwStandardDialog.LEFT_REGION) ) { %>
						<div id="OwSubLayout_NAVIGATION"><% m_View.renderRegion(out,OwStandardDialog.LEFT_REGION); %></div>
<%                  } %>

					<div id="OwSubLayout_MAIN"><% m_View.renderRegion(out,OwStandardDialog.MAIN_REGION); %></div>

<%                   if ( m_View.isRegion(OwStandardDialog.RIGHT_REGION) ) { %>
						<div id="OwSubLayout_NAVIGATION"><% m_View.renderRegion(out,OwStandardDialog.RIGHT_REGION); %></div>
<%                  } %>
				</div>

<%           } else { 
                   m_View.renderRegion(out,OwStandardDialog.MAIN_REGION); 
             } %>
		</div>

<%       if ( m_View.isRegion(OwStandardDialog.FOOTER_REGION) ) { %>
			<div class="OwStandardDialog_MENU">
<%             m_View.renderRegion(out,OwStandardDialog.FOOTER_REGION); %>
			</div>
<%       } %>
	</div>
	<div id="OwMainLayout_MAIN_endstrip"><%--
 		<span class='OwMainLayout_edge OwMainLayout_bottomLeft'><!-- --></span>
		<span class='OwMainLayout_edge OwMainLayout_bottomRight'><!-- --></span>
--%></div>
</div>