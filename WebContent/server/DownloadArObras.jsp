<%@ page language="java" contentType="text/html; charset=ISO-8859-1"   pageEncoding="ISO-8859-1"%>
<jsp:useBean id="cuentas" class="modulo.serverRN.Mv_obras_ejecucionRN" scope="page"> <%--session page --%>
	 <jsp:setProperty name="cuentas" property="*" />
</jsp:useBean> 
<%  
	cuentas.setParam1(request.getParameter("param1"));
	cuentas.setParam2(request.getParameter("param2"));
	cuentas.setParam3(request.getParameter("param3"));
	cuentas.setParam4(request.getParameter("param4"));
	cuentas.setParam5(request.getParameter("param5"));
	cuentas.setParam6(request.getParameter("param6"));
	out.print(cuentas.downloadArObrasAsync());
%>