<%@ page language="java" contentType="text/html; charset=ISO-8859-1"   pageEncoding="ISO-8859-1"%>
<jsp:useBean id="cuentas" class="modulo.serverRN.Mv_obras_ejecucionRN" scope="page"> <%--session page --%>
	 <jsp:setProperty name="cuentas" property="*" />
</jsp:useBean> 
<%  
	out.print(cuentas.downloadArrTrabajosAsync(request.getParameter("id"), request.getParameter("tipo")));
%>